/*
 * Classe que defineix una universitat, que es defineix pel seu nom,
 * la seva ubicació i un array de campus.
 */

package universitat;


/**
 *
 * @author fgarin
 */
public class Universitat {

    private String nomUniversitat;
    private String ubicacioSeu;
    private Campus[] campus = new Campus[5];
    private int pCampus = 0; //Primera posició buida de l'array de campus

    /*
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: Universitat
     *
     * Paràmetres: valors per tots els atributs de la classe menys els arrays.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    
    
    

    /**
     * TODO Heu d'implementar tots els mètodes accessors possibles.
     */
    
   

    /**
     * TODO
     *
     * Nom del mètode: addUniversitat
     *
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear una nova universitat.
     *   Les dades a demanar són les que necessita el constructor.
     * 
     * Retorn: Objecte Universitat creat.
     */
    

    /**
     * TODO
     *
     * Nom del mètode: updateUniversitat
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades de la universitat i
     *   modificar els atributs corresponents d'aquesta universitat. 
     *   Els únics atributs que modificarem
     *   són els que hem inicialitzat en el constructor amb els paràmetres passats.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     * 
     * Retorn: cap
     */
    
    

    /**
     * TODO
     *
     * Nom del mètode: costManteniment
     *  
     * Paràmetres: cap
     * 
     * Accions:
     * - Calcular cost de manteniment dels campus de la universitat a partir dels costos de manteniment
     *   de tots els campus de la universitat.
     * 
     * Retorn: Cost de manteniment total de la universitat (double).
     */
    

    /**
     * TODO
     *
     * Nom del mètode: showUniversitat
     * 
     * Paràmetres: cap
     * 
     * Accions:
     * - Mètode per imprimir les dades de la universitat actual i el cost del seu manteniment.
     * 
     * Retorn: cap
     */
 


    /**
     * Campus
     * 
     * TODO
     *
     * Nom del mètode: addCampus
     *  
     * Paràmetres: cap
     * 
     * Accions:
     * - Afegeix un nou campus a l'array de campus de la universitat
     *   si aquest no existeix. 
     *   Per afegir-lo heu de fer servir el mètode de la classe Campus escaient
     *   i per comprovar la seva existència el mètode d'aquesta classe que ens
     *   ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de campus si s'afegeix el campus. 
     * - Mostra el missatge "El campus ja existeix" si no s'ha afegit.
     * 
     * Retorn: cap
     */
    

    /**
     *
     * Nom del mètode: selectCampus
     *
     * Paràmetres: cap
     * 
     * Accions:
     * - Seleciona un campus de l'array de campus de la universitat
     *   a partir del seu nom.
     * 
     * Retorn: La posició del campus seleccionat o -1 si no existeix.
     */
    public int selectCampus(String nom) {
        if (nom == null) {
            System.out.println("\nNom del campus:");
            nom = DADES.nextLine();
        }

        for (int i = 0; i < pCampus; i++) {
            if (campus[i].getNomCampus().equals(nom)) {
                return i;
            }
        }

        return -1;
    }

    public void addAulaEstandardCampus() {

        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addAulaEstandard();
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void updateAulaEstandardCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexAulaEstandard = campus[indexCampus].selectAulaEstandard(null);

            if (indexAulaEstandard != -1) {
                campus[indexCampus].getAulesEstandard()[indexAulaEstandard].updateAulaEstandard();
            } else {
                System.out.println("\nL'aula estàndard no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void addAulaInformaticaCampus() {
        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addAulaInformatica();
        } else {
            System.out.println("\nLEl campus no existeix");
        }
    }

    public void updateAulaInformaticaCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexAulaInformatica = campus[indexCampus].selectAulaInformatica(null);

            if (indexAulaInformatica != -1) {
                campus[indexCampus].getAulesInformatica()[indexAulaInformatica].updateAulaInformatica();
            } else {
                System.out.println("\nL'aula d'informàtica no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void addLaboratoriCampus() {
        int index = selectCampus(null);

        if (index != -1) {
            campus[index].addLaboratori();
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }

    public void updateLaboratoriCampus() {
        int indexCampus = selectCampus(null);

        if (indexCampus != -1) {
            int indexLaboratori = campus[indexCampus].selectLaboratori(null);

            if (indexLaboratori != -1) {
                campus[indexCampus].getLaboratoris()[indexLaboratori].updateLaboratori();
            } else {
                System.out.println("\nEl laboratori no existeix");
            }
        } else {
            System.out.println("\nEl campus no existeix");
        }
    }
}
