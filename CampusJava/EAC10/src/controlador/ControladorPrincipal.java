package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Universitat;
import persistencia.GestorPersistencia;
import vista.MenuPrincipal;

/**
 *
 * @author fgarin
 */
public class ControladorPrincipal implements ActionListener {

    // ControladorPrincipal serà un Listener que implementa "ActionListener" per la qual cosa capturarà (escoltarà) només a esdeveniments del tipus "ActionEvent"

    static private MenuPrincipal menuPrincipal;
    static private final int MAXUNIVERSITATS = 4;
    static private Universitat[] universitats = new Universitat[MAXUNIVERSITATS];
    static private int pUniversitats = 0; // Primera posició buida del vector universitats
    static private Universitat universitatActual = null;
    static private GestorPersistencia gp = new GestorPersistencia();
    static private final String[] METODESPERSISTENCIA = { "XML" };

    public ControladorPrincipal() {

        /*
         * Inicialitzeu l'atribut menuPrincipal (això mostrarà el menú principal). A
         * cada botó del menú, afegiu aquest mateix (ControladorPrincipal) objecte com a
         * listener.
         * 
         * Aqui s'haura de mostrar el menu principal , el qual es una finestra "JFrame" amb tres botons amb esdeveniments implementats al metode "seleccionarOpcio"
         * De  d'executar  un objecte de la classe "MenuPrincipal" dins de vista 
         * 
         * Perquè els esdeveniments s’executin en picar els botons ( Sortir, Menu universitars i Menu Aules), heu d’afegir escoltadors d’accions als botons en el constructor del controlador principal.
         * 
         */

        // Inicialitzacio de l'atribut Menu Principal de Vista
        menuPrincipal = new MenuPrincipal();

        //A cada botó del menú, afegiu aquest mateix (ControladorPrincipal) objecte com a listener.
        // Quan s'apliqui una accio al botó en questió serà aquest controlador l'encarregat de reaccionar a l'esdeveniment
        menuPrincipal.getMenuButtons()[0].addActionListener(this);
        menuPrincipal.getMenuButtons()[1].addActionListener(this);
        menuPrincipal.getMenuButtons()[2].addActionListener(this);

    }

    //Unic metode pel tipus de listener "ActionListener" sobreescrit per a poder reaccionar a l'esdeveniment de pitjar un boto
    @Override
    public void actionPerformed(ActionEvent e) {

        /*
         * Seleccioneu l'acció a realitzar cridant el mètode seleccionarOpcio i
         * utilitzant la propietat actionCommand dels botons, que per defecte 
         * és igual al text dels botons. El mètode getActionCommand de l'esdeveniment 
         * retorna la propietat actionCommand de l'objecte que ha produït l'acció.
         * 
         */

        seleccionarOpcio(e.getActionCommand());

    }

    private void seleccionarOpcio(String opcio) {

        switch (opcio) {
            case "0. Sortir":
                // Tanca la finestra.
                menuPrincipal.dispose();
                break;
            case "1. Menú Universitats":
                // Fa no visible la finestra.
                menuPrincipal.setVisible(false);
                new ControladorUniversitat();
                break;
            case "2. Menú Aules":
                JOptionPane.showMessageDialog(menuPrincipal, "No heu d'implementar aquest menú");
                break;
        }

    }

    public static MenuPrincipal getMenuPrincipal() {
        return menuPrincipal;
    }

    public static void setMenuPrincipal(MenuPrincipal menuPrincipal) {
        ControladorPrincipal.menuPrincipal = menuPrincipal;
    }

    public static GestorPersistencia getGp() {
        return gp;
    }

    public static void setGp(GestorPersistencia gp) {
        ControladorPrincipal.gp = gp;
    }

    public static Universitat[] getUniversitats() {
        return universitats;
    }

    public static void setUniversitats(Universitat[] universitats) {
        ControladorPrincipal.universitats = universitats;
    }

    public static int getpUniversitats() {
        return pUniversitats;
    }

    public static void setpUniversitats() {
        ControladorPrincipal.pUniversitats++;
    }

    public static Universitat getUniversitatActual() {
        return universitatActual;
    }

    public static int getMAXUNIVERSITATS() {
        return MAXUNIVERSITATS;
    }

    public static void setUniversitatActual(Universitat universitatActual) {
        ControladorPrincipal.universitatActual = universitatActual;
    }

    public static String[] getMETODESPERSISTENCIA() {
        return METODESPERSISTENCIA;
    }

}
