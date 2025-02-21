/*
 * Classe que defineix una aula estàndard d'una universitat. 
 * Es defineixen pel seu codi, número d'aula i el seu cost per dia.
 */
package universitat;


/**
 *
 * @author fgarin
 */
public class AulaEstandard {
    private final static Scanner DADES = new Scanner(System.in);

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
    

    /*
     * TODO Heu d'implementar tots els mètodes accessors possibles.  
     */

    //Setters
    void setCodi(String nouCodi){
        codi = nouCodi;
    }

    void setNumeroAula(int nouNumeroAula){
        numeroAula = nouNumeroAula;
    }

    void setCostPerDia(double nouCostPerDia){
        costPerDia = nouCostPerDia;
    }

    //Getters
    String getCodi(){ return codi; }
    int getNumeroAula(){ return numeroAula; }
    double getCostPerDia(){ return costPerDia; }

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
    

}