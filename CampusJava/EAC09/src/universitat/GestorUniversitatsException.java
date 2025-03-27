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


        /* 
        String stringCause = new String();
        String textMessage = new String();

        Throwable ExceptionCause = super.getCause();
        
        if (ExceptionCause!=null){
            stringCause = ExceptionCause.toString();
            textMessage = super.getMessage();
        } else {
        
        }
        
        return stringCause + " - " + textMessage;
        */
    }

    
}


