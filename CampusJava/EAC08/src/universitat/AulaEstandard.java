/*
 * Classe que defineix una Aula Estàndard d'una universitat. 
 * Es defineixen pel seu codi, número d'aula i el seu cost per dia
 */
package universitat;

import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class AulaEstandard {
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private int numeroAula;
    private double costPerDia;

    /*
     *
     * Nom del mètode: AulaEstandard
     * 
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
     public AulaEstandard(String codi, int numeroAula, double costPerDia) {
        this.codi = codi;
        this.numeroAula = numeroAula;
        this.costPerDia = costPerDia;
    }

    public String getCodi() {
        return this.codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public int getNumeroAula() {
        return this.numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    public double getCostPerDia() {
        return this.costPerDia;
    }

    public void setcostPerDia(double costPerDia) {
        this.costPerDia = costPerDia;
    }
   
    /*
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
    public static AulaEstandard addAulaEstandard() {
        String codi;
        int numeroAula;
        double costPerDia;

        System.out.println("\nCodi de l'aula estandard: ");
        codi = DADES.nextLine(); 

        System.out.println("\nNúmero de l'aula estandard: ");
        numeroAula = Integer.parseInt(DADES.nextLine());
               
        System.out.println("\nCost per dia de l'aula: ");
        costPerDia = Double.parseDouble(DADES.nextLine());

        return new AulaEstandard(codi, numeroAula, costPerDia);
    }

    /*
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
    public void updateAulaEstandard() {
        System.out.println("\nCodi de l'aula estàndard: " + this.getCodi());
        System.out.println("\nEntra el nou valor del codi d'aula: ");
        codi = DADES.nextLine();

        System.out.println("\nNúmero de l'aula: " + this.getNumeroAula());
        System.out.println("\nEntra el nou valor del número d'aula: ");
        numeroAula = Integer.parseInt(DADES.nextLine());
        
        System.out.println("\nCost per dia de l'aula: " + this.getCostPerDia());
        System.out.println("\nEntra nou valor del cost per dia de l'aula: ");
        costPerDia = Double.parseDouble(DADES.nextLine());
    }
    
    /*
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
    public void showAulaEstandard() {
        System.out.println("\nLes dades de l'aula estàndard amb codi " + this.getCodi() + " són: ");
        System.out.println("\nNúmero de l'aula: " + this.getNumeroAula());
        System.out.println("\nCost per dia de l'aula: " + this.getCostPerDia());
        System.out.println("\nCost de manteniment: " + this.costManteniment() + " EUR");
    }

    /*
     *
     * Nom del mètode: costManteniment
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode que calcula el cost de manteniment del AulaEstandard actual
     *   a partir del seu cost per dia.
     *   El cost de manteniment per dia és un 20% del cost per dia de l'aula
     * 
     * Retorn: cost de manteniment de l'aula (double).
     */
    public double costManteniment() {
        return (this.getCostPerDia() * 0.2);
    }
}