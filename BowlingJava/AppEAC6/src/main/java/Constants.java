public class Constants {
    public static final int INDEX_NAME = 0;
    public static final int INDEX_LAST_NAME = 1;
    public static final int INDEX_AGE = 2;
    public static final int PLAYERS_MATRIX_COLUMNS = 3;
    public static final int THROWS_NUMBER = 10;
    public static final int MAX_POINTS = 10;
    public static final int POINTS_NO_PLAYED = -1;
    public static final int PLAYER_NOT_FOUND = -1;
    public static final String EMPTY_STRING = "";
    public static final String MESSAGE_ASK_PLAYERS_NUMBER = "Quants jugadors hi haurà?";
    public static final String MESSAGE_ASK_INTEGER_VALUE = "Introdueixi un valor enter per l'opció";
    public static final String MESSAGE_NOT_VALID_OPTION = "No s'ha introduït una opció vàlida";
    public static final String MESSAGE_INSERT_NAME = "Introdueixi el nom del jugador";
    public static final String MESSAGE_INSERT_LAST_NAME = "Introdueixi el cognom del jugador";
    public static final String MESSAGE_INSERT_FULL_NAME = "Introdueixi el nom complet del jugador";
    public static final String MESSAGE_INSERT_AGE = "Introdueixi l'edat del jugador";
    public static final String MESSAGE_INSERT_ROUND = "Quina ronda vol puntuar?";
    public static final String MESSAGE_INSERT_POINTS = "Introdueixi els punts per ";
    public static final String MESSAGE_ERROR_NO_INTEGER = "No s'ha introduït un número enter";
    public static final String MESSAGE_ERROR_INCORRECT_PLAYER_NUMBER = "No s'ha introduït un nombre correcte de jugadors";
    public static final String MESSAGE_ERROR_EMPTY_STRING = "S'ha introduït un text buit";
    public static final String MESSAGE_ERROR_NO_VALID_ROUND = "La ronda introduïda no existeix. Introdueixi un valor entre 1 i " + THROWS_NUMBER;
    public static final String MESSAGE_ERROR_NO_VALID_POINTS = "Els punts han de ser un valor entre 0 i " + MAX_POINTS;
    public static final String MESSAGE_ERROR_PLAYER_NOT_FOUND = "El jugador no s'ha trobat";
    public static final String MESSAGE_SEPARATOR = "--------------------------------------------------------------------------------------------------------------";
    public static final String START_MENU_HEADER = "GESTIO IOC BOWLING";
    public static final String START_MENU = """
                                    1) Puntuar ronda.
                                    2) Mostrar classificació.
                                    3) Corregir puntuació.
                                    4) Menú de gestió de fitxers.
                                    0) Sortir.
                                    """;
    public final static String ROUNDS_HEADER = "FULL NAME                    AGE         R1   R2   R3   R4   R5   R6   R7   R8   R9   R10";
    public final static String TEMP_LIN = "-----------------------------------------------------------------------------------------";
    public final static String ROUNDS_BOARD_FORMAT = "%-28s  %2s %10s %4s %4s %4s %4s %4s %4s %4s %4s %5s";
    public static final String EMPTY_SPACE = "";
    public static final String MESSAGE_ERROR_HEADER = "ERROR";   
    public final static String TOTALS_HEADER = "FULL NAME                    AGE         POINTS";
    public final static String TOTALS_BOARD_FORMAT = "%-28s  %2s %14d";
    //UF3
    public final static String MENU_FITXERS = "Menú per a gestionar els fitxers";
    public static final String DIRECTORY_MESSAGE_IO = "El directori de dades ";
    public static final String START_MENU_FILE = """
                                    1) Ubicació dels fitxers.
                                    2) Comprovar si existeix fitxer amb les partides.
                                    3) Mostrar l'estrucctura de nivell del directori de treball
                                    4) Carregar partida del fitxer l'històric.
                                    5) Esborrar fitxer històric parcialment.
                                    0) Sortir.
                                    """;
    public static final String DIRECTORY_CONTENT = "El contingut del directori és:";
    public static final String DATA_FILE = "dataBowling.txt";
    public static final String MESSAGE_FILE_EXISTS = "El fitxer de dades existeix";
    public static final String MESSAGE_FILE_DOES_NOT_EXIST = "El fitxer de dades no existeix";
    public static final String RETURN_MESSAGE = "Tornant al menu principal";
    public static final String RECOVERY_GAME = "Abans de fer la càrrrega, vols Guardar la partida actual o Sobreescriure-la(type 'G' or 'S')";                           
    public static final String NO_DATA_TO_RECOVERY ="No hi ha dades per carregar.";
    public static final String CODE_TO_RECOVERY = "Introdueix el codi numèric de recuperació: ";
    public static final String ERROR_DATA_IN = "Dada no correcta. Introdueix un número: ";
    public static final String DATA_SELECTED = "El número escollit és: ";
    public static final String DATA_LOADED_OK = "Procés realitzat correctament";
    public static final String MESSAGE_INSERT_DATA = "Introdueix una de les dates del llistat per eliminar els registres anteriors a la data especificada: ";
    public static final String MESSAGE_FILE_EMPTY = "No hi ha elements per recuperar. El fitxer és buit.";
    public static final String DATE_FORMAT = "yyyyMMddHHmm";
    public static final String UNIQUE_ID = "Identificadors únics:";
    public static final String ERROR_ARRAYS_SPACE = "Error: Les matrius no tenen suficient espai per emmagatzemar totes les dades.";
    public static final String MESSAGE_REG_BEFORE = "Els registres anteriors a ";
    public static final String MESSAGE_REG_BEFORE_FI = " han estat eliminats correctament.";
    public static final String MESSAGE_NO_UPDATE_FILE = "No s'ha pogut actualitzar el fitxer.";
    public static final String MESSAGE_ERROR_PROCESS = "S'ha produït un error: ";


    // My constant values
    public static final String DATA_FOLDER_NAME = "dades";
    public static final String DIRECTORY_CONTENT_MESSAGE = "El contingut del directori ";
    public static final String DIRECTORY_CONTENT_END_MESSAGE = " és:";
    public static final String SPLIT_CHAR = ",";
    public static final String NULL_MATRIX_DATA = "Matrius de dades nules";
    public static final String EMPTY_MATRIX_DATA = "Matrius de dades buides";
    public static final String MATRIX_NOT_EQUAL = "Matrius de mides diferents";
    public static final String INCORRECT_DATA_NUMBER = "No s'ha introduït data number";
    public static final String INCORRECT_DATE_FORMAT = "Format de la data incorrecta";
    public static final int MIN_NUM_DATAELEMENTS = 4;


}
