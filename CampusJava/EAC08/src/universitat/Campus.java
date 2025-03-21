/**
 * Classe que defineix un campus. Es defineix pel seu nom,
 * la seva ubicació, un array d'aules estàndard,
 * un array d'aules d'informàtica i un array de laboratoris.
 */

package universitat;

/**
 *
 * @author fgarin
 */
public class Campus implements UnitatUniversitat {

    private String nomCampus;
    private String ubicacio;

    private Aula[ ] aula = new Aula[300]; // array per guardar els tres tipus d'aules (Estandard, Informatica i Laboratori)
    private int pAula= 0; // pointer que indica primera posició de l'array d'aules que està buit

    
    /**
     * Nom del mètode: Campus
     *
     * Paràmetres: valors per tots els atributs de la classe, menys els arrays
     *
     * Accions:
     * - Assignar als atributs els valors passats com a paràmetres.
     */
    public Campus(String nomCampus, String ubicacio) {
        this.nomCampus = nomCampus;
        this.ubicacio = ubicacio;
    }

    public String getNomCampus() {
        return this.nomCampus;
    }

    public void setNomCampus(String nomCampus) {
        this.nomCampus = nomCampus;
    }

    public String getUbicacio() {
        return this.ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    public String getCodi() {
        return this.codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public Aula[] getAules() {
        return this.aula;
    }

    public void setAules(Aula[] aules) {
        this.aula = aules;
    }
    
    public int getpAula() {
        return this.pAula;
    }

    public void setpAula(int pAula) {
        this.pAula = pAula;
    }

    /**
     *
     * Nom del mètode: addCampus
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari les dades per consola per crear un nou campus
     *   Les dades a demanar són les que necessita el constructor.
     *
     * Retorn: Objecte Campus creat.
     */
    public static Campus addCampus() {
        String nom, ubicacio;

        System.out.println("\nNom del campus: ");
        nom = DADES.nextLine();
        System.out.println("\nUbicació del campus: ");
        ubicacio = DADES.nextLine();

        return new Campus(nom, ubicacio);
    }

    /*
     *
     * Nom del mètode: updateUnitatUniversitat
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Demanar a l'usuari que introdueixi les noves dades del campus i
     *   modificar els atributs corresponents d'aquest. Els únics
     *   atributs que modificarem són els que hem inicialitzat en el constructor
     *   amb els paràmetres passats.
     * - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     *
     * Retorn: cap
     */
    public void updateUnitatUniversitat() {
        System.out.println("\nNom del campus: " + this.getNomCampus());
        System.out.println("\nEntra el nou nom del campus:");
        this.nomCampus = DADES.nextLine();
        System.out.println("\nUbicació del campus : " + this.getUbicacio());
        System.out.println("\nEntra la nova ubicació del campus:");
        this.ubicacio = DADES.nextLine();
    }

    /*
     *
     * Nom del mètode: costManteniment
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Calcular el cost de manteniment del campus a partir dels costos
     *   de manteniment de les aules i laboratoris del campus.
     *
     * Retorn: cost de manteniment total del campus.
     */
    public double costManteniment() {
        
        double costTotal = 0;

        for (int i = 0; i < pAula; i++) {
            costTotal += aula[i].costManteniment();
        }

        return costTotal;
    }
    
    /*
     *
     * Nom del mètode: showUnitatUniversitat
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode per mostrar les dades del campus i el seu cost de manteniment.
     *
     * Retorn: cap
     */
    public void showUnitatUniversitat() {
        System.out.println("\nLes dades del campus " + this.nomCampus + " són: ");
        System.out.println("\nUbicació: " + this.getUbicacio());
        System.out.println("\nCost de manteniment: " + this.costManteniment() + " EUR");
    }
    
    /**
     * AulaEstandard
     *
     *
     * Nom del mètode: addAulaEstandard
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix una nova aula estàndard a l'array d'aulesEstandard
     *   del campus actual si aquest/a no existeix.
     *   Per afegir-lo heu de fer servir el mètode de la classe AulaEstandard
     *   escaient i per comprovar la seva existència el mètode d'aquesta classe
     *   que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de aulesEstandard si s'afegeix.
     * - Mostra el missatge "L'aula estàndard ja existeix" si
     *   no s'ha afegit.
     *
     * Retorn: cap
     */
    public void addAulaEstandard() {
        AulaEstandard nouAulaEstandard = AulaEstandard.addAulaEstandard();

        if (selectAula(1, nouAulaEstandard.getCodi()) == -1) {
            aula[pAula] = nouAulaEstandard;
            pAula++;
        } else {
            System.out.println("\nL'aula estàndard ja existeix");
        }
    }


    /**
     * AulaInformatica
     *
     *
     * Nom del mètode: addAulaInformatica
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix una nova AulaInformatica a l'array de aulesInformatica
     *   del campus actual si aquesta no existeix.
     *   Per afegir-la heu de fer servir el mètode de la classe AulaInformatica
     *   escaient i per comprovar la seva existència el mètode d'aquesta classe
     *   que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de aulesInformatica si s'afegeix.
     * - Mostra el missatge "L'aula d'informàtica ja existeix" si
     *   no s'ha afegit.
     *
     * Retorn: cap
     */
    public void addAulaInformatica() {
        AulaInformatica novaAulaInformatica = AulaInformatica.addAulaInformatica();

        if (selectAula(2, novaAulaInformatica.getCodi()) == -1) {
            aula[pAula] = novaAulaInformatica;
            pAula++;
        } else {
            System.out.println("\nL'aula d'informàtica ja existeix");
        }
    }
    

    /**
     * Laboratori
     *
     *
     * Nom del mètode: addLaboratori
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix un nou laboratori a l'array de laboratoris
     *   del campus actual si aquest no existeix.
     *   Per afegir-lo heu de fer servir el mètode de la classe Laboratori
     *   escaient i per comprovar la seva existència el mètode d'aquesta classe
     *   que ens ajuda en aquesta tasca.
     * - Actualitza la posició de l'array de laboratoris si s'afegeix.
     * - Mostra el missatge "El laboratori ja existeix" si
     *   no s'ha afegit.
     *
     * Retorn: cap
     */
    public void addLaboratori() {
        Laboratori novaLaboratori = Laboratori.addLaboratori();

        if (selectAula(3, novaLaboratori.getCodi()) == -1) {
            aula[pAula] = novaLaboratori;
            pAula++;
        } else {
            System.out.println("\nEl laboratori ja existeix");
        }
    }

    /**
     *
     * Nom del mètode: selectAula
     *
     * Paràmetres: 
     * - Tipus d'aula
     *  1: Aula estandard
     *  2: Aula informàtica
     *  3: Laboratori
     * - Codi de l'aula 
     *
     * Accions:
     * - Mètode que selecciona una aula de l'array d'aules del campus actual a partir del seu codi i tipus.
     *
     * Retorn: posició de l'aula seleccionada a l'array de aules del campus actual.
     * Si l'aula estàndard no existeix retorna -1.
     */
    public int selectAula(int tipusAula, String codi) {
        if (codi == null) {
            System.out.println("\nCodi de l'aula:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pAula; i++) {
            if (aula[i].getCodi().equals(codi)) {
                
                // No només el codi de l'aula ha de ser el mateix, sinó que també hem de tenir el mateix tipus d'Aula de l'objecte amb que comparem
                switch (tipusAula) {
                    case 1:
                        if (aula[i] instanceof AulaEstandard){
                            return i;
                        }
                        break; 
                    case 2:
                        if (aula[i] instanceof AulaInformatica){
                            return i;
                        } 
                        break;
                    case 3:
                        if (aula[i] instanceof Laboratori){
                            return i;
                        }
                        break; 
                    default:
                        break;
                }
            }
        }
        return -1;
    }
}