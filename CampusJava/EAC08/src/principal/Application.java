package principal;

import universitat.AulaEstandard;
import universitat.AulaInformatica;
import universitat.Laboratori;
import universitat.Universitat;
import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class Application {
    private final static Scanner DADES = new Scanner (System.in);

    private static Universitat[] universitats = new Universitat[10];
    private static int pUniversitats = 0; //Primera posició buida del vector universitats
    private static Universitat universitatActual = null;

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nMenú principal. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió d'universitats");
            System.out.println("\n2. Gestió de campus");
            // Menu especifics per aules:
            System.out.println("\n3. Gestió d'aules estàndard");
            System.out.println("\n4. Gestió d'aules informàtica");
            System.out.println("\n5. Gestió de laboratoris");
            
            
            System.out.println("\n");       

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuUniversitats();
                    break;
                case 2:
                    if (universitatActual != null) {
                        menuCampus();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la universitat al menú 1. Gestió de la universitat.");
                    }
                    break;
                case 3:
                    if (universitatActual != null) {
                        menuAules(1); // accedim al menu d'aules amb el paràmetre 1 - "Aula estàndard"
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el campus al menú 1. Gestió de campus.");
                    }
                    break;
                case 4:
                    if (universitatActual != null) {
                        menuAules(2); // accedim al menu d'aules amb el paràmetre 2 - "Aula informatica"
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el campus al menú 1. Gestió de campus.");
                    }
                    break;
                case 5:
                    if (universitatActual != null) {
                        menuAules(3); // accedim al menu d'aules amb el paràmetre 3 - "Laboratori"
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el campus al menú 1. Gestió de campus.");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuUniversitats() {
        int opcio;

        do {
            int indexSel;
            System.out.println("\nMenú d'universitats. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llistar");
            System.out.println("\n");  

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    Universitat novaUniversitat = Universitat.addUniversitat();

                    indexSel = selectUniversitat(novaUniversitat);

                    if (indexSel == -1) {
                        universitats[pUniversitats] = novaUniversitat;
                        pUniversitats++;
                    } else {
                        System.out.println("\nLa universitat ja existeix");
                    }

                    break;
                case 2:
                    indexSel = selectUniversitat(null);

                    if (indexSel >= 0) {
                        universitatActual = universitats[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquesta universitat");
                    }
                    break;
                case 3:
                    indexSel = selectUniversitat(null);

                    if (indexSel >= 0) {
                        universitats[indexSel].updateUnitatUniversitat();
                    } else {
                        System.out.println("\nNo existeix aquesta universitat");
                    }
                    break;
                case 4:
                    for (int i = 0; i < pUniversitats; i++) {
                        universitats[i].showUnitatUniversitat();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     * 
     * Nom del mètode: menuCampus
     *     
     * Heu de desenvolupar el menu Campus amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut universitatActual no és null.
     * 
     * Opció 0. Sortir          --> Surt del menú i retorna al menú principal.
     * Opció 1. Alta            --> Crea un Campus de la universitat actual. Noteu que Universitat sap crear Campus.        
     * Opció 2. Modificar       --> Permet modificar un Campus de la universitat actual.
     * (per comprovar l'existència d'un campus tenim un mètode en la classe Universitat que ens ajuda).
     * Opció 3. Llista Campus   --> Imprimeix les dades dels campus del campus actual.
     * 
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida.
     *
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions.
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge.
     * "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter.
     */
    public static void menuCampus() {
        int opcio;

        do {
            System.out.println("\nMenú de campus. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar");
            System.out.println("\n");  

            opcio = Integer.parseInt(DADES.nextLine());
            
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    universitatActual.addCampus();
                    break;
                case 2:
                    int indexSel = universitatActual.selectCampus(null);

                    if (indexSel >= 0) {
                        universitatActual.getCampus()[indexSel].updateUnitatUniversitat();
                    } else {
                        System.out.println("\nNo existeix aquest Campus");
                    }
                    break;
                case 3:
                    for (int i = 0; i < universitatActual.getpCampus(); i++) {
                        universitatActual.getCampus()[i].showUnitatUniversitat();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }



    /*
     * 
     * Nom del mètode: menu Aules 
     *     
     * Heu de desenvolupar el menuAules amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut universitatActual no és null
     * 
     * Input parameters:
     * Aula estàndard = 1, Aula informatica= 2 i Laboratori=3
     * 
     * 
     * Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     * Opció 1. Alta -->         Crea Aula de la universitat actual afegint-la a un Campus i segons el tipus indicat. 
     *                           Penseu que Universitat sap afegir Aules a un Campus seleccionat.       
     * Opció 2. Modificar -->    Permet modificar Aules de la universitat actual. Penseu que totes les 
     *                           AulesEstandard d'una universitat pertanyen a un campus d'aquesta universitat i que 
     *                           Universitat sap modificar Aula que pertany a un dels seus Campus.
     * Opció 3. Llista AulesEstandard --> Imprimeix les dades de totes les Aules d'un tipus de la universitat actual.
     *  
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     *
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions
     * - si no s'ha introduït cap opció de la llista, s'ha de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter
     */
    public static void menuAules(int tipus) {
        
        int opcio;
        String tipusAulaText = ""; 

        switch (tipus) {
            case 0:
                break;
            case 1:
                tipusAulaText = "Aula estàndard";
                break;
            case 2:
                tipusAulaText = "Aula informàtica";
                break;
            case 3:
                tipusAulaText = "Laboratori";
                break;
            default:
                System.out.println("\nNo s'ha seleccionat un tipus d'aula correcte.");
                break;
        }

        do {

            System.out.println("\nMenú d'aules tipus " + tipusAulaText + ". Selecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar");
            System.out.println("\n");  

            opcio = Integer.parseInt(DADES.nextLine());

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    switch (tipus) {
                        case 1:
                            universitatActual.addAulaEstandardCampus();
                            break;
                        case 2:
                            universitatActual.addAulaInformaticaCampus();
                            break;
                        case 3:
                            universitatActual.addLaboratoriCampus();
                            break;
                        default:
                            System.out.println("\nNo s'ha seleccionat un tipus d'aula correcte.");
                            break;
                    }
                    break;
                case 2:
                    switch (tipus) {
                        case 1:
                            universitatActual.updateAulaEstandardCampus();
                            break;
                        case 2:
                            universitatActual.updateAulaInformaticaCampus();
                            break;
                        case 3:
                            universitatActual.updateLaboratoriCampus();
                            break;
                        default:
                            System.out.println("\nNo s'ha seleccionat un tipus d'aula correcte.");
                            break;
                    }
                    break;

                case 3:
                    // Nomes mostrem les aules del tipus segons el menu on ens trobem
                    switch (tipus) {
                        case 1:
                            for (int i = 0; i < universitatActual.getpCampus(); i++) {

                                for (int j = 0; j < universitatActual.getCampus()[i].getpAula(); j++) {
                                    
                                    if (universitatActual.getCampus()[i].getAules()[j] instanceof AulaEstandard){
                                        universitatActual.getCampus()[i].getAules()[j].showUnitatUniversitat();
                                    }
                                    
                                }
                            }
                            break;
                        case 2:
                            for (int i = 0; i < universitatActual.getpCampus(); i++) {

                                for (int j = 0; j < universitatActual.getCampus()[i].getpAula(); j++) {
                                    
                                    if (universitatActual.getCampus()[i].getAules()[j] instanceof AulaInformatica){
                                        universitatActual.getCampus()[i].getAules()[j].showUnitatUniversitat();
                                    }
                                    
                                }
                            }
                            break;
                        case 3:
                            for (int i = 0; i < universitatActual.getpCampus(); i++) {

                                for (int j = 0; j < universitatActual.getCampus()[i].getpAula(); j++) {
                                    
                                    if (universitatActual.getCampus()[i].getAules()[j] instanceof Laboratori){
                                        universitatActual.getCampus()[i].getAules()[j].showUnitatUniversitat();
                                    }
                                    
                                }
                            }
                            break;
                        default:
                            System.out.println("\nNo s'ha seleccionat un tipus d'aula correcte.");
                            break;
                    }
                    break;

                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }



    public static Integer selectUniversitat(Universitat Universitat) {
        String nom;

        if (Universitat == null) {
            System.out.println("\nNom de la universitat:");
            nom = DADES.nextLine();
        } else {
            nom = Universitat.getNomUniversitat();
        }

        for (int i = 0; i < pUniversitats; i++) {
            if (universitats[i].getNomUniversitat().equals(nom)) {
                return i;
            }
        }

        return -1;
    }
}
