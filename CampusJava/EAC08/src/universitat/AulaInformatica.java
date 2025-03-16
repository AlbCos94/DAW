/*
 * Classe que defineix una aul d'informàtica d'una universitat. 
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
     * Nom del mètode: AulaInformatica          
     *
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public AulaInformatica(String codi, int numeroAula, double costPerDia, double areaEnMetresQuadrats) {
        this.codi = codi;
        this.numeroAula = numeroAula;
        this.costPerDia = costPerDia;
        this.areaEnMetresQuadrats = areaEnMetresQuadrats;
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

    public void setCostPerDia(double costPerDia) {
        this.costPerDia = costPerDia;
    }

    public double getAreaEnMetresQuadrats() {
        return this.areaEnMetresQuadrats;
    }

    public void setAreaEnMetresQuadrats(double areaEnMetresQuadrats) {
        this.areaEnMetresQuadrats = areaEnMetresQuadrats;
    }

    /*
     * Nom del mètode: addAulaInformatica
     *
     * Paràmetres: cap
    
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear una nova aula d'infomràtica. Les dades a
     *   demanar són les que necessita el constructor.
     *
     * Retorn: Objecte AulaInformatica creat.
     */
    public static AulaInformatica addAulaInformatica() {
        System.out.println("\nCodi de l'aula d'informàtica: ");
        String codi = DADES.nextLine();
       
        System.out.println("\nNúmero de l'aula d'informàtica: ");
        int numeroAula = Integer.parseInt(DADES.nextLine());
        
        System.out.println("\nCost per dia de l'aula d'informàtica: ");
        double costPerDia = Double.parseDouble(DADES.nextLine());

        System.out.println("\nÀrea en metres quadrats de l'aula d'informàtica: ");
        double areaEnMetresQuadrats = Double.parseDouble(DADES.nextLine());

        return new AulaInformatica(codi, numeroAula, costPerDia, areaEnMetresQuadrats);
    }

    /*
     *
     * Nom del mètode: updateAulaInformatica
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de l'aula d'informàtica i modificar els
     *   atributs corresponents d'aquesta aula.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     *
     * Retorn: cap
     */
    public void updateAulaInformatica() {
        System.out.println("\nCodi de l'aula d'informàtica: " + this.getCodi());
        System.out.println("Entra el nou valor del codi: ");
        codi = DADES.nextLine();
       
        System.out.println("\nNúmero de l'aula d'informàtica: " + this.getNumeroAula());
        System.out.println("\nEntra el nou valor del numero d'aula:");
        numeroAula = Integer.parseInt(DADES.nextLine());
        
        System.out.println("\nCost per dia de l'aula d'informàtica: " + this.getCostPerDia());
        System.out.println("Entra el nou valor del cost per dia de l'aula d'informàtica:");
        costPerDia = Double.parseDouble(DADES.nextLine());

        System.out.println("\nÀrea en metres quadrats de l'aula d'informàtica: " + this.getAreaEnMetresQuadrats());
        System.out.println("Entra el nou valor de l'àrea en metres quadrats de l'aula d'informàtica:");
        areaEnMetresQuadrats = Double.parseDouble(DADES.nextLine());
    }

    /*
     *
     * Nom del mètode: showAulaInformatica
     * 
     * Accions:
     * - Mètode per imprimir les dades de l'aula d'informàtica i el seu cost de manteniment.
     *
     * Retorn: cap
     */
    public void showAulaInformatica() {
        System.out.println("\nLes dades de l'aula d'informàtica amb codi " + this.getCodi() + " són: ");
        System.out.println("\nNúmero d'aula: " + this.getNumeroAula());
        System.out.println("\nCost per dia de l'aula d'informàtica: " + this.getCostPerDia());
        System.out.println("\nL'àrea en metres quadrats de l'aula: " + this.getAreaEnMetresQuadrats());
        System.out.println("\nCost de manteniment: " + this.costManteniment() + " EUR");
    }

    /*
     *
     * Nom del mètode: costManteniment
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode que retornarà el cost de manteniment de l'aula. 
     * - El cost de manteniment per dia és un 30% del cost per dia de l'aula
     *
     * Retorn: cost de manteniment de l'aula (double).
     */
    public double costManteniment(){
        return (this.getCostPerDia() * 0.3) + (this.getAreaEnMetresQuadrats() * 0.08);
    }
}
