package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author fgarin
 */
public class MenuUniversitat extends JFrame {

    private JButton[] menuButtons = new JButton[6];

    private final int AMPLADA = 800;
    private final int ALCADA = 600;

    public MenuUniversitat() {

        /*
         * TODO
         * 
         * No afegiu cap listener a cap control.
         * 
         * Amb els atributs d'aquesta classe, heu de fer el següent:
         * 
         * - Heu de posar el títol "Menú Universitats" a l'objecte JFrame
         * 
         * - Heu d'establir un layout Grid d'una columna per al JFrame
         * 
         * - Heu de crear els botons del formulari. Cada botó serà un element de l'array
         * de botons amb les etiquetes indicades: 
         * 
         * "0. Sortir" 
         * "1. Alta Universitat"
         * "2. Seleccionar Universitat" 
         * "3. Llistar Universitats"
         * "4. Carregar Universitat" 
         * "5. Desar Universitat"
         * 
         * - Heu d'afegir-ho tots els botons al panell per defecte del JFrame
         * (this.getContentPane()).
         * 
         * - Heu de fer visible el frame amb l'amplada i alçada de les constants AMPLADA
         * i ALCADA, i fer que la finestra es tanqui quan l'usuari ho fa amb el control
         * "X" de la finestra. Per fer tot això, heu de cridar al mètode showFinestra()
         * d'aquesta classe.
         * 
         */

        //Contenidor d’alt nivell - Titol Menú Universitats
        this.setTitle("Menú Universitats");

        // Establir un GridLayout d'una columna per al JFrame
        GridLayout gridLayout = new GridLayout(this.menuButtons.length,1);

        // Creació dels botons
        menuButtons[0] = new JButton("0. Sortir");
        menuButtons[1] = new JButton("1. Alta Universitat");
        menuButtons[2] = new JButton("2. Seleccionar Universitat");
        menuButtons[3] = new JButton("3. Llistar Universitats");
        menuButtons[4] = new JButton("4. Carregar Universitat");
        menuButtons[5] = new JButton("5. Desar Universitat");


        // Afegir els botons al panell per defecte del JFrame
        this.getContentPane().setLayout(gridLayout);;
        //panell.setLayout(gridLayout);
        this.getContentPane().add(menuButtons[0]);
        this.getContentPane().add(menuButtons[1]);
        this.getContentPane().add(menuButtons[2]);
        this.getContentPane().add(menuButtons[3]);
        this.getContentPane().add(menuButtons[4]);
        this.getContentPane().add(menuButtons[5]);

        // Set de les dimensions, tancar finestra amb X i fer el frame visible
        this.showFinestra();
    }

    private void showFinestra() {
        // Es mostra la finestra amb propietats per defecte
        this.setSize(AMPLADA, ALCADA);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JButton[] getMenuButtons() {
        return menuButtons;
    }

    public void setMenuButtons(JButton[] menuButtons) {
        this.menuButtons = menuButtons;
    }
}
