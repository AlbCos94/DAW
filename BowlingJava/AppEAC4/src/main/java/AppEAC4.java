
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author Albert Costa Ruiz
 */
public class AppEAC4 {
    
    // Constant declarations
    private static final int PLAYER_DATA_ELEMENTS = 3; // number of data elemetns that will be add for each player ( name, surname and age)
    private static final int POS_NAME = 0;
    private static final int POS_LASTNAME = 1;
    private static final int POS_AGE = 2;
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
    private static final String ERROR_OPTION = "No s'ha introduït una opció vàlida."; // Options menu
    private static final String ROUND_TO_POINT = "Quina ronda vol puntuar?"; // Questio to ask to point a round
    private static final String ROUND_TO_POINT_ERROR = "La ronda introduïda no existeix. Introdueixi un valor entre 1 i " + ROUNDS_NUMBER; // Error round to point
    private static final String QUESTION_ENTER_POINTS = "Introdueixi els punts per "; 
    private static final String ERROR_ENTER_POINTS = "Valor de punts introduït erroni.";
    private static final String ERROR_ENTER_RANGE = "Els punts han de ser entre 0 i ";
    private static final String ASK_FOR_PLAYERNAME = "Introdueixi el nom del jugador";
    private static final String ERROR_PLAYERNAME = "El nom introduït es incorrecte";  
    private static final String ASK_FOR_PLAYERSURNAME = "Introdueixi el cognom del jugador";
    private static final String ERROR_PLAYERSURNAME = "El cognom introduït es incorrecte";   
    private static final String ASK_FOR_PLAYERAGE = "Introdueixi l'edat del jugador";
    private static final String ERROR_PLAYERAGE = "L'edat introduïda es incorrecte";  
    private static final String ASK_FOR_NUM_PLAYERS = "\nQuants jugadors hi haurà?";
    private static final String ERROR_NUM_PLAYERS = "No s'ha introdït un nombre correcte de jugadors";

    // Global variable declarations
    private String[][] playersData = null; // matrix that will contain data of the players // defer / lazy initialization - its creation is deferred until it is first used.
    private int[][] pointsMatrix = null; // matrix that will contain points of the players

    // MAIN METHODS
    public static void main(String[] args) {
        AppEAC4 bowlingApp = new AppEAC4();
        bowlingApp.start();
    }

    public void start() {
        // Global data initizalization
        askingForPlayersAndDataInitialization();
        if (playersData == null){
            return; // end of the program
        }
        optionManager(); //traffic light control
    }

    // AUXILIAR METHODS

    public int[][] initializePoints(int playersNumber) {

        if (playersNumber<=0) {
            System.out.println(ERROR_NUM_PLAYERS);
            return null; 
        }

        pointsMatrix = new int[playersNumber][ROUNDS_NUMBER];

        // pointsMatrix it is filled with -1's
        for (int i= 0; i<playersNumber; i++){ 
            for (int j= 0; j<ROUNDS_NUMBER; j++){
                pointsMatrix[i][j] = -1;
            }              
        }

        return pointsMatrix;
    }

    public String[][] initializePlayers(int playersNumber) {

        if (playersNumber<=0) {
            System.out.println(ERROR_NUM_PLAYERS);
            return null; 
        }

        playersData = new String[playersNumber][PLAYER_DATA_ELEMENTS]; 
        // playersData it is filled with empty strings
        for (int i= 0; i<playersNumber; i++){ 
            for (int j= 0; j<PLAYER_DATA_ELEMENTS; j++){
                playersData[i][j] = "";
            }              
        }
        return playersData;
    }

    public void showMenu(String menuText) {
        
        if ( (menuText == null) || (menuText.isEmpty()) ){
            return;
        }
        String stringResult = SPLIT_LINE.repeat(NUMBER_DOTS_MENU_LINE)+"\n"+MENU_TITLE+"\n"+SPLIT_LINE.repeat(NUMBER_DOTS_MENU_LINE)+"\n"+menuText;
        System.out.println(stringResult); // printed in a new line
    }

    public void showError(String textError) {

        if ( (textError == null) || (textError.isEmpty()) ){
            return;
        }
        String stringResult = SPLIT_LINE.repeat(NUMBER_DOTS_MENU_LINE)+"\n"+ERROR_TITLE+"\n"+SPLIT_LINE.repeat(NUMBER_DOTS_MENU_LINE)+"\n"+textError;
        System.out.println(stringResult); // printed in a new line
    }

    public String askForString(String message, String errorMessage){
        
        Scanner reader = new Scanner(System.in); //the scanner is initialized
        boolean end = false;
        String inputString = "";

        do{
            System.out.println(message); // user message with a request
            inputString = reader.nextLine(); // get the next string line introduces by user (everything he wrote before enter -> (\n) )

            if (!inputString.isEmpty()){
                end = true;
            } else{
                showError(errorMessage);
            }
        } while ( end == false );

        return inputString;
    }
    
    public int askForInteger(String message, String errorMessage) {
        
        Scanner reader = new Scanner(System.in); //the scanner is initialized
        boolean corectData = false;
        int inputInt = 0;

        do{
            System.out.println(message); // user message with a request

            corectData = reader.hasNextInt();

            if(reader.hasNextInt()){
                corectData = true;
                inputInt = reader.nextInt();
            } else{
                
                showError(errorMessage);
                reader.next();
            }
        } while( !corectData );

        return inputInt;
    }

    public void insertPlayerNames(String[][] playersData, int rowNumber, String name, String lastName, int age) {
        
        if (playersData == null) {
            return;
        }

        if ( (rowNumber < 0) || (rowNumber >= playersData.length) ) {
            return;
        }

        if ( (name == null) || (name.isEmpty()) ){
            return;
        }

        if ( (lastName == null) || (lastName.isEmpty()) ){
            return;
        }

        if (age < 0){
            return;
        }        

        playersData[rowNumber][POS_NAME] = name;
        playersData[rowNumber][POS_LASTNAME] = lastName;
        playersData[rowNumber][POS_AGE] = String.valueOf(age);
    }

    public void setRoundPoints(int[][] pointsMatrix, int rowIndex, int round, int points) {
        
        if (pointsMatrix == null) {
            return;
        }
        
        // playersData
        if ( (rowIndex < 0) || (rowIndex >= pointsMatrix.length) ) {
            return;
        }

        if ( (round <= 0) || (round >= ROUNDS_NUMBER)){
            return;
        }   

        if ( (points < 0) || (points > MAX_POINTS)){
            return;
        }   

        pointsMatrix[rowIndex][round-1] = points;
    }

    public void showRounds(String[][] playersData, int[][] pointsMatrix) {

        if ( (playersData == null) || (pointsMatrix == null) ) {
            return;
        }

        // number of rows of each matrix do not match 
        if ( playersData.length != pointsMatrix.length ) {
            return;
        }

        if ( playersData.length == 0 ) {
            return;
        }

        //Print header of the table containing all the rounds
        printHeaderTablePoints(ROUNDS_NUMBER);
        System.out.print("\n");

        for (int i= 0; i<playersData.length; i++){ 
            print1PlayersPoints(playersData[i], pointsMatrix[i]);
            System.out.print("\n"); // line break is added at the end
        }
    }


    public void print1PlayersPoints(String[] onePlayersData, int[] pointsRow) {

        if ( (onePlayersData == null) || (pointsRow == null) ) {
            return;
        }

        if ( onePlayersData.length == 0 ) {
            return;
        }

        if ( pointsRow.length == 0 ) {
            return;
        }

        // print full name plus age
        String fullName = onePlayersData[POS_NAME] + " " + onePlayersData[POS_LASTNAME];
        System.out.printf("%-15s %10s", fullName, onePlayersData[POS_AGE]);

        for (int i= 0; i<pointsRow.length; i++){ 
            if (pointsRow[i] == -1) {
                System.out.printf("%5s", "-");
            } else{
                System.out.printf("%5s", String.valueOf(pointsRow[i]));
            }
        }  
    }
 
    public void printHeaderTablePoints(int roundsNumber) {

        if ( roundsNumber == 0)  {
            return;
        }

        // print "full name" plus "age"
        System.out.printf(SPLIT_LINE.repeat(NUMBER_DOTS_TABLE_LINE) +"\n");
        System.out.printf("%-15s %10s", MENU_FULLNAME, MENU_AGE);
        
        //String[] pPointsPrint = new String[pointsRow.length]; // player's points to print
        for (int i= 0; i<roundsNumber; i++){
            System.out.printf("%5s", "R"+String.valueOf(i+1));
        }
        System.out.printf("\n");
        System.out.printf(SPLIT_LINE.repeat(NUMBER_DOTS_TABLE_LINE));
     }

    public void askingForPlayersAndDataInitialization() {

        String namePlayer = "";
        String surnamePlayer = "";
        int agePlayer = 0;

        int numPlayers = 0;

        numPlayers = askForInteger(ASK_FOR_NUM_PLAYERS, ERROR_NUM_PLAYERS);
        
        if (numPlayers <= 0) {
            showError(ERROR_NUM_PLAYERS);
            return; // salit totalmente del programa
        }

        // Matrixs are initialized
        initializePlayers(numPlayers);
        initializePoints(numPlayers);      

        for (int i= 0; i<numPlayers; i++){
            String playerNumber = String.valueOf(i+1)+"/"+String.valueOf(numPlayers);
            String questionName  = playerNumber+" - "+ ASK_FOR_PLAYERNAME;
            String questionSurname  = playerNumber+" - "+ ASK_FOR_PLAYERSURNAME;
            String questionAge  = playerNumber+" - "+ ASK_FOR_PLAYERAGE;
            namePlayer = askForString(questionName, ERROR_PLAYERNAME);
            surnamePlayer = askForString(questionSurname, ERROR_PLAYERSURNAME);
            agePlayer = askForInteger(questionAge, ERROR_PLAYERAGE);
            insertPlayerNames(playersData, i, namePlayer, surnamePlayer, agePlayer);
        }
    }

    public void askingForRoundPoints() {

        int roundNumber = 0;
        int pointsToInsert = 0;
        boolean correctPoints = false;
        boolean correctRound = false;
        String playerFullName = "";

        do{
            roundNumber = askForInteger(ROUND_TO_POINT, ROUND_TO_POINT_ERROR);

            if ( (roundNumber<1) || (roundNumber > ROUNDS_NUMBER) ){
                showError(ROUND_TO_POINT_ERROR);
                correctRound = false;
            } else {
                correctRound = true;
            }
        } while (!correctRound);
  
        // Loop among all the players of the round
        for (int i= 0; i<playersData.length; i++){
            playerFullName = playersData[i][0]+" "+playersData[i][1];

            do{
                pointsToInsert = askForInteger(QUESTION_ENTER_POINTS + playerFullName, ERROR_ENTER_POINTS); // it gives us an int but not sure if between 1 and 10

                if ( (pointsToInsert >= 0) && (pointsToInsert <= MAX_POINTS) ){
                    correctPoints = true;
                } else {
                    showError(ERROR_ENTER_RANGE + MAX_POINTS);
                    //showError("Els punts han de ser entre 0 i " + MAX_POINTS);
                    correctPoints = false;
                }

            } while (!correctPoints);

            setRoundPoints(pointsMatrix, i, roundNumber, pointsToInsert);
        }
    }

    public void optionManager() {

        Scanner reader = new Scanner(System.in); //the scanner is initialized
        boolean corectData = false;
        boolean finish = false;
        int inputInt = 0;

        do{
            showMenu(MENU_TEXT);

            corectData = reader.hasNextInt();

            if(corectData){
                
                inputInt = reader.nextInt();

                if (inputInt == OPTION_POINT_ROUND){
                    askingForRoundPoints();
                } else if (inputInt == OPTION_SHOW_TABLE){                   
                    showRounds(playersData,pointsMatrix);
                } else if (inputInt == OPTION_QUIT) {
                    finish = true;
                } else{
                    showError(ERROR_OPTION);
                }

            } else{
                
                showError(ERROR_OPTION);
                reader.next();
            }
        } while( !finish );
    }
}
