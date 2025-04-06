package principal;

import universitat.Universitat;

import java.util.InputMismatchException;
import java.util.Scanner;

import persistencia.GestorPersistencia;
import universitat.AulaEstandard;
import universitat.AulaInformatica;
import universitat.GestorUniversitatsException;
import universitat.Laboratori;


/**
 *
 */
public class Application {
    private final static Scanner DADES = new Scanner (System.in);

    private static Universitat[] universitats = new Universitat[10];
    private static int pUniversitats = 0; //Primera posició buida del vector universitats
    private static Universitat universitatActual = null;

    // Attributes to handle XML files
    private final static String FITXER = "universitat";
    private static GestorPersistencia gp = new GestorPersistencia();


    public static void main(String[] args) {

        try {
            menuPrincipal();
        } catch (GestorUniversitatsException e) {
            System.out.println (e.getMessage());
        }
    
    }

    private static void menuPrincipal() throws GestorUniversitatsException {
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

            

            //if (!DADES.hasNextInt()) throw new GestorUniversitatsException(1);

            try {
                opcio = Integer.parseInt(DADES.nextLine());
            } catch (InputMismatchException e){
                throw new GestorUniversitatsException("1");
            }
            
            
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    try {
                        menuUniversitats(); // Aqui es on s'escull la universitat a través de l'index d'array. Si es selecciona una universitat fora del rang aquest métode llençarà una exepció
                    } catch (ArrayIndexOutOfBoundsException e){
                        throw new GestorUniversitatsException("2");
                    }
                    break;

                case 2:
                    if (universitatActual != null) {
                        try {
                            menuCampus();
                        } catch (InputMismatchException e){
                            throw new GestorUniversitatsException("1");
                        }
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la universitat al menú 1. Gestió d'universitats.");
                    }
                    break;
                case 3:
                    if (universitatActual != null) {
                        try {
                            menuAules(1);
                        } catch (InputMismatchException e){
                            throw new GestorUniversitatsException("1");
                        }
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la universitat al menú 1. Gestió d'universitats.");
                    }
                    break;
                case 4:
                    if (universitatActual != null) {
                        try {
                            menuAules(2);
                        } catch (InputMismatchException e){
                            throw new GestorUniversitatsException("1");
                        }
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la universitat al menú 1. Gestió d'universitats.");
                    }
                    break;
                case 5:
                    if (universitatActual != null) {
                        try {
                            menuAules(3);
                        } catch (InputMismatchException e){
                            throw new GestorUniversitatsException("1");
                        }
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la universitat al menú 1. Gestió d'universitats.");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuUniversitats() throws GestorUniversitatsException {
        int opcio;

        do {
            int indexSel;
            System.out.println("\nMenú d'universitats. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llistar");
            System.out.println("\n5. Desar universitat");
            System.out.println("\n6. Carregar universitat");
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
                        throw new GestorUniversitatsException("3"); // Si la universitat a afegir ja existeix llencem excepció
                        //System.out.println("\nLa universitat ja existeix");
                    }

                    break;
                case 2:
                    indexSel = selectUniversitat(null); // llençaria una excepcio ArrayIndexOutOFBoundsException si es selecciona un index superior al permes

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
                case 5:
                    // Metode per desar una universitat    

                    break;

                case 6:
                    // Metode per carregar una universitat    

                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }


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
                        universitatActual.getCampus().get(indexSel).updateUnitatUniversitat();
                    } else {
                        System.out.println("\nNo existeix aquest Campus");
                    }
                    break;
                case 3:
                    for (int i = 0; i < universitatActual.getCampus().size(); i++) {
                        universitatActual.getCampus().get(i).showUnitatUniversitat();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

   
     public static void menuAules(int tipus) {
        int opcio;

        do {
            System.out.println("\nMenú d'aules. Selecciona una opció:");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar");
            
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
                    }
                    break;
                case 3:
                    for (int i = 0; i < universitatActual.getCampus().size(); i++) {
                        for (int j = 0; j < universitatActual.getCampus().get(i).getAules().size(); j++) {
                            if (universitatActual.getCampus().get(i).getAules().get(j) instanceof AulaEstandard && tipus == 1 ||
                                universitatActual.getCampus().get(i).getAules().get(j) instanceof AulaInformatica && tipus == 2 ||
                                universitatActual.getCampus().get(i).getAules().get(j) instanceof Laboratori && tipus == 3) {
                                    universitatActual.getCampus().get(i).getAules().get(j).showUnitatUniversitat();
                            }
                        }
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
