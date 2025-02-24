/*
 * Classe que defineix un Laboratori d'una universitat.
 * Es defineix pel seu codi, numeroLaboratori, cost per dia i la seva capacitat en nombre de persones.
 */
package universitat;

import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class Laboratori {

    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private int numeroLaboratori;
    private double costPerDia;
    private int capacitat;

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: Laboratori
     *
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public Laboratori(String sCodi, int nNumeroLaboratori, double dCostPerDia, int nCapacitat){
        codi = sCodi;
        numeroLaboratori = nNumeroLaboratori;
        costPerDia = dCostPerDia;
        capacitat = nCapacitat;
    }   
    

    /*
     * Creem un altre constructor sense parametres d'entrada, el qual crearà un laboratori a través del totes les dades introduiides per consola
     * 
     */
    public Laboratori(){
        codi = this.askForString("Introdueix el codi del laboratori: ", "Codi del laboratori erroni");
        numeroLaboratori = this.askForInteger("Introdueix el número del laboratori: ", "Número del laboratori erroni");
        costPerDia = this.askForDouble("Introdueix el cost per dia del laboratori: ", "Cost per dia del laboratori erroni");
        capacitat = this.askForInteger("Introdueix la capacitat del laboratori: ", "Capacitat del laboratori erronia");
    }


    /*
     * TODO Heu d'implementar tots els mètodes accessors possibles.  
     */
    //Setters
    public void setCodi(String nouCodi){
        this.codi = nouCodi;
    }

    public void setNumeroLaboratori(int nouNumeroLaboratori){
        this.numeroLaboratori = nouNumeroLaboratori;
    }

    public void setCostPerDia(double nouCostPerDia){
        this.costPerDia = nouCostPerDia;
    }

    public void setCapacitat(int novaCapacitat){
        this.capacitat = novaCapacitat;
    }

    //Getters
    public String getCodi(){ return this.codi; }
    public int getNumeroLaboratori(){ return this.numeroLaboratori; }
    public double getCostPerDia(){ return this.costPerDia; }
    public int getCapacitat(){ return this.capacitat; }

    /*
     * TODO
     *
     * Nom del mètode: addLaboratori
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar les dades per consola per crear un Laboratori. 
     *   Les dades a demanar són les que necessita
     *   el constructor.
     * 
     * Retorn: Objecte Laboratori creat.
     */
    public static Laboratori addLaboratori(){
        return new Laboratori();
    }

    /*
     * TODO
     *
     * Nom del mètode: updateLaboratori
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades del Laboratori i modificar els
     *   atributs corresponents d'aquest Laboratori.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     *
     * Retorn: cap
     */
    public void updateLaboratori(){
        String nouCodi = this.askForString("Introdueix el nou codi del laboratori: ", "Codi de l'aula erroni");
        int nouNumeroLaboratori = this.askForInteger("Introdueix el nou número del laboratori: ", "Número de l'aula erroni");
        double nouCostPerDia = this.askForDouble("Introdueix el nou cost per dia del laboratori: ", "Cost per dia de l'aula erroni");
        int novaCapacitat = this.askForInteger("Introdueix els nous metres quadrats del laboratori: ", "Metres quadrats de l'aula erronis");

        System.out.println("Nou codi de laboratori: " + nouCodi);
        System.out.println("Nou número del laboratori: " + nouNumeroLaboratori);
        System.out.println("Nou Cost per dia: " + nouCostPerDia);
        System.out.println("Nou número de metres quadrats del laboratori: " + novaCapacitat);

        this.codi = nouCodi;
        this.numeroLaboratori = nouNumeroLaboratori;
        this.costPerDia = nouCostPerDia;
        this.capacitat = novaCapacitat;
    } 

    /*
     * TODO
     *
     * Nom del mètode: showLaboratori
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode per mostrar les dades del Laboratori actual i el cost del seu manteniment.
     * 
     * Retorn: cap    
     */
    public void showLaboratori(){

        System.out.println("Codi del laboratori: " + this.codi);
        System.out.println("Número del laboratori: " + this.numeroLaboratori);
        System.out.println("Cost per dia del laboratori: " + this.costPerDia);
        System.out.println("Area en m2 del laboratori: " + this.capacitat);

    }  

    /*
     * TODO
     *
     * Nom del mètode: costManteniment
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode que retornarà el cost del manteniment del Laboratori actual.
     * - El cost del manteniment per dia és un 35% del cost per dia del laboratori + un 10% de la seva capacitat
     *
     * Retorn: Cost de manteniment del laboratori actual (double). 
     */
    public double costManteniment(){
        return (this.costPerDia*0.35 + this.capacitat*0.10);
    } 



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
    
    // Métode per preguntar pel numero d'una aula i capacitat
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
