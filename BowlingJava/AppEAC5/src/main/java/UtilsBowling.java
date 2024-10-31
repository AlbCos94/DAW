import java.util.Arrays;

public class UtilsBowling {

    // US DE FUNCIONS ESTATIQUES -> clases es poden cridar sense necesitat de fer uns instanciacio

    // initializePoints
    //public static int[][] initializePoints(int playerNumber);
    public static int[][] initializePoints(int playersNumber) {

        if (playersNumber<=0) {
            System.out.println(Constants.ERROR_NUM_PLAYERS);
            return null; 
        }

        int [][] pointsMatrix = new int[playersNumber][Constants.ROUNDS_NUMBER];

        // pointsMatrix it is filled with -1's
        for (int i= 0; i<playersNumber; i++){ 
            for (int j= 0; j<Constants.ROUNDS_NUMBER; j++){
                pointsMatrix[i][j] = Constants.NULL_POINTS;
            }              
        }

        return pointsMatrix;
    }


    // initializedPlayers
    //public static String[][] initializedPlayers(int playerNumber);
    public static String[][] initializePlayers(int playersNumber) {

        if (playersNumber<=0) {
            System.out.println(Constants.ERROR_NUM_PLAYERS);
            return null; 
        }

        String [][] playersData = new String[playersNumber][Constants.PLAYER_DATA_ELEMENTS]; 
        // playersData it is filled with empty strings
        for (int i= 0; i<playersNumber; i++){ 
            for (int j= 0; j<Constants.PLAYER_DATA_ELEMENTS; j++){
                playersData[i][j] = "";
            }              
        }
        return playersData;
    }


    
    // insertPlayerNames
    //public static void insertPlayerNames(String[][] playersData, int rowNumber, String name, String lastName, int age);
    public static void insertPlayerNames(String[][] playersData, int rowNumber, String name, String lastName, int age) {
        
        // if the array is null, we return
        if (playersData == null) {
            return;
        }
        // if the row number is not valid, we return
        if ( (rowNumber < 0) || (rowNumber >= playersData.length) ) {
            return;
        }
        // if the name is null or empty, we return
        if ( (name == null) || (name.isEmpty()) ){
            return;
        }
        // if the last name is null or empty, we return
        if ( (lastName == null) || (lastName.isEmpty()) ){
            return;
        }
        // if the age is less than 0, we return
        if (age < 0){
            return;
        }        

        // insert the data in the array
        playersData[rowNumber][Constants.POS_NAME] = name;
        playersData[rowNumber][Constants.POS_LASTNAME] = lastName;
        playersData[rowNumber][Constants.POS_AGE] = String.valueOf(age);
    }


    // setRoundPoints 
    //public static void setRoundPoints(int[][] pointsMatrix, int rowIndex, int round, int points)
    public void setRoundPoints(int[][] pointsMatrix, int rowIndex, int round, int points) {
        // if the array is null, we return
        if (pointsMatrix == null) {
            return;
        }
        
        // playersData
        // if the row index is not valid, we return
        if ( (rowIndex < 0) || (rowIndex >= pointsMatrix.length) ) {
            return;
        }
        // if the round is not valid, we return
        if ( (round <= 0) || (round >= Constants.ROUNDS_NUMBER)){
            return;
        }   
        // if the points are not valid, we return
        if ( (points < 0) || (points > Constants.MAX_POINTS)){
            return;
        }   
        // set the points in the array
        pointsMatrix[rowIndex][round-1] = points;
    }
}