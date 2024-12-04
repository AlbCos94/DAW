

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author IOC - 2024-2025 - S1 - UF3
 */

import java.util.Scanner;

public class AppEAC6 {

    public static void main(String[] args) {
        AppEAC6 BowlingApp = new AppEAC6();
        //BowlingApp.start();
        BowlingApp.start();
    }

    //START METHOD FOR TESTING -> REMOVED WHEN FINISHED- UNCOMMENT THE OTHER ONE FOR FINAL USE
    public void start() {
        
        System.out.println("hola");
        FileUtils testFileUtils = new FileUtils();
        
        testFileUtils.inicialitzeWorkDirectory();
        System.out.println(testFileUtils.getDirectoryDades());
        testFileUtils.fileExists("C:/Users/alcos/OneDrive/Escritorio/testDaw/hola.txt");
        testFileUtils.fileExists("C:/Users/alcos/OneDrive/Escritorio/testDaw/vacio.txt");
        testFileUtils.fileExists("C:/Users/alcos/OneDrive/Escritorio/testDaw/texto.txt");

        testFileUtils.deleteFile("C:/Users/alcos/OneDrive/Escritorio/testDaw/hola.txt");
        testFileUtils.deleteFile("C:/Users/alcos/OneDrive/Escritorio/testDaw/vacio.txt");


        testFileUtils.showDirectory();



        testFileUtils.listUniqueFirstField("C:/Users/alcos/OneDrive/Escritorio/testDaw/splitFile2.txt");

        return;
    }


    /* 
    public void start() {
        //FileUtils object instantiation and initialize working directory
        FileUtils futils = new FileUtils();
        futils.inicialitzeWorkDirectory();

        // ask for the number of players
        int playersNumber = UtilsIO.askForInteger(Constants.MESSAGE_ASK_PLAYERS_NUMBER, Constants.MESSAGE_ERROR_NO_INTEGER);
        // if the number of players is less than 1, we return
        if (playersNumber < 1) {
            UtilsIO.showError(Constants.MESSAGE_ERROR_INCORRECT_PLAYER_NUMBER);
            return;
        }
        // initialize the players data and the points matrix
        BowlingData bowlingData = new BowlingData();
        bowlingData.initializePlayers(playersNumber);
        bowlingData.initializePoints(playersNumber);
        // ask the user for the player names
        for (int i = 0; i < bowlingData.playersData.length; i++) {
            var name = UtilsIO.askForString(i + 1 + "/" + bowlingData.playersData.length + " - " + Constants.MESSAGE_INSERT_NAME, Constants.MESSAGE_ERROR_EMPTY_STRING);
            var lastName = UtilsIO.askForString(i + 1 + "/" + bowlingData.playersData.length + " - " + Constants.MESSAGE_INSERT_LAST_NAME, Constants.MESSAGE_ERROR_EMPTY_STRING);
            var age = UtilsIO.askForInteger(i + 1 + "/" + bowlingData.playersData.length + " - " + Constants.MESSAGE_INSERT_AGE, Constants.MESSAGE_ERROR_NO_INTEGER);
            UtilsBowling.insertPlayerNames(bowlingData.playersData, i, name, lastName, age);
        }
        //Show the menu. Don't exit until the user wants to
        boolean exitLoop = false;
        while (!exitLoop) {
            UtilsIO.showMenu(Constants.START_MENU);
            int option = UtilsIO.askForInteger(Constants.MESSAGE_ASK_INTEGER_VALUE, Constants.MESSAGE_ERROR_NO_INTEGER);
            switch (option) {
                case 1: {
                    //Set the points for a round
                    askForRoundPoints(bowlingData.playersData, bowlingData.pointsMatrix);
                    UtilsIO.showRounds(bowlingData.playersData, bowlingData.pointsMatrix);
                    break;
                }
                case 2: {
                    //Show the totals
                    showTotalPoints(bowlingData.playersData, bowlingData.pointsMatrix);
                    break;
                }
                case 3: {
                    //Correct the points for a round
                    correctPlayerPoints(bowlingData.playersData, bowlingData.pointsMatrix);
                    break;
                }
                case 4:{
                    filesMenu(futils, bowlingData);
                    break;
                }
                case 0: {
                    //Save the data to the file databowling.txt.
                    futils.saveDataToFile(bowlingData.playersData, bowlingData.pointsMatrix);
                    //Exit the program
                    exitLoop = true;
                    break;
                }
                default: {
                    //Show an error message if the option is not valid
                    UtilsIO.showError(Constants.MESSAGE_NOT_VALID_OPTION);
                    break;
                }
            }
        }
    }
    

    */

    /* 
     private void filesMenu(FileUtils futils, BowlingData bowlingData) {
        boolean exitLoop = false;
        while (!exitLoop) {
            UtilsIO.showMenu(Constants.START_MENU_FILE);
            int option = UtilsIO.askForInteger(Constants.MESSAGE_ASK_INTEGER_VALUE, Constants.MESSAGE_ERROR_NO_INTEGER);
            switch (option) {
                case 1: {
                    //Display path of the dadesBowling.txt directory
                    OptionShowPath(futils);
                    break;
                }
                case 2: {
                    //Check if the file dataBowling.txt exists
                    optionCheckFiles(futils);
                    break;
                }
                case 3: {
                    //Display working directory
                    futils.showDirectory();
                    break;
                }
                case 4:{
                    //Load a round from the dataBowling file. Display the dates without duplicates
                    recoverGame(futils, bowlingData);
                    break;
                }
                case 5: //Delete records from the file up to a given date
                    deletePartialFile(futils);
                case 0: {
                    //Exit the program
                    System.out.println(Constants.RETURN_MESSAGE);
                    exitLoop = true;
                    break;
                }
                default: {
                    //Show an error message if the option is not valid
                    UtilsIO.showError(Constants.MESSAGE_NOT_VALID_OPTION);
                    break;
                }
            }
        }  
    }
    */

    //UF3
    /*  
    public void OptionShowPath(FileUtils futils){
        System.out.println(Constants.DIRECTORY_MESSAGE_IO);
        System.out.println(futils.getDirectoryDades());
    }
    */

    /* 
    public void optionCheckFiles(FileUtils futils){
        
        if(futils.fileExists(Constants.DATA_FILE) == true){
            System.err.println(Constants.MESSAGE_FILE_EXISTS);
                }else{
            System.err.println(Constants.MESSAGE_FILE_DOES_NOT_EXIST);
        }
    }
    */
    
    /* 
    public void recoverGame(FileUtils futils, BowlingData bowlingData){

        //Ask the user if they want to save the current data or overwrite it.
        if(futils.fileExists(Constants.DATA_FILE)){
                Scanner scanner = new Scanner(System.in);
                System.out.println(Constants.RECOVERY_GAME);
                String userInput = scanner.nextLine().trim().toLowerCase();

                switch (userInput) {
                   case "g":                                     
                       // Case to save the current data and load from historic
                       saveCurrentData(futils, bowlingData); // Call methode to save current data
                       //Load a round from the historical dataBowling file
                       loadDataFromFile(futils, bowlingData);
                       break;
                   case "s":
                       // Case to load directly without saving
                       loadDataFromFile(futils, bowlingData); // Call your load method here
                       break;
                   case "0":
                        //Exit the program
                        System.out.println(Constants.RETURN_MESSAGE);
                        break;  
                   default:
                       System.out.println(Constants.RETURN_MESSAGE);
                       break;
                }
        }    
         else System.out.println (Constants.NO_DATA_TO_RECOVERY);
    }
    
    */

    /* 
    private void saveCurrentData(FileUtils futils, BowlingData bowlingData) {
        //Save data to the file databowling.txt.
        futils.saveDataToFile(bowlingData.playersData, bowlingData.pointsMatrix);
}
*/

/* 
    private void loadDataFromFile(FileUtils futils, BowlingData bowlingData) {
        //Load a round from the historical dataBowling file. Display the dates without duplicates
        futils.listUniqueFirstField(futils.getDirectoryDades());

        long numero;
        Scanner scanner = new Scanner(System.in);
        System.out.print(Constants.CODE_TO_RECOVERY);
        while (!scanner.hasNextLong()) {  // Verify entry
            System.out.println(Constants.ERROR_DATA_IN);
            scanner.next();  //Clean up the invalid input
        }
        numero = scanner.nextLong();  
        System.out.println(Constants.DATA_SELECTED + numero);
        String number = Long.toString(numero);
        //Count the number of lines that are equal
        int numberLines = futils.countRowsWithCode(number);
        //Resize the array to fit all the records
        bowlingData.initializePlayers(numberLines);
        bowlingData.initializePoints(numberLines);
        //Call the file loading method with the data provided by the user.
        futils.loadDataFromFile(numero, bowlingData.playersData, bowlingData.pointsMatrix);
        System.out.println(Constants.DATA_LOADED_OK);
    }
    */

    /* 
    private void deletePartialFile(FileUtils futils){
        // List the unique dates from the first field
        String dataFile = futils.getDirectoryDades(); 
        if( futils.fileExists(Constants.DATA_FILE)){
            futils.listUniqueFirstField(dataFile);
            //Ask the user to enter a specific date from the list.
            Scanner scanner = new Scanner(System.in);
            System.out.println(Constants.MESSAGE_INSERT_DATA);
            String dateInput = scanner.nextLine();
            //Call the file where the records will be deleted.
            futils.deletePartialFile(futils, dateInput);
        }
        else System.out.println(Constants.MESSAGE_FILE_EMPTY);
    }
        */
    //Fi UF3

    private void showTotalPoints(String[][] playersData, int[][] pointsMatrix) {
       // calculate the total points for each player
        int[] totalPoints = UtilsBowling.calculateTotalPointsArray(pointsMatrix);
        // calculate the index array with the order of the players
        int[] indexArray = UtilsBowling.getOrderedIndexArrayWithTotalPoints(totalPoints);
        // show the ordered list
        UtilsIO.showOrderedPointsList(playersData, totalPoints, indexArray);
    }

    private void correctPlayerPoints(String[][] playersData, int[][] pointsMatrix) {
        // ask the user for the player to correct
        String playerName = UtilsIO.askForString(Constants.MESSAGE_INSERT_FULL_NAME, Constants.MESSAGE_ERROR_EMPTY_STRING);
        int playerIndex = UtilsBowling.lookForPlayer(playersData, playerName);
        // if the player is not found, we return
        if (playerIndex == -1) {
            UtilsIO.showError(Constants.MESSAGE_ERROR_PLAYER_NOT_FOUND);
            return;
        }
        // ask for the round to correct
        int round = UtilsIO.askForInteger(Constants.MESSAGE_INSERT_ROUND, Constants.MESSAGE_ERROR_NO_INTEGER);
        // it the round is not valid, we return
        if (round < 1 || round > Constants.THROWS_NUMBER) {
            UtilsIO.showError(Constants.MESSAGE_ERROR_NO_VALID_ROUND);
            return;
        }
        // ask for the points for the round
        int playerPoints = UtilsIO.askForInteger(Constants.MESSAGE_INSERT_POINTS + playersData[playerIndex][Constants.INDEX_NAME] + " " + playersData[playerIndex][Constants.INDEX_LAST_NAME], Constants.MESSAGE_ERROR_NO_INTEGER);
        // if the points are not valid, we return
        if (playerPoints < 0 || playerPoints > Constants.MAX_POINTS) {
            UtilsIO.showError(Constants.MESSAGE_ERROR_NO_VALID_POINTS);
            return;
        }
        // set the points in the matrix
        UtilsBowling.setRoundPoints(pointsMatrix, playerIndex, round, playerPoints);
        UtilsIO.showRounds(playersData, pointsMatrix);
    }

    private void askForRoundPoints(String[][] playersData, int[][] pointsMatrix) {
        // ask for the round to set the points
        int round = UtilsIO.askForInteger(Constants.MESSAGE_INSERT_ROUND, Constants.MESSAGE_ERROR_NO_INTEGER);
        // it the round is not valid, we return
        if (round < 1 || round > Constants.THROWS_NUMBER) {
            UtilsIO.showError(Constants.MESSAGE_ERROR_NO_VALID_ROUND);
            return;
        }
        // ask for the points for each player
        for (int i = 0; i < playersData.length; i++) {
            int playerPoints = UtilsIO.askForInteger(Constants.MESSAGE_INSERT_POINTS + playersData[i][Constants.INDEX_NAME] + " " + playersData[i][Constants.INDEX_LAST_NAME], Constants.MESSAGE_ERROR_NO_INTEGER);
            while (playerPoints < 0 || playerPoints > Constants.MAX_POINTS) {
                UtilsIO.showError(Constants.MESSAGE_ERROR_NO_VALID_POINTS);
                playerPoints = UtilsIO.askForInteger(Constants.MESSAGE_INSERT_POINTS + playersData[i][Constants.INDEX_NAME] + " " + playersData[i][Constants.INDEX_LAST_NAME], Constants.MESSAGE_ERROR_NO_INTEGER);
            }
            UtilsBowling.setRoundPoints(pointsMatrix, i, round, playerPoints);
        }
    }

   


}