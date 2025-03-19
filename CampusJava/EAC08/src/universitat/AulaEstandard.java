/*
 * Classe que defineix una Aula Estàndard d'una universitat. 
 * Es defineixen pel seu codi, número d'aula i el seu cost per dia
 */
package universitat;


/**
 *
 * @author fgarin
 */
public class AulaEstandard extends Aula {

    /*
    * Nom del mètode: AulaEstandard
    * 
    * Paràmetres: valors per tots els atributs de la classe.
    *
    * Accions:
    * - Assignar als atributs corresponents els valors passats com a paràmetres.
    */
    public AulaEstandard(String codi, int numeroAula, double costPerDia) {
        // Crida constructor de l'Aula
        super(codi, numeroAula, costPerDia);
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
     * Nom del mètode: updateUnitatUniversitat
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

        super.updateUnitatUniversitat(); // No cal afegir cap nova funcionalitat per a aula estandard en relación amb la funcionalitat basica que ja s'ha afegit a la classe Aula

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
    public void showUnitatUniversitat() {
        
        // Codi que ha esta implementat a la classe pare:
        super.showUnitatUniversitat();

        // Linea extra que particular per a Aula Estandard
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