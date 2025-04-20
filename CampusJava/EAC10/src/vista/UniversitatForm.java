package vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author fgarin
 */
public class UniversitatForm extends JFrame {

    private final int AMPLADA = 300;
    private final int ALCADA = 200;

    private JLabel lNomUniversitat;
    private JTextField tNomUniversitat;
    private JLabel lUbicacioSeu;
    private JTextField tUbicacioSeu;

    private JButton desar;
    private JButton sortir;

    public UniversitatForm() {
        /*
         * TODO
         * 
         * No afegiu cap listener a cap control.
         * 
         * Amb els atributs d'aquesta classe, heu de fer el següent:
         * 
         * - Heu de posar el títol "Formulari Universitat" a l'objecte JFrame
         * 
         * - Heu d'establir un layout Grid d'una columna per al JFrame
         * 
         * - Heu de crear els controls del formulari (JLabels i JTextFields).
         * 
         * - Heu de crear els botons del formulari.
         * 
         * - Heu d'afegir-ho tot al panell per defecte del JFrame
         * (this.getContentPane()).
         * 
         * - Heu de fer visible el frame amb l'amplada i alçada de les constants AMPLADA
         * i ALCADA, i fer que la finestra es tanqui quan l'usuari ho fa amb el control
         * "X" de la finestra. Per fer tot això, heu de cridar al mètode showFinestra()
         * d'aquesta classe.
         * 
         */


        //Contenidor d’alt nivell - Titol Formulari Universitat
        this.setTitle("Formulari Universitat");

        // Establir un GridLayout d'una columna per al JFrame
        GridLayout gridLayout = new GridLayout(6,1);

        // Controls del formulari (JLabels i JTextFields)
        this.lNomUniversitat = new JLabel();
        this.lNomUniversitat.setText("NomUniversitat");

        this.tNomUniversitat = new JTextField();


        this.lUbicacioSeu = new JLabel();
        this.lUbicacioSeu.setText("Ubicació");

        this.tUbicacioSeu = new JTextField();


        // Creació dels botons
        this.desar = new JButton("Desar");
        this.sortir = new JButton("Sortir");
        this.sortir.setActionCommand("SortirForm");

        // Afegir tot al panell per defecte del JFrame
        this.getContentPane().setLayout(gridLayout);
        
        this.getContentPane().add(this.lNomUniversitat);
        this.getContentPane().add(this.tNomUniversitat);

        this.getContentPane().add(this.lUbicacioSeu);
        this.getContentPane().add(this.tUbicacioSeu);

        this.getContentPane().add(this.desar);
        this.getContentPane().add(this.sortir);


        // Set de les dimensions, tancar finestra amb X i fer el frame visible
        this.showFinestra();


    }

    private void showFinestra() {
        // Es mostra la finestra amb propietats per defecte
        this.setSize(AMPLADA, ALCADA);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getlNomUniversitat() {
        return lNomUniversitat;
    }

    public void setlNomUniversitat(JLabel lNomUniversitat) {
        this.lNomUniversitat = lNomUniversitat;
    }

    public JTextField gettNomUniversitat() {
        return tNomUniversitat;
    }

    public void settNomUniversitat(JTextField tNomUniversitat) {
        this.tNomUniversitat = tNomUniversitat;
    }

    public JLabel getlUbicacioSeu() {
        return lUbicacioSeu;
    }

    public void setlUbicacioSeu(JLabel lUbicacioSeu) {
        this.lUbicacioSeu = lUbicacioSeu;
    }

    public JTextField gettUbicacioSeu() {
        return tUbicacioSeu;
    }

    public void settUbicacioSeu(JTextField tUbicacioSeu) {
        this.tUbicacioSeu = tUbicacioSeu;
    }

    public JButton getDesar() {
        return desar;
    }

    public void setDesar(JButton desar) {
        this.desar = desar;
    }

    public JButton getSortir() {
        return sortir;
    }

    public void setSortir(JButton sortir) {
        this.sortir = sortir;
    }

}