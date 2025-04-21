package vista;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author fgarin
 */
public class MenuPrincipal extends JFrame {

    private JButton[] menuButtons = new JButton[3];

    private final int AMPLADA = 800;
    private final int ALCADA = 600;

    public MenuPrincipal() {

        /*
         * No afegiu cap listener a cap control.
         * 
         * Amb els atributs d'aquesta classe, heu de fer el següent:
         * 
         * - Heu de posar el títol "Menú Principal" a l'objecte JFrame
         * 
         * - Heu d'establir un layout Grid d'una columna per al JFrame 
         * 
         * - Heu de crear els botons del formulari. Cada botó serà un element de l'array
         * de botons amb les etiquetes indicades:
         * 
         * "0. Sortir"    ->  En picar el botó, la finestra es tanca i el programa acaba.
         * 
         * "1. Menú Universitats"  ->  En picar el botó s’amaga el menú principal i es crea un objecte ControladorUniversitat. Heu de fer que aquest, en el seu constructor, mostri el menú d’universitats.
         * 
         * "2. Menú Aules" -> En picar el botó es mostrarà el diàleg amb el text “No heu d’implementar aquest menú.”.
         * 
         * - Heu afegir els botons al panell per defecte del JFrame
         * (this.getContentPane()).
         * 
         * - Heu de fer visible el frame amb l'amplada i alçada de les constants AMPLADA
         * i ALCADA, i fer que la finestra es tanqui quan l'usuari ho fa amb el control
         * "X" de la finestra. Per fer tot això, heu de cridar al mètode showFinestra()
         * d'aquesta classe.
         * 
         */

        //Contenidor d’alt nivell: finestra principal - Titol Menu Principal
        //JFrame frameMenuPrincipal = new JFrame("Menú Principal");
        this.setTitle("Menú Principal");

        // Establir un GridLayout d'una columna per al JFrame
        GridLayout gridLayout = new GridLayout(this.menuButtons.length,1);
        //frameMenuPrincipal.setLayout(gridLayout);

        // Creació dels botons
        menuButtons[0] = new JButton("0. Sortir");
        menuButtons[1] = new JButton("1. Menú Universitats");
        menuButtons[2] = new JButton("2. Menú Aules");

        // Afegir els botons al panell per defecte del JFrame
        this.getContentPane().setLayout(gridLayout);;
        //panell.setLayout(gridLayout);
        this.getContentPane().add(menuButtons[0]);
        this.getContentPane().add(menuButtons[1]);
        this.getContentPane().add(menuButtons[2]);


        //this.add(panell)
        // Set de l'amplada i l'alcada, permetre que en premer X es tanqui la finestra i fem visible la finestra 
        this.showFinestra();

    }

    private void showFinestra() {
        // Es mostra la finestra amb propietats per defecte.
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
