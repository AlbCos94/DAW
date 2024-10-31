public class BowlingData {

    String[][] playersData = null; // matrix that will contain data of the players // defer / lazy initialization - its creation is deferred until it is first used.
    int[][] pointsMatrix = null; // matrix that will contain points of the players

    // initializePoints
    //public static int[][] initializePoints(int playerNumber);
    public int[][] initializePoints(int playersNumber) {

        if (playersNumber<=0) {
            System.out.println(Constants.ERROR_NUM_PLAYERS);
            return null; 
        }

        //int [][] pointsMatrix = new int[playersNumber][Constants.ROUNDS_NUMBER];
        pointsMatrix = new int[playersNumber][Constants.ROUNDS_NUMBER];

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
    public String[][] initializePlayers(int playersNumber) {

        if (playersNumber<=0) {
            System.out.println(Constants.ERROR_NUM_PLAYERS);
            return null; 
        }

        //String [][] playersData = new String[playersNumber][Constants.PLAYER_DATA_ELEMENTS]; 
        playersData = new String[playersNumber][Constants.PLAYER_DATA_ELEMENTS]; 
        
        // playersData it is filled with empty strings
        for (int i= 0; i<playersNumber; i++){ 
            for (int j= 0; j<Constants.PLAYER_DATA_ELEMENTS; j++){
                playersData[i][j] = Constants.EMPTY_DATA_PLAYER;
            }              
        }
        return playersData;
    }


}