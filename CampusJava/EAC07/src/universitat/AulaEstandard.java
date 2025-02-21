/*
 * Classe que defineix una aula estàndard d'una universitat. 
 * Es defineixen pel seu codi, número d'aula i el seu cost per dia.
 */
package universitat;
import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class AulaEstandard {
    private final static Scanner DADES = new Scanner(System.in); // atribut per llegir les dades que introdueixi l'usuari

    private String codi; // private attribute. It can only be accessed inside the class 
    private int numeroAula;
    private double costPerDia;


    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: AulaEstandard
     * 
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public AulaEstandard (String sCodi, int nNumeroAula, double dCostPerDia){
        codi = sCodi;
        numeroAula = nNumeroAula;
        costPerDia = dCostPerDia;
    }


    /*
     * Creem un altre constructor sense parametres d'entrada, el qual crearà l'aula standard a través del totes les dades introduiides per consola
     * 
     */
    public AulaEstandard(){
        codi = this.askForString("Introdueis el codi de l'aula: ", "Codi de l'aula erroni");
        numeroAula = this.askForInteger("Introdueis el número de l'aula: ", "Número de l'aula erroni");
        costPerDia = this.askForDouble("Introdueis el cost per dua de l'aula: ", "Cost per dia de l'aula erroni");
    }

    /*
     * TODO Heu d'implementar tots els mètodes accessors possibles.  
     */
    //Setters
    public void setCodi(String nouCodi){
        codi = nouCodi;
    }

    public void setNumeroAula(int nouNumeroAula){
        numeroAula = nouNumeroAula;
    }

    public void setCostPerDia(double nouCostPerDia){
        costPerDia = nouCostPerDia;
    }

    //Getters
    public String getCodi(){ return codi; }
    public int getNumeroAula(){ return numeroAula; }
    public double getCostPerDia(){ return costPerDia; }

    /*
    * TODO
    *
    * Nom del mètode: addAulaEstandard
    *
    * Accions:
    * - Demanar a l'usuari les dades per consola per crear una nova 
    *   AulaEstandard. Les dades a demanar són les que necessita 
    *   el constructor.
    *
    * Retorn: Objecte AulaEstandard creat.
    */
    public static AulaEstandard addAulaEstandard(){

        return new AulaEstandard();

    }

    /*
     * TODO
     *
     * Nom del mètode: updateAulaEstandard
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de l'aula actual i
     *   modificar els atributs corresponents d'aquesta aula.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     * 
     * Retorn: cap
     */
     public void updateAulaEstandard(){
        String nouCodi = this.askForString("Introdueis el codi de l'aula: ", "Codi de l'aula erroni");
        int nouNumeroAula = this.askForInteger("Introdueis el número de l'aula: ", "Número de l'aula erroni");
        double nouCostPerDia = this.askForDouble("Introdueis el cost per dua de l'aula: ", "Cost per dia de l'aula erroni");

        System.out.println("Nou codi: " + nouCodi);
        System.out.println("Nou número d'aula: " + nouNumeroAula);
        System.out.println("Nou Cost per dia: " + nouCostPerDia);

        this.codi = nouCodi;
        this.numeroAula = nouNumeroAula;
        this.costPerDia = nouCostPerDia;
    }


    
    /*
     * TODO
     *
     * Nom del mètode: showAulaEstandard
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode per mostrar les dades de l'aula actual i el seu cost de manteniment.
     * 
     * Retorn: cap
     */
    public void showAulaEstandard(){

        System.out.println("Codi de l'aula: " + this.codi);
        System.out.println("Número d'aula: " + this.numeroAula);
        System.out.println("Nou Cost per dia: " + this.costPerDia);

    }



    /*
     * TODO
     *
     * Nom del mètode: costManteniment
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode que calcula el cost de manteniment del AulaEstandard actual
     *   a partir del seu cost per dia (inclou manteniment, neteja...)
     *   El cost de manteniment per dia és un 20% del cost per dia de l'aula
     * 
     * Retorn: cost de manteniment de l'aula (double).
     */
    
    /*
     * 
     * Métodes auxiliars
     * 
     */


    // Métode per preguntar pel codi d'una aula
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
    
    // Métode per preguntar pel numero d'una aula
    private int askForInteger(String message, String errorMessage) {

        int inputInt;
        boolean correct;
        do {
            System.out.print(message + "\n");
            correct = this.DADES.hasNextInt();
            if (!correct) {
                this.DADES.next();
                System.out.println(errorMessage);
            }
        } while (!correct);
        inputInt = this.DADES.nextInt();
        this.DADES.nextLine();
        return inputInt;
    }


    // Métode per preguntar pel cost per aula
    private double askForDouble(String message, String errorMessage) {

        double inputDouble;
        boolean correct;
        do {
            System.out.print(message + "\n");
            correct = this.DADES.hasNextDouble();
            if (!correct) {
                this.DADES.next();
                System.out.println(errorMessage);
            }
        } while (!correct);
        inputDouble = this.DADES.nextDouble();
        this.DADES.nextLine();
        return inputDouble;
    }


}