/*
 * Classe que defineix una aula d'informàtica d'una universitat. 
 * Es defineix pel seu codi, número d'aula, el seu cost per dia i el tamany de l'aula en metres quadrats.
 */
package universitat;


/**
 *
 * @author fgarin
 */
public class AulaInformatica extends Aula {

    private double areaEnMetresQuadrats; // Atribut propi d'aula d'informatica

    /*
     * Nom del mètode: AulaInformatica          
     *
     * Paràmetres: valors per tots els atributs de la classe.
     *
     * Accions:
     * - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
    public AulaInformatica(String codi, int numeroAula, double costPerDia, double areaEnMetresQuadrats) {

        // Crida al constructor d'Aula pels atributs principals
        super(codi, numeroAula, costPerDia);
        // Inicialitzacio de l'atribut propi de AulaInformatica
        this.areaEnMetresQuadrats = areaEnMetresQuadrats;
    }


    // Aquest getter es particular per la classe AulaInformatica
    public double getAreaEnMetresQuadrats() {
        return this.areaEnMetresQuadrats;
    }
    // Aquest setter es particular per la classe AulaInformatica
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
     * Nom del mètode: updateUnitatUniversitat
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
    public void updateUnitatUniversitat() {

        // Preguntes base d'atributs d'Aula implementades en classe Aula
        super.updateUnitatUniversitat();
        
        // Es pregunta per l'atribut particular de l'aula d'informàtica
        System.out.println("\nÀrea en metres quadrats de l'aula d'informàtica: " + this.getAreaEnMetresQuadrats());
        System.out.println("Entra el nou valor de l'àrea en metres quadrats de l'aula d'informàtica:");
        areaEnMetresQuadrats = Double.parseDouble(DADES.nextLine());
    }

    /*
     *
     * Nom del mètode: showUnitatUniversitat
     * 
     * Accions:
     * - Mètode per imprimir les dades de l'aula d'informàtica i el seu cost de manteniment.
     *
     * Retorn: cap
     */
    public void showUnitatUniversitat() {

        // Informacio bàsica de l'aula - implementada a la classe pare Aula
        super.showUnitatUniversitat();

        // Atributs particulars de l'aula d'informàtica
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
