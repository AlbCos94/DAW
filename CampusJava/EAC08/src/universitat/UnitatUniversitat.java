/*
 * Classe que defineix una universitat, que es defineix pel seu nom,
 * la seva ubicació i un array de campus.
 */

package universitat;

import java.util.Scanner;

/**
 *
 * @author fgarin
 */

public interface UnitatUniversitat{
    // Atribut DADES
    /*
     * Aquest atribut substituirà a l’atribut constant DADES de les diferents classes que han d’implementar aquesta interfície, 
     * per tant, DADES tindrà la mateixa funcionalitat que l’atribut DADES de les classes que implementaran la interfície.
     */
    public final static Scanner DADES = new Scanner(System.in);

    // Metodes
    public void updateUnitatUniversitat();
    public void showUnitatUniversitat();
}

 