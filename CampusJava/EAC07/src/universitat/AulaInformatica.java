/*
 * Classe que defineix una aula d'informàtica d'una universitat. 
 * Es defineix pel seu codi, número d'aula, el seu cost per dia i el tamany de l'aula en metres quadrats.
 */
package universitat;

import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class AulaInformatica {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private int numeroAula;
    private double costPerDia;
    private double areaEnMetresQuadrats;

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: AulaInformatica          
     *
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public AulaInformatica(String sCodi, int nNumeroAula, double dCostPerDia, double dAreaEnMetresQuadrats){
        codi = sCodi;
        numeroAula = nNumeroAula;
        costPerDia = dCostPerDia;
        areaEnMetresQuadrats = dAreaEnMetresQuadrats;
    }


    /*
     * Creem un altre constructor sense parametres d'entrada, el qual crearà l'aula d'informatica a través del totes les dades introduiides per consola
     * 
     */
    public AulaInformatica(){
        codi = this.askForString("Introdueix el codi de l'aula: ", "Codi de l'aula erroni");
        numeroAula = this.askForInteger("Introdueix el número de l'aula: ", "Número de l'aula erroni");
        costPerDia = this.askForDouble("Introdueix el cost per dia de l'aula: ", "Cost per dia de l'aula erroni");
        areaEnMetresQuadrats = this.askForDouble("Introdueix els metres quadrats de l'aula: ", "Metres quadrats de l'aula erronis");
    }

    /*
     * TODO Heu d'implementar tots els mètodes accessors possibles.  
     */

    //Setters
    public void setCodi(String nouCodi){
        this.codi = nouCodi;
    }

    public void setNumeroAula(int nouNumeroAula){
        this.numeroAula = nouNumeroAula;
    }

    public void setCostPerDia(double nouCostPerDia){
        this.costPerDia = nouCostPerDia;
    }

    public void setAreaEnMetresQuadrats(double nouAreaEnMetresQuadrats){
        this.areaEnMetresQuadrats = nouAreaEnMetresQuadrats;
    }

    //Getters
    public String getCodi(){ return this.codi; }
    public int getNumeroAula(){ return this.numeroAula; }
    public double getCostPerDia(){ return this.costPerDia; }
    public double getAreaEnMetresQuadrats(){ return this.areaEnMetresQuadrats; }

    /*
     * TODO
     *
     * Nom del mètode: addAulaInformatica
     *
     * Paràmetres: cap
    
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear una nova aula de informatica. Les dades a
     *   demanar són les que necessita el constructor.
     *
     * Retorn: Objecte AulaInformatica creat.
     */
    public static AulaInformatica addAulaInformatica(){
        return new AulaInformatica();
    }

    /*
     * TODO
     *
     * Nom del mètode: updateAulaInformatica
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de l'aula de informatica i modificar els
     *   atributs corresponents d'aquesta aula.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     *
     * Retorn: cap
     */
    public void updateAulaInformatica(){
        String nouCodi = this.askForString("Introdueix el nou codi de l'aula: ", "Codi de l'aula erroni");
        int nouNumeroAula = this.askForInteger("Introdueix el nou número de l'aula: ", "Número de l'aula erroni");
        double nouCostPerDia = this.askForDouble("Introdueix el nou cost per dia de l'aula: ", "Cost per dia de l'aula erroni");
        double nouAreaEnMetresQuadrats = this.askForDouble("Introdueix els nous metres quadrats de l'aula: ", "Metres quadrats de l'aula erronis");

        System.out.println("Nou codi: " + nouCodi);
        System.out.println("Nou número d'aula: " + nouNumeroAula);
        System.out.println("Nou Cost per dia: " + nouCostPerDia);
        System.out.println("Nou número de metres quadrats de l'aula: " + nouAreaEnMetresQuadrats);

        this.codi = nouCodi;
        this.numeroAula = nouNumeroAula;
        this.costPerDia = nouCostPerDia;
        this.areaEnMetresQuadrats = nouAreaEnMetresQuadrats;
    }    

    /*
     * TODO
     *
     * Nom del mètode: showAulaInformatica
     * 
     * Accions:
     * - Mètode per imprimir les dades de l'aula de informatica i el seu cost de manteniment.
     *
     * Retorn: cap
     */
    public void showAulaInformatica(){

        System.out.println("Codi de l'aula: " + this.codi);
        System.out.println("Número d'aula: " + this.numeroAula);
        System.out.println("Cost per dia: " + this.costPerDia);
        System.out.println("Area en m2: " + this.areaEnMetresQuadrats);

    }

    /*
     * TODO
     *
     * Nom del mètode: costManteniment
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode que retornarà el cost de manteniment de l'aula actual. 
     * - El cost de manteniment per dia és un 30% del cost per dia de l'aula + un 5% de la seva àrea
     *
     * Retorn: cost de manteniment de l'aula (double).
     */
    public double costManteniment(){
        return (this.costPerDia*0.3 + this.areaEnMetresQuadrats*0.05);
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


    // Métode per preguntar pel cost per aula i pels metre quadrats
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
