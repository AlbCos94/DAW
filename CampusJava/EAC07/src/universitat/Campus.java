/**
 * Classe que defineix un campus. Es defineix pel seu nom,
 * la seva ubicació, un array d'aules estàndard,
 * un array d'aules d'informàtica i un array de laboratoris.
 */

package universitat;
import java.util.Scanner;

/**
 *
 * @author fgarin
 */
public class Campus {
    private final static Scanner DADES = new Scanner(System.in);

    private String nomCampus;
    private String ubicacio;

    private AulaEstandard[] aulesEstandard = new AulaEstandard[100];
    private int pAulesEstandard = 0; //Primera posició buida de l'array d'aules estàndard
    private AulaInformatica[] aulesInformatica = new AulaInformatica[100];
    private int pAulesInformatica = 0; //Primera posició buida de l'array d'aules d'informàtica
    private Laboratori[] laboratoris = new Laboratori[100];
    private int pLaboratoris = 0; //Primera posició buida de l'array de laboratoris

    /**
     * TODO CONSTRUCTOR
     *
     * Nom del mètode: Campus
     *
     * Paràmetres: valors per tots els atributs de la classe, menys els arrays
     *
     * Accions:
     * - Assignar als atributs els valors passats com a paràmetres.
     */
    public Campus(String sNomCampus, String sUbicacio){
        nomCampus = sNomCampus;
        ubicacio = sUbicacio;
    }

    /*
     * Creem un altre constructor sense parametres d'entrada, el qual crearà un campus a través del totes les dades introduiides per consola
     * 
     */
    public Campus(){
        nomCampus = this.askForString("Introdueix el nom del campus: ", "Codi del laboratori erroni");
        ubicacio = this.askForString("Introdueix la ubicació del campus: ", "Codi del laboratori erroni");

    }



    /**
     * TODO Heu d'implementar tots els mètodes accessors possibles.
     */
    //Setters
    public void setNomCampus(String nouNomCampus){
        this.nomCampus = nouNomCampus;
    }

    public void setUbicacio(String novaUbicacio){
        this.ubicacio = novaUbicacio;
    }

    public void setAulesEstandard(AulaEstandard[] aulesEstandard){
        this.aulesEstandard = aulesEstandard;
    }

    public void setpAulesEstandard(int pAulesEstandard){
        this.pAulesEstandard = pAulesEstandard;
    }

    public void setAulesInformatica(AulaInformatica[] aulesInformatica){
        this.aulesInformatica = aulesInformatica;
    }

    public void setpAulesInformatica(int pAulesInformatica){
        this.pAulesInformatica = pAulesInformatica;
    }

    public void setLaboratoris(Laboratori[] laboratoris){
        this.laboratoris = laboratoris;
    }

    public void setpLaboratoris(int pLaboratoris){
        this.pLaboratoris = pLaboratoris;
    }

    //Getters
    public String getNomCampus(){ return this.nomCampus; }
    public String getUbicacio(){ return this.ubicacio; }

    public AulaEstandard[] getAulesEstandard(){ return this.aulesEstandard; }
    public int getpAulesEstandard(){ return this.pAulesEstandard; }

    public AulaInformatica[] getAulesInformatica(){ return this.aulesInformatica; }
    public int getpAulesInformatica(){ return this.pAulesInformatica; }

    public Laboratori[] getLaboratoris(){ return this.laboratoris; }
    public int getpLaboratoris(){ return this.pLaboratoris; }
    

    /**
     * TODO
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
    public static Campus addCampus(){
        return new Campus();
    }

    /*
     * TODO
     *
     * Nom del mètode: updateCampus
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
    public void updateCampus(){
        String nouNomCampus = this.askForString("Introdueix el nou nom del campus: ", "Codi de l'aula erroni");
        String novaUbicacio = this.askForString("Introdueix la nova ubicacio del campus: ", "Número de l'aula erroni");

        System.out.println("Nou nom del campus: " + nouNomCampus);
        System.out.println("Nova ubicació: " + novaUbicacio);

        this.nomCampus = nouNomCampus;
        this.ubicacio = novaUbicacio;
    } 
    

    /*
     * TODO
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
    public double costManteniment(){
        double costTotal = 0.0;
        
        // loop from index 0 to first position without null element in the array
        for (int i = 0; i < this.pAulesEstandard; i++) {
            costTotal = costTotal + this.aulesEstandard[i].costManteniment();
        }

        for (int i = 0; i < this.pAulesInformatica; i++) {
            costTotal = costTotal + this.aulesInformatica[i].costManteniment();
        }

        for (int i = 0; i < this.pLaboratoris; i++) {
            costTotal = costTotal + this.laboratoris[i].costManteniment();
        }

        return costTotal;
    }

    /*
     * TODO
     *
     * Nom del mètode: showCampus
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Mètode per mostrar les dades del campus i el seu cost de manteniment.
     *
     * Retorn: cap
     */

    public void showCampus(){

        System.out.println("Nom del campus: " + this.nomCampus);
        System.out.println("Ubicació del campus: " + this.ubicacio);
        
        System.out.println("Cost manteniment: " + this.costManteniment());
    }  
    
    /**
     * AulaEstandard
     *
     * TODO
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
    public void addAulaEstandard(){
        
        AulaEstandard aula = AulaEstandard.addAulaEstandard();

        int posAula = this.selectAulaEstandard(aula.getCodi());

        if (posAula == -1){
            System.out.println("L'aula estàndard ja existeix");
        } else{
            this.aulesEstandard[posAula] = aula;
            this.pAulesEstandard = posAula;
        }

    
    }

    /**
     *
     * Nom del mètode: selectAulaEstandard
     *
     * Paràmetres: codi de l'aula estàndard
     *
     * Accions:
     * - Mètode que selecciona una aula estàndard de l'array de aulesEstandard del campus actual
     *   a partir del seu codi.
     *
     * Retorn: posició de l'aula estàndard seleccionada a l'array de aulesEstandard del campus actual.
     * Si l'aula estàndard no existeix retorna -1.
     */
    public int selectAulaEstandard(String codi) {
        if (codi == null) {
            System.out.println("\nCodi de l'aula estàndard:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pAulesEstandard; i++) {
            if (aulesEstandard[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * AulaInformatica
     *
     * TODO
     *
     * Nom del mètode: addAulaInformatica
     *
     * Paràmetres: cap
     *
     * Accions:
     * - Afegeix una nova aulaInformatica a l'array de aulesInformatica
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
    public void addAulaInformatica(){
        
        AulaInformatica aula = AulaInformatica.addAulaInformatica();

        int posAula = this.selectAulaInformatica(aula.getCodi());

        if (posAula == -1){
            System.out.println("L'aula d'informàtica ja existeix");
        } else{
            this.aulesInformatica[posAula] = aula;
            this.pAulesInformatica = posAula;
        }

    
    }
    
    
    /**
     *
     * Nom del mètode: selectAulaInformatica
     *      
     * Paràmetres: codi de l'aulaInformatica
     *
     * Accions:
     * - Mètode que selecciona una aulaInformatica de l'array de aulesInformatica del campus actual
     *   a partir del seu codi.
     *
     * Retorn: posició de la aulaInformatica seleccionada a l'array de aulesInformatica del campus actual.
     * Si l'aula d'informàtica no existeix retorna -1.
     */    
    public int selectAulaInformatica(String codi) {
        if (codi == null) {
            System.out.println("\nCodi de l'aula d'informàtica:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pAulesInformatica; i++) {
            if (aulesInformatica[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }
    
    /**
     * Laboratori
     *
     * TODO
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
    
    public void addLaboratori(){
        
        Laboratori aula = Laboratori.addLaboratori();

        int posAula = this.selectLaboratori(aula.getCodi());

        if (posAula == -1){
            System.out.println("El laboratori ja existeix");
        } else{
            this.laboratoris[posAula] = aula;
            this.pLaboratoris = posAula;
        }

    
    }
    /**
     *
     * Nom del mètode: selectLaboratori
     * 
     * Paràmetres: codi del laboratori
     *
     * Accions:
     * - Mètode que selecciona un laboratori de l'array de laboratoris del campus actual
     *   a partir del seu codi.
     *
     * Retorn: posició de la laboratori seleccionada a l'array d'laboratoris del campus actual.
     * Si el laboratori no existeix retorna -1.
     */      
    
    public int selectLaboratori(String codi) {
        if (codi == null) {
            System.out.println("\nCodi del laboratori:");
            codi = DADES.nextLine();
        }

        for (int i = 0; i < pLaboratoris; i++) {
            if (laboratoris[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }


    /*
     * 
     * Métodes auxiliars
     * 
     */

    // Métode per preguntar pel nom del campus i la seva ubicació
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



}