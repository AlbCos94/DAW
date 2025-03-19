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
public class Laboratori extends Aula {

    private int capacitat; // atribut propi d'Aula

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
        // Crida al constructor de Aula pels atributs principal
        super(codi, numeroLaboratori, costPerDia);
        // Inicialitzacio de l'atribut propi de Laboratori
        this.capacitat = capacitat;
    }


    // Aquest getter es particular per la clase Laboratori
    public int getCapacitat() {
        return this.capacitat;
    }
    // Aquest setter es particular per la clase Laboratori
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
     * Nom del mètode: updateUnitatUniversitat
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
    public void updateUnitatUniversitat() {

        // Preguntes core d'aula per construir el laboratori 
        super.updateUnitatUniversitat();

        // atribut particular del laboratori
        System.out.println("\nCapacitat del Laboratori: " + this.getCapacitat());
        System.out.println("Entra el nou valor de la capacitat:");
        capacitat = Integer.parseInt(DADES.nextLine());
    }

    /*
     * Nom del mètode: showUnitatUniversitat
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode per mostrar les dades del Laboratori actual i el cost del seu manteniment.
     * 
     * Retorn: cap    
     */
    public void showUnitatUniversitat() {
        
        super.showUnitatUniversitat();

        // Atributs particular per laboratori
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
