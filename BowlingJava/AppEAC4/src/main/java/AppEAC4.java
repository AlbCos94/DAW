
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
    private static final String MENU_LINE = "--------------------------"; // line displayed in the menu
    private static final String MENU_TITLE = "GESTIO IOC BOWLING"; // title displayed in the menu
    private static final String ERROR_TITLE = "ERROR"; // error title displayed in the menu

    // Global variable declarations
    private String[][] playersData = null; // matrix that will contain data of the players // defer / lazy initialization - its creation is deferred until it is first used.
    private int[][] pointsMatrix = null; // matrix that will contain points of the players

    // Main methods
    public static void main(String[] args) {
        AppEAC4 bowlingApp = new AppEAC4();
        bowlingApp.start();
    }

    public void start() {
        String a = "\n hola Caracola";
        System.out.println(a); // auxiliar method needed when we create new methods inside main. 

        // SKELETON OF THE PROGRAMM - traffic light control
        // show menu
        // execute order

        // Testing area

        /* 
        initializePoints(5);
        initializePlayers(5);
        showMenu("1 - Primera opció\n2 - Segona opció\n3 - Tercera opció");
        showError("Error molt greu en l'aplicació");
        String cc = askForString("Introdueixi el seu nom", "No s'ha introduït cap informació");
        int b = askForInteger("Introdueixi la seva edat", "El valor introduit no és un nombre sencer");
        
        String[][] matrixTest = {{"", "", ""}, {"", "", ""}};

        insertPlayerNames(matrixTest, 0, "Pol", "Laac", 2);
       
        int e = 1;*/

        //System.out.printf("%5s %15s %10s %5s %5s %5s %5s %5s %5s %5s %5s %5s" ,"FULL NAME", "AGE", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10");
        //System.out.printf("%5s %15s %10s %5s %5s %5s %5s %5s %5s %5s %5s %5s" ,"FULL NAME", "AGE", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10");

        String[][] matrixTest ={{"Pol", "Llach", "43"}, {"Nil", "Puig", "23"}};
        int[][] pointsTest = {{8, 7, -1, -1, -1, -1, -1, -1, -1, -1}, {5, 4, -1, -1, -1, -1, -1, -1, -1, -1}};

        showRounds( matrixTest , pointsTest);
        //
        /* 
        String[] oneGuyData = {"Pol", "Llach", "43"};
        int[] oneGuyPoints = {8, 7, -1, -1, -1, -1, -1, -1, -1, -1};
        print1PlayersPoints(oneGuyData, oneGuyPoints);
        */
    }

    // Auxiliar methods:

    public int[][] initializePoints(int playersNumber) {

        if (playersNumber<=0) {
            System.out.println("Number of players should be greater than 0");
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
            System.out.println("Number of players should be greater than 0");
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

        String stringResult = MENU_LINE+"\n"+MENU_TITLE+"\n"+MENU_LINE+"\n"+menuText;
        System.out.println(stringResult); // printed in a new line
    }

    public void showError(String textError) {

        if ( (textError == null) || (textError.isEmpty()) ){
            return;
        }

        String stringResult = MENU_LINE+"\n"+ERROR_TITLE+"\n"+MENU_LINE+"\n"+textError;
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

        //reader.nextLine();
        //reader.close();
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

        //reader.nextLine();
        //reader.close();
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
        
        if ( (rowIndex < 0) || (rowIndex >= playersData.length) ) {
            return;
        }

        if ( (round < 0) || (round >= ROUNDS_NUMBER)){
            return;
        }   

        if ( (points < 0) || (points > MAX_POINTS)){
            return;
        }   

        pointsMatrix[rowIndex][round] = points;

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

        System.out.printf("%5s %15s %5s %5s %5s %5s %5s %5s %5s %5s %5s" ,"FULL NAME", "AGE", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10");
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
        System.out.printf("%5s %15s", fullName, onePlayersData[POS_AGE]);

        //String[] pPointsPrint = new String[pointsRow.length]; // player's points to print

        for (int i= 0; i<pointsRow.length; i++){ 
            if (pointsRow[i] == -1) {
                //pPointsPrint[i]="-";
                System.out.printf("%5s", "-");
            } else{
                //pPointsPrint[i]=String.valueOf(pointsRow[i]);
                System.out.printf("%5s", String.valueOf(pointsRow[i]));
            }
        }
        // line break is added at the end
        System.out.print("\n");

        //System.out.printf("%5s %15s %10s %5s %5s %5s %5s %5s %5s %5s %5s %5s %n" , fullName, onePlayersData[POS_AGE], pPointsPrint[0], pPointsPrint[1], pPointsPrint[2], pPointsPrint[3], pPointsPrint[4], pPointsPrint[5], pPointsPrint[6], pPointsPrint[7], pPointsPrint[8], pPointsPrint[9]);


    }
 
}
