import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileUtils {
    String dataDirectory; // absolut path
     
    public void inicialitzeWorkDirectory(){
        
        // Get the working directory of the program
        String workingDirectory = System.getProperty("user.dir");

        // Build path to "dades" folder
        String folderPath = workingDirectory + File.separator + Constants.DATA_FOLDER_NAME; 

        // Declarion of File object pointing to the "dades" folder
        File dataFolder = new File(folderPath);

        // check if the folder exists
        if (dataFolder.isDirectory()){
            dataDirectory = dataFolder.getAbsolutePath();
        } else {
            // if folder does not exist, it is created
            dataFolder.mkdir();
            dataDirectory = dataFolder.getAbsolutePath();
        }
    } 
    
    
    public String getDirectoryDades(){
        return dataDirectory;
    }

    
    public void showDirectory(){
        System.out.println(dataDirectory);
        // The content of the working directory is displayed (first level) 
        File workDirectory = new File(dataDirectory);
        File[] arrayElements = workDirectory.listFiles();

        System.out.println(Constants.DIRECTORY_CONTENT_MESSAGE + workDirectory.getAbsolutePath() + Constants.DIRECTORY_CONTENT_END_MESSAGE);

        for (int i = 0; i < arrayElements.length; i++) {
            File f = arrayElements[i];
            if (f.isDirectory()) {
                System.out.print("[DIR] ");
            } else {
                System.out.print("[FIT] ");
            }
            System.out.println(f.getName());
        }
    }


    public boolean deleteFile(String Filename){

        File fileToDelete = new File (dataDirectory + File.separator + Filename);
        
        // File is deleted, if it exists
        if (fileToDelete.isFile()) {
            return fileToDelete.delete();
        } else {
            return false;
        }
    } 


    public boolean fileExists(String Filename){
        
        File fileToCheck = new File (dataDirectory + File.separator + Filename);
        
        // File is check if exists and its length is greater than 0
        if (fileToCheck.isFile() && fileToCheck.length()>0) {
            return true;
        } else {
            return false;
        }
    }

    
    public void saveDataToFile(String[][] playersData, int[][] pointsMatrix) {

        // Check matrix data is not null, not empty or have different length
        if ( (playersData == null) || (pointsMatrix == null)){

            System.out.println(Constants.MESSAGE_ERROR_PROCESS + Constants.NULL_MATRIX_DATA);
            return;
        }

        if ( (playersData.length == 0) || (pointsMatrix.length == 0)) {

            System.out.println(Constants.MESSAGE_ERROR_PROCESS + Constants.EMPTY_MATRIX_DATA);
            return;
        }

        if ( playersData.length != pointsMatrix.length ) {

            System.out.println(Constants.MESSAGE_ERROR_PROCESS + Constants.MATRIX_NOT_EQUAL);
            return;
        }

        try{

            // Path where to write the data
            String absPathToDataFile = dataDirectory + File.separator + Constants.DATA_FILE; 

            // File object pointing to the abs path
            File dataFile = new File(absPathToDataFile);

            // Declaration of a string Builder where to append all the data that will be written to the file. 
            StringBuilder dataToWrite = new StringBuilder(); 

            // If file contains already data, the new data will be appended 
            dataToWrite.append(getOldDataFileContent(dataFile));

            // The writer object is declared pointing to the data file (dataBowling.txt)
            PrintStream writer = new PrintStream(dataFile.getAbsolutePath());

            // Current data time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);  
            LocalDateTime now = LocalDateTime.now();  
            String current_date = new String(dtf.format(now));
            
            // Declaration of a data line to be written to the file. 
            StringBuilder dataLine = new StringBuilder(); 
            
            // Iterate among playersData matrix
            for (int i = 0; i < playersData.length; i++) {

                // Add the data of the player i
                dataLine.append(current_date + getPlayerData(playersData[i]) + Constants.SPLIT_CHAR);
                // Add the points of the player i
                dataLine.append(getPlayerPoints(pointsMatrix[i]));
                // Add the full line to the stringBuilder object of the whole data that will be written
                dataToWrite.append(dataLine + System.getProperty("line.separator"));

                // Clean the StringBuffer of line
                dataLine.setLength(0);
            }

            // Apppend the whole data to the file 
            writer.append(dataToWrite);

            // The file is closed
            writer.close();
        
        }catch (Exception e){
            System.out.println(Constants.MESSAGE_ERROR_PROCESS + e);
        }
    }


    public StringBuilder getOldDataFileContent(File dataFile) {

        StringBuilder oldDataFile = new StringBuilder();
        
        if ( fileExists(Constants.DATA_FILE) ) {

            try {
                Scanner reader = new Scanner(dataFile);
    
                while (reader.hasNextLine()){
                    String linia = new String(reader.nextLine());
                    oldDataFile.append(linia);
                    oldDataFile.append(System.getProperty("line.separator"));
                }   
                reader.close();

            } catch (Exception e) {
                System.out.println(Constants.MESSAGE_ERROR_PROCESS + e);
            }
        }

        return oldDataFile;
    }

    public String getPlayerData(String[] playerData) {
        
        String stringPlayerData = new String(Constants.SPLIT_CHAR + playerData[0] + Constants.SPLIT_CHAR + playerData[1] + Constants.SPLIT_CHAR + playerData[2]);
        return stringPlayerData;
    }

    public StringBuilder getPlayerPoints(int[] playerPoints) {
        
        StringBuilder pointsPlayer = new StringBuilder();
        for (int i = 0; i < playerPoints.length; i++) {

            if ( i == (playerPoints.length-1) ) {
                pointsPlayer.append(playerPoints[i]);
            } else {
                pointsPlayer.append(playerPoints[i]+Constants.SPLIT_CHAR);
            }
        }

        return pointsPlayer;
    }


    public void listUniqueFirstField(String filePath){
        
        Set<String> uniqueIdentifiers = new HashSet<>();

        try {
            File fileToRead = new File(filePath + File.separator + Constants.DATA_FILE);
            Scanner reader = new Scanner(fileToRead); // if file does not exist, it will throw an exception.
           
            // While we have a next line to read, the file keeps being read
            while (reader.hasNextLine()){
                String currentLine = reader.nextLine();
                String[] lineArray = currentLine.split(Constants.SPLIT_CHAR);
                
                if (lineArray.length>0) {
                    uniqueIdentifiers.add(lineArray[0]);
                }
            }

            System.out.println(Constants.UNIQUE_ID);
            for (String element : uniqueIdentifiers) {
                System.out.println(element);
            }

            reader.close();

        } catch (Exception e){
            System.out.println(Constants.MESSAGE_ERROR_PROCESS + e);
        }
    }


    public int countRowsWithCode(String lineCode) {
        
        // File object is initialized pointing to the datafile
        File dataFile = new File(dataDirectory + File.separator + Constants.DATA_FILE);
        int numLines = 0;

        try {

            Scanner reader = new Scanner(dataFile); 
           
            // While we have a next line to read, the file keeps being read
            while (reader.hasNextLine()){
                String currentLine = reader.nextLine();
                String[] lineArray = currentLine.split(Constants.SPLIT_CHAR);
                
                if ( (lineArray.length>0) && (lineArray[0].equals(lineCode)) ) {
                    numLines++;
                }
            }

            reader.close();

        } catch (Exception e){
            System.out.println(Constants.MESSAGE_ERROR_PROCESS + e);
        }
        return numLines;
    }


    // Method to load the data of the bowling game for a specific datestamp
    public void loadDataFromFile(long dataNumber, String[][] playersData, int[][] pointsMatrix) {

        // Data number is parsed to a string
        String stringDataNumber = String.valueOf(dataNumber);

        // Check if String is of the correct format
        if (isStringInFormat(stringDataNumber, Constants.DATE_FORMAT) == false){
            System.out.println(Constants.MESSAGE_ERROR_PROCESS + Constants.INCORRECT_DATE_FORMAT);
            return;
        }
        
        // Count the number of players that we have for the given data Number
        int numPlayers = countRowsWithCode(stringDataNumber);
        if ( numPlayers <= 0) {
            System.out.println(Constants.MESSAGE_ERROR_PROCESS + Constants.NO_DATA_TO_RECOVERY);
            return;
        }

        // Recover the data from the file into the data matrix
        String absPathToLoadData = dataDirectory + File.separator + Constants.DATA_FILE; 
        File dataFile = new File(absPathToLoadData);
       
        try {
            Scanner reader = new Scanner(dataFile); 
            int playerIndex = 0;
            int filePointsIndex = Constants.PLAYERS_MATRIX_COLUMNS+1; // initialize the index from which the player points appear. 

            while (reader.hasNextLine()){
                String currentLine = reader.nextLine();
                String[] lineArray = currentLine.split(Constants.SPLIT_CHAR);
                
                if ( (lineArray.length >= Constants.MIN_NUM_DATAELEMENTS) && (lineArray[0].equals(stringDataNumber)) ) {
                    
                    if (playersData[playerIndex].length >= Constants.PLAYERS_MATRIX_COLUMNS){
                        //name
                        playersData[playerIndex][0]=lineArray[1];
                        //surname
                        playersData[playerIndex][1]=lineArray[2];
                        //age
                        playersData[playerIndex][2]=lineArray[3];
                    }

                    if (pointsMatrix[playerIndex].length >= Constants.THROWS_NUMBER ){
                        
                        int pointsIndex = 0;
                        for (int i = filePointsIndex; i < lineArray.length; i++) {
                            pointsMatrix[playerIndex][pointsIndex] = Integer.parseInt(lineArray[i]); // parse string to int
                            pointsIndex++;
                        }
                    } 
                    playerIndex++;
                }
            }
            reader.close();
        } catch (Exception e){
            System.out.println(Constants.MESSAGE_ERROR_PROCESS + e);
        }
    }
    
    // Check that a string is of a given a date format
    public Boolean isStringInFormat(String stringToCheck, String dataFormat) {
        
        // Checking if they have the same lenght
        if (stringToCheck.length() != dataFormat.length()) {
            return false;
        }

        // Checking if they correspond to the given format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dataFormat);

        try {
            // Try to parse the string into a LocalDateTime
            LocalDateTime.parse(stringToCheck, formatter);
            return true; // Parsing successful
        } catch (DateTimeParseException e) {
            return false; // Parsing failed
        }
    }
    
  
    public void deletePartialFile(FileUtils futils, String dateInput) {
        String dataDirectory = futils.dataDirectory;
        
        // Path pointing to the data file
        String absPathToLoadData = dataDirectory + File.separator + Constants.DATA_FILE; 
        File dataFile = new File(absPathToLoadData);

        try {
            // Get remaining data file content
            StringBuilder remDataFileContent = getRemainingDataFileContent(dataFile, dateInput); 

            // The writer object is declared pointing to the data file (dataBowling.txt)
            PrintStream writer = new PrintStream(dataFile.getAbsolutePath());

            // Apppend the whole data to the file 
            writer.append(remDataFileContent);
            writer.close();

        } catch (Exception e) {
            System.out.println(Constants.MESSAGE_ERROR_PROCESS + e);
        }
    }


    public StringBuilder getRemainingDataFileContent(File dataFile, String dateInput) {

        DateTimeFormatter f = DateTimeFormatter.ofPattern( Constants.DATE_FORMAT );
        LocalDateTime dateToCompare = LocalDateTime.parse(dateInput,f);
        StringBuilder remDataFile = new StringBuilder();
        
        if ( fileExists(Constants.DATA_FILE) ) {

            try {
                Scanner reader = new Scanner(dataFile);
    
                while (reader.hasNextLine()){
                    String currentLine = new String(reader.nextLine());

                    String[] lineArray = currentLine.split(Constants.SPLIT_CHAR);

                    // Convert to LocalDateTime object
                    LocalDateTime dateLine = LocalDateTime.parse(lineArray[0],f);

                    // Check if the current date is greater than the splitting date
                    if ( dateToCompare.isBefore(dateLine) || dateToCompare.isEqual(dateLine) ){
                        remDataFile.append(currentLine);
                        remDataFile.append(System.getProperty("line.separator"));
                    }
                }
                reader.close();

            } catch (Exception e) {
                System.out.println(Constants.MESSAGE_ERROR_PROCESS + e);
            }
        }
        return remDataFile;
    }

}//Fi FileUtils
    


        
        


        
    
