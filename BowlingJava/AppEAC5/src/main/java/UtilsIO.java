import java.util.Scanner;

public class UtilsIO {
	// tots el metodes que intervenen en funcions d'entrada i sortida (interaccio entre pantalla i teclat)

	// US DE FUNCIONS ESTATIQUES

	//public static void showMenu(String menuText);
    public static void showMenu(String menuText) {
        
        if ( (menuText == null) || (menuText.isEmpty()) ){
            return;
        }
        String stringResult = Constants.SPLIT_LINE.repeat(Constants.NUMBER_DOTS_MENU_LINE)+"\n"+Constants.MENU_TITLE+"\n"+Constants.SPLIT_LINE.repeat(Constants.NUMBER_DOTS_MENU_LINE)+"\n"+menuText;
        System.out.println(stringResult); // printed in a new line

        System.out.println(Constants.QUESTION_OPTIONS); 
    }

	//public static void showError(String textError);
	public static void showError(String textError) {

        if ( (textError == null) || (textError.isEmpty()) ){
            return;
        }
		
        String stringResult = Constants.SPLIT_LINE.repeat(Constants.NUMBER_DOTS_MENU_LINE)+"\n"+Constants.ERROR_TITLE+"\n"+Constants.SPLIT_LINE.repeat(Constants.NUMBER_DOTS_MENU_LINE)+"\n"+textError;
        System.out.println(stringResult); 
    }

 	//public static String askForString(String message, String errorMessage);
	public static String askForString(String message, String errorMessage){
        
		Scanner reader = new Scanner(System.in); 
        boolean end = false;
        String inputString = "";

        do{
            System.out.println(message); // User message with a request
            inputString = reader.nextLine(); // Get the next string line introduced by user (everything he wrote before enter -> (\n) )

            if (!inputString.isEmpty()){
                end = true;
            } else{
                showError(errorMessage);
            }
        } while ( end == false );

        return inputString;
    }


	//public static int askForInteger(String message, String errorMessage);
    public static int askForInteger(String message, String errorMessage) {
        
        Scanner reader = new Scanner(System.in); 
        boolean corectData = false;
        int inputInt = 0;

        do{
            System.out.println(message); 

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



	public static int askForAge(String message, String errorMessage) {
        
        Scanner reader = new Scanner(System.in); 
        boolean corectData = false;
        int inputInt = 0;

        do{
            System.out.println(message); 

            //corectData = reader.hasNextInt();

            if(reader.hasNextInt()){
                //corectData = true;
                inputInt = reader.nextInt();

                if (inputInt < Constants.MIN_AGE || inputInt > Constants.MAX_AGE){
                    showError(Constants.ERROR_PLAYERAGE_RANGE);
                    corectData = false;
                } else{
                    corectData = true;
                }

            } else{
                
                showError(errorMessage);
                reader.next();
            }
        } while( !corectData );

        return inputInt;
    }


	//public static float askForFloat(String message, String errorMessage);
    public static float askForFloat(String message, String errorMessage) {
        
        Scanner reader = new Scanner(System.in); 
        boolean corectData = false;
        float inputFloat = 0;

        do{
            System.out.println(message); 

            corectData = reader.hasNextFloat();

            if(reader.hasNextFloat()){
                corectData = true;
                inputFloat = reader.nextFloat();
            } else{
                
                showError(errorMessage);
                reader.next();
            }
        } while( !corectData );

        return inputFloat;
    }



    public static void printHeaderTablePoints(int roundsNumber) {

        if ( roundsNumber == 0)  {
            return;
        }

        // print "full name" plus "age"
        System.out.printf(Constants.SPLIT_LINE.repeat(Constants.NUMBER_DOTS_TABLE_LINE) +"\n");
        System.out.printf("%-15s %10s", Constants.MENU_FULLNAME, Constants.MENU_AGE);
        
        for (int i= 0; i<roundsNumber; i++){
            System.out.printf("%5s", "R"+String.valueOf(i+1));
        }
        System.out.printf("\n");
        System.out.printf(Constants.SPLIT_LINE.repeat(Constants.NUMBER_DOTS_TABLE_LINE));
     }



    public static void print1PlayersPoints(String[] onePlayersData, int[] pointsRow) {

        if ( (onePlayersData == null) || (pointsRow == null) ) {
            return;
        }

        if ( onePlayersData.length == 0 ) {
            return;
        }

        if ( pointsRow.length == 0 ) {
            return;
        }

        // Print "full name" plus "age"
        String fullName = onePlayersData[Constants.POS_NAME] + " " + onePlayersData[Constants.POS_LASTNAME];
        System.out.printf("%-15s %10s", fullName, onePlayersData[Constants.POS_AGE]);

        for (int i= 0; i<pointsRow.length; i++){ 
            if (pointsRow[i] == -1) {
                System.out.printf("%5s", "-");
            } else{
                System.out.printf("%5s", String.valueOf(pointsRow[i]));
            }
        }  
    }








	//public static void showRounds(String[][] playersData, int[][] pointsMatrix);

    public static void showRounds(String[][] playersData, int[][] pointsMatrix) {

        if ( (playersData == null) || (pointsMatrix == null) ) {
            return;
        }

        // Number of rows between matrixs does not match 
        if ( playersData.length != pointsMatrix.length ) {
            return;
        }

        if ( playersData.length == 0 ) {
            return;
        }

        //Print header of the table containing all the rounds
        printHeaderTablePoints(Constants.ROUNDS_NUMBER);
        System.out.print("\n");

        for (int i= 0; i<playersData.length; i++){ 
            print1PlayersPoints(playersData[i], pointsMatrix[i]);
            System.out.print("\n"); // line break is added at the end
        }
    }


/*	public static void pointsOrDash(int points); */

}