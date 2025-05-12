package persistencia;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;
import exceptions.GestorUniversitatsException;
import model.Universitat;
import interfaces.ProveedorPersistencia;

/**
 *
 */
public class GestorDB4O implements ProveedorPersistencia {

	private ObjectContainer db; // objecte amb el que es podran fer totes les accions amb la BDOO
	private Universitat universitat;

	public Universitat getUniversitat() {
		return universitat;
	}

	public void setUniversitat(Universitat Universitat) {
		this.universitat = Universitat;
	}
	/*
	 * Paràmetres: cap.
	 *
	 * Acció:
	 * 
	 * - Heu de crear / obrir la base de dades "EAC112425S2.db4o".
	 * 
	 * - Aquesta base de dades ha de permetre que Universitat s'actualitzi en
	 * cascada.
	 *
	 * Retorn: cap.
	 *
	 */
        public void estableixConnexio() {

            try {
                // Establlir connexió amb actualitzacio en Cascada
                
                // Configuració per a cascada d'actualització per Universitat
                EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
                config.common().objectClass(Universitat.class).cascadeOnUpdate(true);

                // Obrir la base de dades amb el fitxer EAC112425S2.db4o
                this.db = Db4oEmbedded.openFile(config, "EAC112425S2.db4o");
                
            } catch(Exception e){

                System.out.println(e.getMessage());
            }
            
        }	

	public void tancaConnexio() {
		db.close();
	}

	/*
	 * Paràmetres: el nom del fitxer i la universitat a desar.
         *        
         * El primer paràmetre NO s'utilitza (és null).
	 *
	 * Acció:
	 * 
	 * - Heu d'establir la connexio i al final tancar-la.
	 * 
	 * - Heu de desar l'objecte Universitat passat per paràmetre sobre la base de
	 * dades. Heu d'inserir si no existia ja a la base de dades, o actualitzar en
	 * l'altre cas.
	 * 
	 * - S'ha de fer la consulta de l'existència amb Predicate.
	 *
	 * Retorn: cap.
	 *
	 */
        @Override
	public void desarUniversitat(String nomFitxer, Universitat universitat)throws GestorUniversitatsException{
            try {

                // Set universitat
                this.setUniversitat(universitat);      
                
                // Establim connexió
                this.estableixConnexio();
                               
                // Comprovar si ja existeix la universitat
                List<Universitat> uniExistents = db.query(new Predicate<Universitat>() {
                    @Override
                    public boolean match(Universitat u) {
                        return u.getNomUniversitat().equalsIgnoreCase(universitat.getNomUniversitat());
                    }
                });

                if (uniExistents.isEmpty()) {
                    // No existeix llavors inserim
                    db.store(universitat);
                } else {
                    // Ja existeix llavors actualitzem
                    Universitat uniExistent = uniExistents.get(0);
                    
                    // Actualitzem la universitat antiga amb els campus de la nova i la seva nova ubicacio
                    uniExistent.setUbicacioSeu(universitat.getUbicacioSeu());
                    uniExistent.setCampusList(universitat.getCampusList()); 
                    
                    db.store(uniExistent);
                }

                db.commit();
                this.tancaConnexio();                

            } catch(Exception e) {
                this.tancaConnexio(); 
                throw new GestorUniversitatsException("GestorDB4O.desar");
            }
        }

	/*
	 * Paràmetres: el nom de la universitat.
	 *
	 * Acció:
	 * 
	 * - Heu d'establir la connexio i al final tancar-la.
	 * 
	 * - Heu de carregar la universitat des de la base de dades assignant-la a
	 * l'atribut "universitat". Si no existeix, llanceu l'excepció
	 * GestorUniversitatException amb codi "GestorDB4O.noExisteix".
	 * 
	 * - S'ha de fer la consulta amb Predicate.
	 *
	 * Retorn: cap
	 *
	 */
        @Override
	public void carregarUniversitat(String nomFitxer)throws GestorUniversitatsException {
            try {
                
                // Establim connexió
                this.estableixConnexio();

                List<Universitat> result = db.query(new Predicate<Universitat>() {
                    @Override
                    public boolean match(Universitat u) {
                        return u.getNomUniversitat().equalsIgnoreCase(nomFitxer);
                    }
                });

                if (result.isEmpty()) {
                    throw new GestorUniversitatsException("GestorDB4O.noExisteix");
                } else {
                    this.setUniversitat(result.get(0));
                }

                this.tancaConnexio();
                

            }catch(Exception e) {
                this.tancaConnexio();
                GestorUniversitatsException gestUniExcept = new GestorUniversitatsException("GestorDB4O.carregar");
                throw gestUniExcept;
            }
        }
}
