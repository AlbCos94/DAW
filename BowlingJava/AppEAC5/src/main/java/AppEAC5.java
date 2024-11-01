

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author IOC & Albert Costa Ruiz as student
 */
public class AppEAC5 {

     public static void main(String[] args) {
        AppEAC5 bowlingApp = new AppEAC5();
        bowlingApp.start();
    }

    public void start() {

        
        //UtilsIO.printHeaderTableSumPoints();
/* 
        int [] Arr1 = {30, 30, 54, 12, 43, 55};
        int[] ArrRes = UtilsBowling.getOrderedIndexArrayWithTotalPoints(Arr1);
        System.out.println("Copy Array 1: " + Arrays.toString(ArrRes)); */


/*         UtilsIO.showError("Hola Caracol"); // since it is static function it can be used like this. (without having to create first an object)
        UtilsIO.showMenu(Constants.MENU_TEXT); */

        BowlingData bowlingData = new BowlingData(); // inicializaction of a new object bowlingData 
        askingForPlayersAndDataInitialization(bowlingData);
        if (bowlingData.playersData == null){
            return; // end of the program
        }
        optionManager(bowlingData); 

        // testing area
        
/*         int [][] matrix1 = {{2, 3, 4, 10, 1, 7, -1, -1, -1, -1}, {10, 7, 3, 5, 2, 1, -1, -1, -1, -1}, {5, 5, 5, 4, 10, 5, -1, -1, -1, -1}};
        int [] result1 = UtilsBowling.calculateTotalPointsArray(matrix1);

        int [][] matrix2 = {{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
        int [] result2 = UtilsBowling.calculateTotalPointsArray(matrix2); */



    }




    // Auxiliar methods:

    // Method to ask for number of players and initialize the data structure.  
    public void askingForPlayersAndDataInitialization(BowlingData bowlingData) {

        String namePlayer = "";
        String surnamePlayer = "";
        int agePlayer = 0;
        int numPlayers = 0;

        numPlayers = UtilsIO.askForInteger(Constants.ASK_FOR_NUM_PLAYERS, Constants.ERROR_NUM_PLAYERS);
        
        if (numPlayers <= 0) {
            UtilsIO.showError(Constants.ERROR_NUM_PLAYERS);
            return; // exit program
        }

        // Matrixs are initialized
        bowlingData.initializePlayers(numPlayers);
        bowlingData.initializePoints(numPlayers);      

        for (int i= 0; i<numPlayers; i++){
            String playerNumber = String.valueOf(i+1)+"/"+String.valueOf(numPlayers);
            String questionName  = playerNumber+" - "+ Constants.ASK_FOR_PLAYERNAME;
            String questionSurname  = playerNumber+" - "+ Constants.ASK_FOR_PLAYERSURNAME;
            String questionAge  = playerNumber+" - "+ Constants.ASK_FOR_PLAYERAGE;
            namePlayer = UtilsIO.askForString(questionName, Constants.ERROR_PLAYERNAME);
            surnamePlayer = UtilsIO.askForString(questionSurname, Constants.ERROR_PLAYERSURNAME);
            agePlayer = UtilsIO.askForAge(questionAge, Constants.ERROR_PLAYERAGE);

            UtilsBowling.insertPlayerNames(bowlingData.playersData, i, namePlayer, surnamePlayer, agePlayer);
        }
    }

    // Method to ask for number of players and initialize the data structure.  
    public void askingForRoundPoints(BowlingData bowlingData) {

        int roundNumber = 0;
        int pointsToInsert = 0;
        boolean correctPoints = false;
        boolean correctRound = false;
        String playerFullName = "";

        do{
            roundNumber = UtilsIO.askForInteger(Constants.ROUND_TO_POINT, Constants.ERROR_ENTER);

            if ( (roundNumber<1) || (roundNumber > Constants.ROUNDS_NUMBER) ){
                UtilsIO.showError(Constants.ROUND_TO_POINT_ERROR);
                correctRound = false;
            } else {
                correctRound = true;
            }
        } while (!correctRound);
  
        // Loop among all the players of the round
        for (int i=0; i<bowlingData.playersData.length; i++){
            playerFullName = bowlingData.playersData[i][0] + " " + bowlingData.playersData[i][1];

            do{
                pointsToInsert = UtilsIO.askForInteger(Constants.QUESTION_ENTER_POINTS + playerFullName, Constants.ERROR_ENTER); // it gives us an int but it is not sure if between 1 and 10

                if ( (pointsToInsert >= 0) && (pointsToInsert <= Constants.MAX_POINTS) ) {
                    correctPoints = true;
                } else {
                    UtilsIO.showError(Constants.ERROR_ENTER_RANGE + Constants.MAX_POINTS);
                    correctPoints = false;
                }

            } while (!correctPoints);

            UtilsBowling.setRoundPoints(bowlingData.pointsMatrix, i, roundNumber, pointsToInsert);
        }
    }
    
    // Method that manages the different options of the application
    public void optionManager(BowlingData bowlingData) {

        Scanner reader = new Scanner(System.in); 
        boolean corectData = false;
        boolean finish = false;
        int inputInt = 0;

        do{
            UtilsIO.showMenu(Constants.MENU_TEXT);

            corectData = reader.hasNextInt();

            if(corectData){
                
                inputInt = reader.nextInt();

                if (inputInt == Constants.OPTION_POINT_ROUND){
                    askingForRoundPoints(bowlingData);
                    UtilsIO.showRounds(bowlingData.playersData,bowlingData.pointsMatrix);

                } else if (inputInt == Constants.OPTION_SHOW_RANKING){  
                    showGeneralRanking(bowlingData);                                
                
                } else if (inputInt == Constants.OPTION_CHANGE_POINTS){   
                    changePlayersPoints(bowlingData);                
                
                } else if (inputInt == Constants.OPTION_QUIT){
                    finish = true;
                
                } else{
                    UtilsIO.showError(Constants.ERROR_OPTION);
                }

            } else{
                
                UtilsIO.showError(Constants.ERROR_OPTION);
                reader.next();
            }
        } while( !finish );
    }


    public void showGeneralRanking(BowlingData bowlingData){
        // Compute of the total points of each user
        int [] totalPointsArray = UtilsBowling.calculateTotalPointsArray(bowlingData.pointsMatrix);
        
        // Get the array of indexes corresponding to the ordered array of total points
        int [] arrayOfIndexes = UtilsBowling.getOrderedIndexArrayWithTotalPoints(totalPointsArray);

        // Display the classification with the total points of each player
        UtilsIO.showOrderedPointsList(bowlingData.playersData, totalPointsArray, arrayOfIndexes);
    }
    
    public void changePlayersPoints(BowlingData bowlingData){
        
        // Ask for the name of the player
        String playerFullName = UtilsIO.askForString(Constants.ASK_FOR_COMPLETE_NAME, Constants.STRING_ERROR);
        
        // Get the index of the player
        int indexPlayer = UtilsBowling.lookForPlayer(bowlingData.playersData, playerFullName);
        
        if (indexPlayer == Constants.ERROR_INT_RESULT) {
            UtilsIO.showError(Constants.PLAYER_NOT_FOUND);
            return;
        }

        // We ask for the round to point, the new quantity of points and the matrix of points is changed
        askingForRoundPointsForOnePlayer(bowlingData.pointsMatrix, playerFullName, indexPlayer);

    } 



    // Method to ask for number of players and initialize the data structure.  
    public void askingForRoundPointsForOnePlayer(int[][] pointsMatrix, String playerFullName, int indexPlayer) {

        int roundNumber = 0;
        int pointsToInsert = 0;
        boolean correctPoints = false;
        boolean correctRound = false;

        // Asking the round to point
        do{
            roundNumber = UtilsIO.askForInteger(Constants.ROUND_TO_POINT, Constants.ERROR_ENTER);

            if ( (roundNumber<1) || (roundNumber > Constants.ROUNDS_NUMBER) ){
                UtilsIO.showError(Constants.ROUND_TO_POINT_ERROR);
                correctRound = false;
            } else {
                correctRound = true;
            }
        } while (!correctRound);
    

        do{
            pointsToInsert = UtilsIO.askForInteger(Constants.QUESTION_ENTER_POINTS + " " + playerFullName, Constants.ERROR_ENTER); // it gives us an int but it is not sure if between 1 and 10

            if ( (pointsToInsert >= 0) && (pointsToInsert <= Constants.MAX_POINTS) ) {
                correctPoints = true;
            } else {
                UtilsIO.showError(Constants.ERROR_ENTER_RANGE + Constants.MAX_POINTS);
                correctPoints = false;
            }

        } while (!correctPoints);

        UtilsBowling.setRoundPoints(pointsMatrix, indexPlayer, roundNumber, pointsToInsert);

    }

	
}