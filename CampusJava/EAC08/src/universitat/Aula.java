/*
 * Classe abstrata que defineix una Aula d'una universitat. 
 * Es defineixen pel seu codi, número d'aula i el seu cost per dia
 */
package universitat;


/**
 *
 * @author fgarin
 */
abstract public class Aula implements UnitatUniversitat{
   
    private String codi;
    private int numeroAula;
    private double costPerDia;

    /*
     *
     * Nom del mètode: Aula
     * 
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
     public Aula(String codi, int numeroAula, double costPerDia) {
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
     * Nom del mètode: updateUnitatUniversitat - Implementacio part del mètode que sempre s'emprarà a les classes que heretin d'Aula
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
    public void updateUnitatUniversitat() {
        System.out.println("\nCodi de l'aula: " + this.getCodi());
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
     * Nom del mètode: showUnitatUniversitat - Implementació part del mètode que sempre s'emprarà
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode per mostrar les dades de l'aula actual i el seu cost de manteniment.
     * 
     * Retorn: cap
     */
    public void showUnitatUniversitat() {
        System.out.println("\nLes dades de l'aula amb codi " + this.getCodi() + " són: ");
        System.out.println("\nNúmero de l'aula: " + this.getNumeroAula());
        System.out.println("\nCost per dia de l'aula: " + this.getCostPerDia());
    }

    /*
     * 
     * Nom del mètode: costManteniment - Aquest mètode serà diferent segons la classe que l'hereti
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode que calcula el cost de manteniment del Aula actual
     *   a partir del seu cost per dia.
     * 
     * Retorn: cost de manteniment de l'aula (double).
     */
    /* */
    // metode abstracte -> haura de ser implementat per la resta de classes
    public abstract double costManteniment(); // el fem abstracte ja que no te cap implementacio per la classe pare i es obligatori per qui l'hereti
    
}