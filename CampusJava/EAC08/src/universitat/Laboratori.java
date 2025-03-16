/*
 * Classe que defineix un Laboratori d'una universitat.
 * Es defineix pel seu codi, numero Laboratori, cost per dia i la seva capacitat en nombre de persones.
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
     *
     * Nom del mètode: Laboratori
     *
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public Laboratori(String codi, int numeroLaboratori, double costPerDia, int capacitat) {
        this.codi = codi;
        this.numeroLaboratori = numeroLaboratori;
        this.costPerDia = costPerDia;
        this.capacitat = capacitat;
    }

    public String getCodi() {
        return this.codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

      public int getNumeroLaboratori() {
        return this.numeroLaboratori;
    }

    public void setNumeroLaboratori(int numeroLaboratori) {
        this.numeroLaboratori = numeroLaboratori;
    }

    public double getCostPerDia() {
        return this.costPerDia;
    }

    public void setCostPerDia(int costPerDia) {
        this.costPerDia = costPerDia;
    }

    public int getCapacitat() {
        return this.capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    /*
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
    public static Laboratori addLaboratori() {
        System.out.println("\nCodi del Laboratori: ");
        String codi = DADES.nextLine();

        System.out.println("\nNúmero del Laboratori: ");
        int numeroLaboratori = Integer.parseInt(DADES.nextLine());

        System.out.println("\nCost per dia del Laboratori: ");
        double costPerDia = Integer.parseInt(DADES.nextLine());

        System.out.println("\nCapacitat del Laboratori: ");
        int capacitat = Integer.parseInt(DADES.nextLine());

        return new Laboratori(codi, numeroLaboratori, costPerDia, capacitat);
    }

    /*
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
    public void updateLaboratori() {
        System.out.println("\nCodi del Laboratori: " + this.getCodi());
        System.out.println("Entra el nou valor codi:");
        codi = DADES.nextLine();
       
        System.out.println("\nNúmero del Laboratori: " + this.getNumeroLaboratori());
        System.out.println("Entra el nou valor numeroLaboratori:");
        numeroLaboratori = Integer.parseInt(DADES.nextLine());

        System.out.println("\nCost per dia del Laboratori: " + this.getCostPerDia());
        System.out.println("Entra el nou valor del cost per dia:");
        costPerDia = Integer.parseInt(DADES.nextLine());
        
        System.out.println("\nCapacitat del Laboratori: " + this.getCapacitat());
        System.out.println("Entra el nou valor de la capacitat:");
        capacitat = Integer.parseInt(DADES.nextLine());
    }

    /*
     * Nom del mètode: showLaboratori
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode per mostrar les dades del Laboratori actual i el cost del seu manteniment.
     * 
     * Retorn: cap    
     */
    public void showLaboratori() {
        System.out.println("\nLes dades del Laboratori amb codi " + this.getCodi() + " són:");
        System.out.println("\nNúmero del Laboratori: " + this.getNumeroLaboratori());
        System.out.println("\nCost per dia: " + this.getCostPerDia());
        System.out.println("\nCapacitat: " + this.getCapacitat());
        System.out.println("\nCost de manteniment: " + this.costManteniment() + " EUR");
    }

    /*
     * Nom del mètode: costManteniment
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode que retornarà el cost del manteniment del Laboratori actual.
     * - El cost del manteniment per dia és un 30% del cost per dia del laboratori
     *
     * Retorn: Cost de manteniment del laboratori actual (double). 
     */
    public double costManteniment() {
        return (double) (this.getCostPerDia() * 0.3) + (this.getCapacitat() * 0.05);
    }
}
