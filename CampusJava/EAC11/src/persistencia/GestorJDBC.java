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
        private static String nomUniversitatSQL = "SELECT * FROM IOC2425S2.UNIVERSITAT WHERE NOMUNIVERSITAT=?";

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
	private static String insereixUniversitatSQL = "INSERT INTO IOC2425S2.UNIVERSITAT VALUES(?,?)"; // NOMUNIVERSITAT, UBICACIOSEU

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
	private static String actualitzaUniversitatSQL = "UPDATE IOC2425S2.UNIVERSITAT SET NOMUNIVERSITAT=?, UBICACIOSEU=? WHERE NOMUNIVERSITAT=?";

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
	private static String eliminaCampusSQL = "DELETE FROM IOC2425S2.CAMPUS WHERE UNIVERSITAT=?";
        
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
	private static String insereixCampusSQL = "INSERT INTO IOC2425S2.CAMPUS VALUES(?,?,?)";

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
	private static String seleccionaCampusSQL = "SELECT * FROM IOC2425S2.CAMPUS WHERE UNIVERSITAT=?";

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
        public void estableixConnexio() {

            
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");

                // Establlir connexió
                String urlBaseDades = "jdbc:derby://localhost:1527/EAC112425S2";
                String usuari = "ioc2425s2";
                String contrasenya = "abc123";

                this.connexio = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);

                // Preparar el Objectes "PrepareStatement"
                this.nomUniversitatSt = connexio.prepareStatement(this.nomUniversitatSQL);
                this.insereixUniversitatSt = connexio.prepareStatement(this.insereixUniversitatSQL);
                this.actualitzaUniversitatSt = connexio.prepareStatement(this.actualitzaUniversitatSQL);
                this.eliminaCampusSt = connexio.prepareStatement(this.eliminaCampusSQL);
                this.insereixCampusSt = connexio.prepareStatement(this.insereixCampusSQL);
                this.seleccionaCampusSt = connexio.prepareStatement(this.seleccionaCampusSQL);

                
            } catch(Exception e){
                e.printStackTrace();
                //throw e;
                //System.out.println(e.getMessage());
            }
            
        }
        
        
	

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
        @Override
	public void desarUniversitat(String nomFitxer, Universitat universitat)throws GestorUniversitatsException{
            

            try {
                
                // Set universitat
                this.setUniversitat(universitat);
                
                // Establim la connexió amb la base de dades
                this.estableixConnexio();
                

                // Check if university exists
                this.nomUniversitatSt.setString(1, this.universitat.getNomUniversitat()); // fem el set del primer parametre amb el nom de la universitat en qüestió
                ResultSet resUniversities = this.nomUniversitatSt.executeQuery();
                
                
                // registres actualitzats
                int rowsInsertedUni = 0;
                int rowsDeletedCampus = 0;
                // A l’inici de tot, l’apuntador està una posició per endavant de la primera fila,
                if ( resUniversities.next() ){
                    // Cas Existeix la universitat
                    
                    // Fem update de la universitat 
                    this.actualitzaUniversitatSt.setString(1, this.universitat.getNomUniversitat());
                    this.actualitzaUniversitatSt.setString(2, this.universitat.getUbicacioSeu());
                    this.actualitzaUniversitatSt.setString(3, this.universitat.getNomUniversitat());
                    rowsInsertedUni = this.actualitzaUniversitatSt.executeUpdate();
                    
                    // Eliminem tots el campus que tenen com a universitat aquella universitat que actualitzem
                    this.eliminaCampusSt.setString(1, this.universitat.getNomUniversitat());
                    
                    rowsDeletedCampus = this.eliminaCampusSt.executeUpdate();
                    
                    
                }else{
                    // Cas NO existeix la universitat
                    
                    // Desar universitat a la taula UNIVERSITAT
                    this.insereixUniversitatSt.setString(1, this.universitat.getNomUniversitat());
                    this.insereixUniversitatSt.setString(2, this.universitat.getUbicacioSeu());
                    rowsInsertedUni = this.insereixUniversitatSt.executeUpdate();
                    
      
                }
                
                
                // Sigui el cas que sigue -> Desar tots els Campus de la universitat a la taula Campus
                int rowsInsertedCampus = 0;
                for (int i = 0; i < this.universitat.getCampusList().size(); i++){

                    this.insereixCampusSt.setString(1, this.universitat.getCampusList().get(i).getNomCampus());
                    this.insereixCampusSt.setString(2, this.universitat.getCampusList().get(i).getUbicacio());
                    this.insereixCampusSt.setString(3, this.universitat.getNomUniversitat());

                    rowsInsertedCampus = this.insereixCampusSt.executeUpdate();

                }
                
                
                // Tanquem la connexió amb la base de dades
                this.tancaConnexio();


            } catch(Exception e) {

                GestorUniversitatsException gestUniExcept = new GestorUniversitatsException("GestorJDBC.desar");
                throw gestUniExcept;
            }
	}	

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
        @Override
	public void carregarUniversitat(String nomFitxer)throws GestorUniversitatsException {

            
            
            try {
                




            } catch(Exception e) {

                GestorUniversitatsException gestUniExcept = new GestorUniversitatsException("GestorJDBC.desar");
                throw gestUniExcept;
            }
	}	            

}
