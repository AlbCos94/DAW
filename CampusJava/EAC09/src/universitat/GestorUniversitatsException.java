package universitat;

//import static universitat.UnitatUniversitat.DADES;

/**
 *
 */
public class GestorUniversitatsException extends Exception {
    
    private String codi; // codi de causa de l'exepció

    public GestorUniversitatsException (String codi){

        this.codi = codi;
    }


    @Override
    public String getMessage() {
        
        return "Codi causa: " + this.codi + " - Missatge: " + super.getMessage();

    }

    
}


