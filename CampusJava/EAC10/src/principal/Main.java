package principal;

import controlador.ControladorPrincipal;
import javax.swing.SwingUtilities;

/**
 *
 * @author fgarin
 */
public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ControladorPrincipal();
				/* Heu de tenir en compte que heu de canviar l’execució de la classe principal per la de la nova classe “Main”, 
				què és des d’on s’executarà l’aplicació mitjançant la interfície gràfica d’usuari. */

			}
		});
	}

}
