package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Universitat;
import persistencia.GestorPersistencia;
import persistencia.GestorXML;
import exceptions.GestorUniversitatsException;
import vista.MenuPrincipal;
import vista.MenuUniversitat;
import vista.UniversitatForm;
import vista.UniversitatLlista;

/**
 *
 * @author fgarin
 */
public class ControladorUniversitat implements ActionListener {

    private MenuUniversitat menuUniversitat;
    private UniversitatForm universitatForm = null;
    private UniversitatLlista universitatLlista = null;

    public ControladorUniversitat() {

        /*
         * Inicialitzeu l'atribut menuUniversitat (per mostrar el menú d'universitats). 
         * Afegiu els escoltadors als botons del menú cridant al mètode afegirListenersMenu().
         * 
         */

        // Inicialitzacio de l'atribut Menu Principal de Vista
        menuUniversitat = new MenuUniversitat();

        // Afegiu els escoltadors als botons del menú cridant al mètode afegirListenersMenu().
        this.afegirListenersMenu();

    }

    // El controlador com a listener dels controls de les finestres que gestionen les universitats
    private void afegirListenersMenu() {

        /*
         * Afegiu aquest mateix objecte (ControladorUniversitat) com a listener, a
         * cada botó del menú d'universitats.
         * 
         */
        this.menuUniversitat.getMenuButtons()[0].addActionListener(this);
        this.menuUniversitat.getMenuButtons()[1].addActionListener(this);
        this.menuUniversitat.getMenuButtons()[2].addActionListener(this);
        this.menuUniversitat.getMenuButtons()[3].addActionListener(this);
        this.menuUniversitat.getMenuButtons()[4].addActionListener(this);
        this.menuUniversitat.getMenuButtons()[5].addActionListener(this);

    }

    private void afegirListenersForm() {

        /*
         * Afegiu aquest mateix objecte (ControladorUniversitat) com a listener, a
         * cada botó del formulari de la universitat.
         * 
         */
        this.universitatForm.gettNomUniversitat().addActionListener(this);
        this.universitatForm.gettUbicacioSeu().addActionListener(this);
        this.universitatForm.getDesar().addActionListener(this);
        this.universitatForm.getSortir().addActionListener(this);

    }

    private void afegirListenersLlista() {

        /*
         * Afegiu aquest mateix objecte (ControladorUniversitat) com a listener, al
         * botó sortir de la llista d'universitats.
         */
        this.universitatLlista.getSortir().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*
         * Seleccioneu l'acció a realitzar cridant el mètode seleccionarOpcio i
         * utilitzant la propietat actionCommand dels botons, que per defecte 
         * és igual al text dels botons. El mètode getActionCommand de l'esdeveniment 
         * retorna la propietat actionCommand de l'objecte que ha produït l'acció.
         * Noteu que els botons amb el mateix text (Sortir) han d'establir la 
         * propietat actionCommand amb el mètode setActionCommand a un valor diferent 
         * per distingir-se: "SortirForm" i "SortirLlista" com es pot veure en el 
         * mètode seleccionarOpcio.
         * 
         */
        seleccionarOpcio(e.getActionCommand());

    }

    private void seleccionarOpcio(String opcio) {

        GestorPersistencia gestor;

        switch (opcio) {

        case "0. Sortir":
            /*
            * Tancar menu d'universitats i tornar al menú principal
            */
            menuUniversitat.setVisible(false);
            menuUniversitat.dispose(); // release resources of the window
            new ControladorPrincipal(); // call to ControladorPrincipal to show the main menu
            break;

        case "1. Alta Universitat":
            /*
             * Es comprova si no s'ha arribat al màxim d'universitats.
             * En cas afirmatiu: es mostra un formulari de la classe UniversitatForm i s'afegeixen 
             * els listeners a cada botó del formulari de la universitat.
             * En cas negatiu (s'ha arribat al màxim): es mostra el següent missatge mitjançant
             * JOptionPane.showMessageDialog: "Màxim nombre d'universitats assolit."
             */

            // Comprovem si s'ha arribat al màxim d'universitats 
            if ( ControladorPrincipal.getpUniversitats() < ControladorPrincipal.getMAXUNIVERSITATS() ){
                
                menuUniversitat.setVisible(false);
                menuUniversitat.dispose(); // release resources of the window
                this.universitatForm = new UniversitatForm();
                // Afegiu els escoltadors de la vista de UniversitatForm
                this.afegirListenersForm();

            } else{
                JOptionPane.showMessageDialog(menuUniversitat, "Màxim nombre d'universitats assolit.");
            }
            
            break;	

        case "2. Seleccionar Universitat":
            menuUniversitat.setVisible(true);
            if (ControladorPrincipal.getUniversitats()[0] != null) {
                seleccionarUniversitat();
            } else {
                JOptionPane.showMessageDialog(menuUniversitat, "Abans s'ha de crear al menys una universitat");
            }
            break;

        case "3. Llistar Universitats":
            if (ControladorPrincipal.getUniversitats()[0] != null) {
                universitatLlista = new UniversitatLlista();
                afegirListenersLlista();
            } else {
                menuUniversitat.setVisible(true);
                JOptionPane.showMessageDialog(menuUniversitat, "Abans s'ha de crear al menys una universitat");
            }
            break;

        case "4. Carregar Universitat":
            menuUniversitat.setVisible(true);

            gestor = new GestorPersistencia();

            Universitat universitat;

            String fitxer = JOptionPane.showInputDialog(null, "Nom de la universitat que es vol carregar?", "Carregar Universitat", JOptionPane.PLAIN_MESSAGE); 

            try {
                gestor.carregarUniversitat(ControladorPrincipal.getMETODESPERSISTENCIA()[0], fitxer);

                universitat = ((GestorXML) gestor.getGestor()).getUniversitat();

                int pos = comprovarUniversitat(universitat.getNomUniversitat());

                if (pos >= 0) {
                    Object[] options = { "OK", "Cancel·lar" };
                    int i = JOptionPane.showOptionDialog(null, "Premeu OK per substituir.",
                                    "La universitat ja existeix", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                                    null, options, options[0]);

                    if (i == 0) {
                        ControladorPrincipal.getUniversitats()[pos] = universitat;
                    }

                } else {
                    ControladorPrincipal.getUniversitats()[ControladorPrincipal.getpUniversitats()] = universitat;
                    ControladorPrincipal.setpUniversitats();
                    JOptionPane.showMessageDialog(menuUniversitat, "Universitat afegida correctament");
                }
            } catch (GestorUniversitatsException e) {
                JOptionPane.showMessageDialog(menuUniversitat, e.getMessage());
            }
            break;

        case "5. Desar Universitat":
            /*
             * Es comprova si s'ha seleccionat la universitat: - Si no s'ha
             * seleccionat es mostra un missatges d'error (JOptionPane.showMessageDialog) -
             * Si s'ha seleccionat, es desa la universitat cridant a
             * desarUniversitat del gestor de persistència. El nom del fitxer ha de ser
             * "universitat".
             * 
             * NOTA: Si es produeix alguna excepció de tipus GestorUniversitatsException,
             * s'ha de capturar i mostrar el missatge que retorna l'excepció (getMessage())
             * mitjançant JOptionPane.showMessageDialog.
             */

            if (ControladorPrincipal.getUniversitatActual() != null){

                String tipusPersistencia  = ControladorPrincipal.getMETODESPERSISTENCIA()[0];
                String nomFitxer = ControladorPrincipal.getUniversitatActual().getNomUniversitat(); // nom de la universitat a guardar
                
                try {
                    ControladorPrincipal.getGp().desarUniversitat(tipusPersistencia, nomFitxer, ControladorPrincipal.getUniversitatActual());

                } catch (GestorUniversitatsException e) {
                    JOptionPane.showMessageDialog(menuUniversitat, e.getMessage());
                }

                JOptionPane.showMessageDialog(menuUniversitat, "Universitat seleccionada desada correctament en fitxer XML");
            
            } else {
                JOptionPane.showMessageDialog(menuUniversitat, "No s'ha seleccionat cap universitatº");
            }

            break;


        case "SortirForm": // Cas de sortir de la finestra de Universitat Form
            menuUniversitat.setVisible(true);
            universitatForm.dispose();
            break;

        case "SortirLlista": // Cas de sortir de la finestra de Universitat Llista
            menuUniversitat.setVisible(true);
            universitatLlista.dispose();
            break;

        case "Desar": // Cas de desar de la finestra de Universitat Form -> es crea una universitat amb les dades introduides
            universitat = new Universitat(universitatForm.gettNomUniversitat().getText(),
                            universitatForm.gettUbicacioSeu().getText());
            ControladorPrincipal.getUniversitats()[ControladorPrincipal.getpUniversitats()] = universitat;
            ControladorPrincipal.setpUniversitats();
            ControladorPrincipal.setUniversitatActual(universitat); // per defecte es posa com a universitat acabada d'afegir la universitat actual
            System.out.println("Desar");
            break;
        }

    }

    private void seleccionarUniversitat() {
        String[] noms = new String[ControladorPrincipal.getpUniversitats()];

        int i = 0;

        for (Universitat universitat : ControladorPrincipal.getUniversitats()) {
            if (universitat != null) {
                noms[i] = universitat.getNomUniversitat();
            }

            i++;
        }

        int messageType = JOptionPane.QUESTION_MESSAGE;
        int codi = JOptionPane.showOptionDialog(null, "Selecciona una universitat",
                        "Selecció de la universitat", 0, messageType, null, noms, "A");

        if (codi != JOptionPane.CLOSED_OPTION) {
            ControladorPrincipal.setUniversitatActual(ControladorPrincipal.getUniversitats()[codi]);
        }
    }

    private int comprovarUniversitat(String nom) {
        boolean trobat = false;

        int pos = -1;

        for (int i = 0; i < ControladorPrincipal.getUniversitats().length && !trobat; i++) {
            if (ControladorPrincipal.getUniversitats()[i] != null) {
                if (ControladorPrincipal.getUniversitats()[i].getNomUniversitat().equals(nom)) {
                        pos = i;
                        trobat = true;
                }
            }
        }

        return pos;
    }
}
