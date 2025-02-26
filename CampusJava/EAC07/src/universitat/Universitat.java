/*
 * Classe que defineix una universitat, que es defineix pel seu nom,
 * la seva ubicació i un array de campus.
 */

package universitat;

import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class Universitat {

    private final static Scanner DADES = new Scanner(System.in);

    private String nomUniversitat;
    private String ubicacioSeu;
    private Campus[] campus = new Campus[5];
    private int pCampus = 0; //Primera posició buida de l'array de campus

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: Universitat
     *
     * Paràmetres: valors per tots els atributs de la classe menys els arrays.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public Universitat(String sNomUniversitat, String sUbicacioSeu){
        nomUniversitat = sNomUniversitat;
        ubicacioSeu = sUbicacioSeu;
    }    
    

    /*
     * Creem un altre constructor sense parametres d'entrada, el qual crearà un campus a través del totes les dades introduiides per consola
     * 
     */
    public Universitat(){
        nomUniversitat = this.askForString("Introdueix el nom de la universitat: ", "Nom de la universitat erroni");
        ubicacioSeu = this.askForString("Introdueix la ubicació de la seu de la universitat: ", "Codi de la ubicacio erroni");
    }

    /**
     * TODO Heu d'implementar tots els mètodes accessors possibles.
     */

    //Setters
    public void setNomUniversitat(String nouNomUniversitat){
        this.nomUniversitat = nouNomUniversitat;
    }

    public void setUbicacioSeu(String nouUbicacioSeu){
        this.ubicacioSeu = nouUbicacioSeu;
    }

    public void setCampus(Campus[] campus){
        this.campus = campus;
    }

    public void setpCampus(int pCampus){
        this.pCampus = pCampus;
    }
    //Getters
    public String getNomUniversitat(){ return this.nomUniversitat; }
    public String getUbicacioSeu(){ return this.ubicacioSeu; }
    public Campus[] getCampus(){ return this.campus; }
    public int getpCampus(){ return this.pCampus; }
    /**
     * TODO
     *
     * Nom del mètode: addUniversitat
     *
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear una nova universitat.
     *   Les dades a demanar són les que necessita el constructor.
     * 
     * Retorn: Objecte Universitat creat.
     */
    public static Universitat addUniversitat(){
        return new Universitat();
    }

    /**
     * TODO
     *
     * Nom del mètode: updateUniversitat
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de la universitat i
     *   modificar els atributs corresponents d'aquesta universitat. 
     *   Els únics atributs que modificarem
     *   són els que hem inicialitzat en el constructor amb els paràmetres passats.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     * 
     * Retorn: cap
     */
    public void updateUniversitat(){
        String nouNomUniversitat = this.askForString("Introdueix el nou nom de la universitat: ", "Codi de l'aula erroni");
        String novaUbicacioSeu = this.askForString("Introdueix la nova ubicació de la seu de la universitat: ", "Número de l'aula erroni");

        System.out.println("Nou nom de la universitat: " + nouNomUniversitat);
        System.out.println("Nova ubicació de la seu: " + novaUbicacioSeu);

        this.nomUniversitat = nouNomUniversitat;
        this.ubicacioSeu = novaUbicacioSeu;
    }     
    

    /**
     * TODO
     *
     * Nom del mètode: costManteniment
     *  
     * Paràmetres: cap
     * 
     * Accions:
     * - Calcular cost de manteniment dels campus de la universitat a partir dels costos de manteniment
     *   de tots els campus de la universitat.
     * 
     * Retorn: Cost de manteniment total de la universitat (double).
     */
    
    public double costManteniment(){
        double costTotal = 0.0;
        
        // loop from index 0 to first position without null element in the array
        for (int i = 0; i < this.pCampus; i++) {
            costTotal = costTotal + this.campus[i].costManteniment();
        }

        return costTotal;
    }

    /**
     * TODO
     *
     * Nom del mètode: showUniversitat
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode per imprimir les dades de la universitat actual i el cost del seu manteniment.
     * 
     * Retorn: cap
     */
 
    public void showUniversitat(){

        System.out.println("Nom de la universitat: " + this.nomUniversitat);
        System.out.println("Ubicació de la seu: " + this.ubicacioSeu);
        
        System.out.println("Cost manteniment : " + this.costManteniment());
    }  

    /**
     * Campus
     * 
     * TODO
     *
     * Nom del mètode: addCampus
     *  
     * Paràmetres: cap
     * 
     * Accions:
     * - Afegeix un nou campus a l'array de campus de la universitat
     *   si aquest no existeix. 
     *   Per afegir-lo heu de fer servir el mètode de la classe Campus escaient
     *   i per comprovar la seva existència el mètode d'aquesta classe que ens
     *   ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de campus si s'afegeix el campus. 
     * - Mostra el missatge "El campus ja existeix" si no s'ha afegit.
     * 
     * Retorn: cap
     */
    public void addCampus(){
        
        Campus campus = Campus.addCampus();
        String nomCampus = campus.getNomCampus();
        int posCampus = this.selectCampus(nomCampus);

        // si no troba el campus entre els existens vol dir que l'hem d'afegir a l'array de campus de la universitat
        if (posCampus == -1){
            this.campus[this.getpCampus()] = campus;
            // nova posicio
            int novaPos = this.pCampus+1;
            this.setpCampus(novaPos);         
        } else{
            System.out.println("El campus ja existeix");
        }

    }

    /**
     *
     * Nom del mètode: selectCampus
     *
     * Paràmetres: cap
     * 
     * Accions:
     * - Seleciona un campus de l'array de campus de la universitat
     *   a partir del seu nom.
     * 
     * Retorn: La posició del campus seleccionat o -1 si no existeix.
     */
    public int selectCampus(String nom) {
        if (nom == null) {
            System.out.println("\nNom del campus:");
            nom = DADES.nextLine();
        }

        for (int i = 0; i < pCampus; i++) {
            if (campus[i].getNomCampus().equals(nom)) {
                return i;
            }
        }

        return -1;
    }

    public void addAulaEstandardCampus() {

        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addAulaEstandard();
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void updateAulaEstandardCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexAulaEstandard = campus[indexCampus].selectAulaEstandard(null);

            if (indexAulaEstandard != -1) {
                campus[indexCampus].getAulesEstandard()[indexAulaEstandard].updateAulaEstandard();
            } else {
                System.out.println("\nL'aula estàndard no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void addAulaInformaticaCampus() {
        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addAulaInformatica();
        } else {
            System.out.println("\nLEl campus no existeix");
        }
    }

    public void updateAulaInformaticaCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexAulaInformatica = campus[indexCampus].selectAulaInformatica(null);

            if (indexAulaInformatica != -1) {
                campus[indexCampus].getAulesInformatica()[indexAulaInformatica].updateAulaInformatica();
            } else {
                System.out.println("\nL'aula d'informàtica no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void addLaboratoriCampus() {
        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addLaboratori();
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void updateLaboratoriCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexLaboratori = campus[indexCampus].selectLaboratori(null);

            if (indexLaboratori != -1) {
                campus[indexCampus].getLaboratoris()[indexLaboratori].updateLaboratori();
            } else {
                System.out.println("\nEl laboratori no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }


    /*
     * 
     * Métodes auxiliars
     * 
     */

    // Métode per preguntar pel nom de la universita i la ubicació de la seva seu
    private String askForString(String message, String errorMessage){
        System.out.println(message);
        String inputText = this.DADES.nextLine();
        while (inputText.isEmpty()){
            System.out.println(errorMessage);
            System.out.println(message);
            inputText = this.DADES.nextLine();
        }
        return inputText;
    }



}
