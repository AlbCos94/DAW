
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
    private static final int ROUNDS_NUMBER = 10; // number of rounds that will be played
    private static final String MENU_LINE = "--------------------------"; // line displayed in the menu
    private static final String MENU_TITLE = "GESTIO IOC BOWLING"; // title displayed in the menu

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
        initializePoints(5);
        initializePlayers(5);
        showMenu("1 - Primera opció\n2 - Segona opció\n3 - Tercera opció");
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

        System.out.println(MENU_LINE+"\n"+MENU_TITLE+"\n"+MENU_LINE);
        System.out.println(menuText);
    }

    public void showError(String textError) {
        
    }

    public String askForString(String message, String errorMessage){
        return null;
    }
    
    public int askForInteger(String message, String errorMessage) {
        return 1;   
    }

    public void insertPlayerNames(String[][] playersData, int rowNumber, String name, String lastName, int age) {
         
    }

    public void setRoundPoints(int[][] pointsMatrix, int rowIndex, int round, int points) {
        
    }

    public void showRounds(String[][] playersData, int[][] pointsMatrix) {
        
    }
 
}
