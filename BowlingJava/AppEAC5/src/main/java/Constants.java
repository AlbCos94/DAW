public class Constants {
	// aqui nomes farem crida a constants
    // UNICA CLASSE QUE PODRA SER UTILITZADA PER ALTRES CLASSES (A PART DEL MAIN de AppEAC5)!!
    
    // All the constants needed for Bowling Program
    // Constant declarations
    private static final int PLAYER_DATA_ELEMENTS = 3; // number of data elemetns that will be add for each player (name, surname and age)
    private static final int POS_NAME = 0;
    private static final int POS_LASTNAME = 1;
    private static final int POS_AGE = 2;
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 99;
    private static final int ROUNDS_NUMBER = 10; // number of rounds that will be played
    private static final int MAX_POINTS = 10; // max number of points a player can get by round
    private static final int OPTION_POINT_ROUND = 1; // option given to introduce the points of a round
    private static final int OPTION_SHOW_TABLE = 2; // option given to display the points table
    private static final int OPTION_QUIT = 0; // option given to finish the program
    private static final String SPLIT_LINE = "-"; // line displayed in the menu
    private static final int NUMBER_DOTS_MENU_LINE = 30;
    private static final int NUMBER_DOTS_TABLE_LINE = 120;
    private static final String MENU_FULLNAME = "FULL NAME"; // line displayed in the menu
    private static final String MENU_AGE = "AGE"; // line displayed in the men
    private static final String MENU_TITLE = "GESTIO IOC BOWLING"; // title displayed in the menu
    private static final String ERROR_TITLE = "ERROR"; // error title displayed in the menu
    private static final String MENU_TEXT = "1) Puntuar ronda.\n2) Mostrar tauler. \n0) Sortir."; // Options menu
    private static final String ERROR_OPTION = "No s'ha introduït un enter vàlid com a opció."; // Options menu
    private static final String ROUND_TO_POINT = "Quina ronda vol puntuar?"; // Question to ask to point a round
    private static final String ROUND_TO_POINT_ERROR = "La ronda introduïda no existeix. Introdueixi un valor entre 1 i " + ROUNDS_NUMBER; // Error round to point
    private static final String QUESTION_ENTER_POINTS = "Introdueixi els punts per "; 
    private static final String ERROR_ENTER = "No s'ha introduït un número enter";
    private static final String ERROR_ENTER_RANGE = "Els punts han de ser entre 0 i ";
    private static final String ASK_FOR_PLAYERNAME = "Introdueixi el nom del jugador";
    private static final String ERROR_PLAYERNAME = "El nom introduït es incorrecte";  
    private static final String ASK_FOR_PLAYERSURNAME = "Introdueixi el cognom del jugador";
    private static final String ERROR_PLAYERSURNAME = "El cognom introduït es incorrecte";   
    private static final String ASK_FOR_PLAYERAGE = "Introdueixi l'edat del jugador";
    private static final String ERROR_PLAYERAGE = "L'edat introduïda es incorrecte"; 
    private static final String ERROR_PLAYERAGE_RANGE = "L'edat introduïda ha de ser un valor entre 0 i 99 anys";   
    private static final String ASK_FOR_NUM_PLAYERS = "\nQuants jugadors hi haurà?";
    private static final String ERROR_NUM_PLAYERS = "No s'ha introdït un nombre correcte de jugadors";
    private static final String QUESTION_OPTIONS = "Introdueixi un valor enter per l'opció";

}