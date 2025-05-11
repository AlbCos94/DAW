package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import exceptions.GestorUniversitatsException;
import model.Universitat;
import model.Campus;
import interfaces.ProveedorPersistencia;

/**
 *
 */
public class GestorJDBC implements ProveedorPersistencia {

	private Universitat universitat;

	private Connection connexio;

	public Universitat getUniversitat() {
		return universitat;
	}

	public void setUniversitat(Universitat universitat) {
		this.universitat = universitat;
	}

	/*
	 * PreparedStatement necessaris
	 */

	/*
	 * TODO
	 *
	 * Obtenir una universitat.
	 * 
	 * Sentència select de la taula "universitat". 
	 * Columnes: Totes. 
	 * Files: la de la universitat amb un nom que coincideixi amb el passat per paràmetre.
	 *
	 */
        private static String nomUniversitatSQL = "";

	private PreparedStatement nomUniversitatSt;

	/*
	 * TODO
	 *
	 * Afegir una universitat.
	 * 
	 * Sentència per afegir una universitat en la taula "universitat". Els
	 * valors dels camps són els que es passaran per paràmetre.
	 *
	 */
	private static String insereixUniversitatSQL = "";

	private PreparedStatement insereixUniversitatSt;

	/*
	 * TODO
	 *
	 * Actualitzar una universitat.
	 * 
	 * Sentència per actualitzar una universitat de la taula "universitat".
	 * Files a actualitzar: la que corresponguin al nom passat per paràmetre.
	 * Columnes a actualitzar: nom i ubicació amb els valors passats per paràmetre.
	 *
	 */
	private static String actualitzaUniversitatSQL = "";

	private PreparedStatement actualitzaUniversitatSt;

	/*
	 * TODO
	 *
	 * Eliminar campus (donat el nom d'una universitat)
	 * 
	 * Sentència que elimina els campus de la taula "campus" relacionats
	 * amb una universitat. 
	 * Files a eliminar: les que es corresponguin al nom de la universitat passat 
	 * per paràmetre.
	 *
	 */
	private static String eliminaCampusSQL = "";

	private PreparedStatement eliminaCampusSt;

	/*
	 * TODO
	 *
	 * Afegir un campus.
	 * 
	 * Sentència que afegix un campus a la taula "campus". Els valors dels
	 * camps són els que es passaran per paràmetre.
	 *
	 */
	private static String insereixCampusSQL = "";

	private PreparedStatement insereixCampusSt;

	/*
	 * TODO
	 *
	 * Seleccionar les campus d'una universitat.
	 * 
	 * Sentència que selecciona els campus de la taula "campus" d'una
	 * universitat determinada. 
	 * Columnes: totes. 
	 * Files: totes en les quals el nom de la universitat coincideixi amb 
	 * el passat per paràmetre.
	 *
	 */
	private static String seleccionaCampusSQL = "";

	private PreparedStatement seleccionaCampusSt;

	/*
	 * TODO
	 * 
	 * Paràmetres: cap
	 *
	 * Acció:
	 * 
	 * - Heu d'establir la connexio JDBC amb la base de dades EAC112425S2. 
	 * 
	 * - Heu de crear els objectes PrepareStatement declarats com a atributs d'aquesta 
	 * classe amb els respectius SQL declarats com a atributs just sobre cadascun 
	 * d'ells. 
	 * 
	 * - Heu de fer el catch de les possibles excepcions (en aquest mètode no llanceu
	 * GestorUniversitatsException, simplement, mostreu el missatge a consola de
	 * l'excepció capturada).
	 *
	 * Retorn: cap.
	 *
	 */


	

	public void tancaConnexio() throws SQLException {
		try {
			connexio.close();
		} finally {
			connexio = null;
		}
	}

	/*
	 * TODO
	 * 
	 * Paràmetres: el nom del fitxer i la universitat a desar.
	 *
         * El primer paràmetre NO s'utilitza (és null).
	 * 
         * Acció:
	 * 
	 * - Heu de desar la universitat sobre la base de dades.  
	 *                 
         * - La universitat s'ha de desar a la taula "universitat". 
	 * 
	 * - Cada campus de la universitat, s'ha de desar com a registre de la
	 *  taula "campus".
	 * 
	 * - Heu de tenir en compte que si la universitat ja existeix, heu de fer
	 * el següent:
	 * 
	 * - Actualitzar el registre universitat ja existent. 
	 * 
	 * - Eliminar tots els campus d'aquesta universitat de la taula 
	 * "campus" i després inserir els nous com si es tractes d'una nova 
	 * universitat.
	 * 
	 * - Si al fer qualsevol operació es produeix una excepció, llavors heu de
	 * llançar l'excepció GestorUniversitatsException amb codi "GestorJDBC.desar".
	 *
	 * Retorn: cap.
	 *
	 */
	

	/*
	 * TODO
	 * 
	 * Paràmetres: el nom de la universitat.
	 *
	 * Acció:
	 * 
	 * - Heu de carregar la universitat des de la base de dades.
	 * 
	 * - Per fer això, heu de cercar el registre universitat de la taula amb
	 * nom "universitat".
	 * 
	 * - A més, heu d'afegir els campus a la universitat a partir de la
	 * taula "campus".
	 * 
	 * - Si al fer qualsevol operació es dona una excepció, llavors heu de llançar
	 * l'excepció GestorUniversitatsException amb codi "GestorJDBC.carregar".
	 * 
	 * - Si el nomUniversitat donat no existeix a la taula campus, 
	 * llavors heu de llançar l'excepció GestorUniversitatsException amb codi 
	 * "GestorJDBC.noexist".
	 *
	 * Retorn: cap.
	 *
	 */
	

}
