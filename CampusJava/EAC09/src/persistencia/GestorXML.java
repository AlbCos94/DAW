package persistencia;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import universitat.Aula;
import universitat.AulaEstandard;
import universitat.AulaInformatica;
import universitat.Campus;
import universitat.GestorUniversitatsException;
import universitat.Laboratori;
import universitat.Universitat;

/**
 *
 */
public class GestorXML implements ProveedorPersistencia {
    private Document doc;
    private Universitat universitat;

    public Document getDoc() {
        return doc;
    }

    public Universitat getUniversitat() {
        return universitat;
    }

    @Override
    public void desarUniversitat(String nomFitxer, Universitat universitat) throws GestorUniversitatsException {
        construeixModel(universitat);
        desarModel(nomFitxer);
    }

    @Override
    public void carregarUniversitat(String nomFitxer) throws GestorUniversitatsException {
        carregarFitxer(nomFitxer);
        llegirFitxerUniversitat();
    }

    /**
     * construeixModel
     * 
     * Paràmetres: Universitat a partir de la qual volem construir el model
     *
     * Acció: 
     * - Llegir els atributs de l'objecte universitat passat per paràmetre per construir 
     *   un model (document XML) sobre el Document doc (atribut de GestorXML).
     *
     * - L'arrel del document XML és "universitat". Aquesta arrel, l'heu d'afegir a doc. Un 
     *   cop fet això, heu de recórrer l'ArrayList campus de la universitat passat per
     *   paràmetre i per a cada campus, afegir un fill a doc. Cada fill tindrà
     *   com atributs els atributs de l'objecte (nom, ubicacio i les aules)
     *
     * - En el cas de les aules de cada campus, heu de recórrer l'ArrayList 
     *   aules del campus corresponent i per a cada aula, afegir un fill a doc,
     *   tenint en compte que hi haurà tres tipus d'elements, un per les aules estàndard, un altre per les
     *   aules d'informàtica i un altre per als laboratoris. Cada fill tindrà com atributs els atributs de 
     *   l'objecte (codi, número d'aula i cost per dia, etc.)
     *
     * - Si heu de gestionar alguna excepció relacionada amb la construcció del model,
     *   heu de llençar una excepció de tipus GestorUniversitatsException amb codi 
     *   "GestorXML.model".
     *
     * Retorn: cap
     */
    public void construeixModel(Universitat universitat) throws GestorUniversitatsException {


        // Construir un model sobre l'atribut "doc"
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            this.doc = builder.newDocument();

        
            // Primer afegir l'element arrel "universitat" al document
            Element arrel = this.doc.createElement("universitat");
            arrel.setAttribute("nom", universitat.getNomUniversitat());
            arrel.setAttribute("ubicacio", universitat.getUbicacioSeu());
            this.doc.appendChild(arrel);

            // Afegir els campus de la universitat com a fills a doc
            for (int i = 0; i < universitat.getCampus().size(); i++) {
                Element campus = doc.createElement("campus");
                campus.setAttribute("nom", universitat.getCampus().get(i).getNomCampus()); // get Campus name
                campus.setAttribute("ubicacio", universitat.getCampus().get(i).getUbicacio()); // get Campus location

                // recorrem l'array d'aules del campus corresponent
                for (int j = 0; j < universitat.getCampus().get(i).getAules().size(); j++) {
                    if (universitat.getCampus().get(i).getAules().get(j) instanceof AulaEstandard) {
                        AulaEstandard aulaEstandard = (AulaEstandard) universitat.getCampus().get(i).getAules().get(j); // inicialitzem indicant que es AulaEstandard

                        Element aula = doc.createElement("aulaEstandard");
                        aula.setAttribute("codi", aulaEstandard.getCodi());
                        aula.setAttribute("numeroAula", String.valueOf(aulaEstandard.getNumeroAula()));
                        aula.setAttribute("costPerDia", String.valueOf(aulaEstandard.getCostPerDia()));

                        campus.appendChild(aula); // once the element has been created we append it to campus
                    } else if( universitat.getCampus().get(i).getAules().get(j) instanceof AulaInformatica) {
                        AulaInformatica aulaInformatica = (AulaInformatica) universitat.getCampus().get(i).getAules().get(j); // inicialitzem indicant que es AulaInformatica
                        
                        Element aula = doc.createElement("aulaInformatica");
                        aula.setAttribute("codi", aulaInformatica.getCodi());
                        aula.setAttribute("numeroAula", String.valueOf(aulaInformatica.getNumeroAula()));
                        aula.setAttribute("areaEnMetresQuadrats", String.valueOf(aulaInformatica.getAreaEnMetresQuadrats()));
                        aula.setAttribute("costPerDia", String.valueOf(aulaInformatica.getCostPerDia()));

                        campus.appendChild(aula); // once the element has been created we append it to campus
                    } else if( universitat.getCampus().get(i).getAules().get(j) instanceof Laboratori) {
                        Laboratori laboratori = (Laboratori) universitat.getCampus().get(i).getAules().get(j); // inicialitzem indicant que es AulaInformatica
                        
                        Element aula = doc.createElement("laboratori");
                        aula.setAttribute("codi", laboratori.getCodi());
                        aula.setAttribute("numeroAula", String.valueOf(laboratori.getNumeroAula()));
                        aula.setAttribute("capacitat", String.valueOf(laboratori.getCapacitat()));
                        aula.setAttribute("costPerDia", String.valueOf(laboratori.getCostPerDia()));

                        campus.appendChild(aula); // once the element has been created we append it to campus
                    } else {

                        throw new GestorUniversitatsException("GestorXML.model");
                    }
                }

                arrel.appendChild(campus); // després de popular totes les aules del campus, afegim el node al node arrel 

            }

        } catch (Exception e){
            throw new GestorUniversitatsException("GestorXML.model");
        }


    }

    public void desarModel(String nomFitxer) throws GestorUniversitatsException {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            File f = new File(nomFitxer + ".xml");
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            throw new GestorUniversitatsException("GestorXML.desar");
        }
    }

    public void carregarFitxer(String nomFitxer) throws GestorUniversitatsException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            File f = new File(nomFitxer + ".xml");
            doc = builder.parse(f);
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            throw new GestorUniversitatsException("GestorXML.carrega");
        }
    }

    /**
     * llegirFitxerUniversitat
     * 
     * Paràmetres: cap
     *
     * Acció: 
     * - Llegir el fitxer del vostre sistema i carregar-lo sobre l'atribut doc, per
     *   assignar valors als atributs de la Universitat i la resta d'objectes que formen els
     *   campus de la Universitat.
     *    
     * - Primer heu de crear l'objecte de la classe Universitat a partir de l'arrel del document XML
     *   per després recórrer el doc i per cada fill, afegir un objecte a l'atribut campus 
     *   de la Universitat mitjançant el mètode escaient de la classe Universitat. Recordeu que com que l'arrel conté
     *   els atributs nom i ubicació de la Universitat, al fer Element arrel = doc.getDocumentElement(); 
     *   ja podeu crear l'objecte de la classe.
     *
     * Retorn: cap
     */
    private void llegirFitxerUniversitat() throws GestorUniversitatsException {

        // "doc" ja conté l'arxiu parsejat per "DocumentBuilderFactory"
        try {
            // Crearem l'objecte Universitat a través de toda la informació continguna al fitxer XML carregat
            
            // Obtencio de l'element arrel del XML per iniciar els recorreguts
            Element arrel = this.doc.getDocumentElement();
            
            this.universitat = new Universitat(arrel.getAttribute("nom"), arrel.getAttribute("ubicacio")); // construim la universitat a través dels atributs de l'element arrel del XML

            // Recorrem els campus:
            NodeList listCampus = arrel.getChildNodes(); // obtenim tots els campus, aqui tambe es troben els atributs de "nom de la universitat" i de la "ubicacio de la uni"
            
            for (int i = 0; i < listCampus.getLength(); i++){
                
                Node nCampus = (Node) listCampus.item(i);

                if (nCampus.getNodeType() == Node.ELEMENT_NODE){ // ens trobem dins element de un campus
                    Element eCampus  = (Element) nCampus;

                    Campus campus = new Campus(eCampus.getAttribute("nom"), eCampus.getAttribute("ubicacio")); // construim el campus amb el seu nom i la seva ubicacio

                    NodeList listAules = eCampus.getChildNodes();

                    for (int j = 0; j < listAules.getLength(); j++){

                        Node nAula = (Node) listAules.item(j);

                        if (nAula.getNodeType() == Node.ELEMENT_NODE){ // ens trobem dins element de un campus

                            Element eAula  = (Element) nAula;

                            if (eAula.getNodeName() == "aulaEstandard"){
                                AulaEstandard novaAula = new AulaEstandard( eAula.getAttribute("codi"), Integer.parseInt(eAula.getAttribute("numeroAula")), Double.parseDouble( eAula.getAttribute("costPerDia")) );
                                campus.addAulaEstandard(novaAula);

                            } else if (eAula.getNodeName() == "aulaInformatica"){
                                AulaInformatica novaAula = new AulaInformatica( eAula.getAttribute("codi"), Integer.parseInt(eAula.getAttribute("numeroAula")), Double.parseDouble( eAula.getAttribute("costPerDia")), Double.parseDouble( eAula.getAttribute("areaEnMetresQuadrats")) );
                                campus.addAulaInformatica(novaAula);(novaAula);
                            } else if (eAula.getNodeName() == "laboratori"){
                                Laboratori novaAula = new Laboratori( eAula.getAttribute("codi"), Integer.parseInt(eAula.getAttribute("numeroAula")), Double.parseDouble( eAula.getAttribute("costPerDia")), Integer.parseInt( eAula.getAttribute("capacitat")) );
                                campus.addLaboratori(novaAula);
                            } else {

                                throw new GestorUniversitatsException("GestorXML.model");
                            }
                        }
                    }
                
                }
                

                //universitat.setCampus  AQUI SE DEBERIA AÑADIR CAMPUS??
                
                
                
            }


        } catch (Exception e){
            throw new GestorUniversitatsException("GestorXML.model");
        }
    }
}
