package principal;

import universitat.Universitat;


/**
 *
 * @author fgarin
 */
public class Application {

    private static Universitat[] universitats = new Universitat[10];
    private static int Universitat = 0; //Primera posició buida del vector universitats
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
            System.out.println("\n3. Gestió d'aules estàndard");
            System.out.println("\n4. Gestió d'aules d'informàtica");
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
                        System.out.println("\nPrimer s'ha de seleccionar la universitat al menú 1. Gestió d'universitats.");
                    }
                    break;
                case 3:
                    if (universitatActual != null) {
                        menuAulesEstandard();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el campus al menú 1. Gestió de campus.");
                    }
                    break;
                case 4:
                    if (universitatActual != null) {
                        menuAulesInformatica();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar el campus al menú 1. Gestió de campus.");
                    }
                    break;
                case 5:
                    if (universitatActual != null) {
                        menuLaboratoris();
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
                        universitats[pUniversitat] = novaUniversitat;
                        pUniversitat++;
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
                        universitats[indexSel].updateUniversitat();
                    } else {
                        System.out.println("\nNo existeix aquesta universitat");
                    }
                    break;
                case 4:
                    for (int i = 0; i < pUniversitat; i++) {
                        universitats[i].showUniversitat();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     * TODO
     * 
     * Nom del mètode: menuCampus
     *     
     * Heu de desenvolupar el menu Campus amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut universitatActual no és null.
     * 
     * Opció 0. Sortir          --> Surt del menú i retorna al menú principal.
     * Opció 1. Alta            --> Crea una Campus del campus actual. Noteu que Universitat sap crear Campus.        
     * Opció 2. Modificar       --> Permet modificar una Campus del campus actual.
     * (per comprovar l'existència d'una campus tenim un mètode en la classe Universitat que ens ajuda).
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
    

    /*
     * TODO
     * 
     * Nom del mètode: menu Aules Estàndard
     *     
     * Heu de desenvolupar el menuAulesEstandard amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut universitatActual no és null
     * 
     * Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     * Opció 1. Alta -->         Crea Aula estàndard del campus actual afegint-lo a un Campus. 
     *                           Penseu que Universitat sap afegir Aules estàndard a una Campus seleccionat.       
     * Opció 2. Modificar -->    Permet modificar AulaEstàndard del campus actual. Penseu que tots els 
     *                           AulesEstandard d'un campus pertanyen a una Campus d'aquest campus i que 
     *                           Universitat sap modificar AulaEstàndard que pertany a una dels seu Campus.
     * Opció 3. Llista AulesEstandard --> Imprimeix les dades de tots els AulesEstandard del campus actual.
     *  
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     *
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter
     */
    

    /*
     * TODO
     * 
     * Nom del mètode: menuAulesInformatica
     *    
     * Heu de desenvolupar el menuAulesInformatica amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut universitatActual no és null
     * 
     * Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     * Opció 1. Alta -->         Crea una AulaInformatica del campus actual afegint-la a un Campus. 
     *                           Penseu que Universitat sap afegir una AulaInformatica a un Campus seleccionat.       
     * Opció 2. Modificar -->    Permet modificar una AulaInformatica del campus actual. Penseu que totes les 
     *                           AulesInformatica d'un campus pertanyen a una Campus d'aquest Campus i que 
     *                           Universitat sap modificar una AulaInformatica que pertany a una de les seves Campus.
     * Opció 3. Llista AulesInformatica --> Imprimeix les dades de tots/es AulesInformatica del campus actual.
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     * 
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter
     */
    

    /*
     * TODO
     * 
     * Nom del mètode: menuLaboratoris
     *     
     * Heu de desenvolupar el menuLaboratoris amb les opcions que podeu veure.
     * Nota: penseu que quan arribem aquí, l'atribut universitatActual no és null
     * 
     * Opció 0. Sortir -->       Surt del menú i retorna al menú principal
     * Opció 1. Alta -->         Crea una Apartament del campus actual afegint-la a una Campus. 
     *                           Penseu que Universitat sap afegir un Apartament a una Campus seleccionat.       
     * Opció 2. Modificar -->    Permet modificar un Apartament del campus actual. Penseu que totes els 
     *                           Laboratoris d'un campus pertanyen a una Campus d'aquest Campus i que 
     *                           Universitat sap modificar una Apartament que pertany a una dels seus Campus.
     * Opció 3. Llista Laboratoris --> Imprimeix les dades de tots els Laboratoris del campus actual.
     * 
     * A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     * 
     * Recomanacions:
     * - estructura de control switch-case per bifurcar les opcions
     * - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     * - definiu una variable opcio de tipus enter
     */
    

    public static Integer selectUniversitat(Universitat Universitat) {
        String nom;

        if (Universitat == null) {
            System.out.println("\nNom de la universitat:");
            nom = DADES.nextLine();
        } else {
            nom = Universitat.getNomUniversitat();
        }

        for (int i = 0; i < pUniversitat; i++) {
            if (universitats[i].getNomUniversitat().equals(nom)) {
                return i;
            }
        }

        return -1;
    }
}
