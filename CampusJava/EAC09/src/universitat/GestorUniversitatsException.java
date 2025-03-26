package universitat;

//import static universitat.UnitatUniversitat.DADES;

/**
 *
 */
public class GestorUniversitatsException extends Exception {
    
    @Override
    public String getMessage() {
        
        String stringCause = new String();
        String textMessage = new String();

        Throwable ExceptionCause = super.getCause();
        
        if (ExceptionCause!=null){
            stringCause = ExceptionCause.toString();
            textMessage = super.getMessage();
        } else {
        
        }
        
        return stringCause + " - " +textMessage;
        
    }

    
}


