import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileUtils {
    String dataDirectory; // absolut path
 
    
    public void inicialitzeWorkDirectory(){
        
        // Get the working directory of the program
        String workingDirectory = System.getProperty("user.dir");

        // Check if folder "dades" exists inside the working directory
        String folderPath = workingDirectory + File.separator + Constants.DATA_FOLDER_NAME; 

        // Declarion File object pointing to the data Folder
        File dataFolder = new File(folderPath);

        // check if the folder exists
        if (dataFolder.isDirectory()){
            dataDirectory = dataFolder.getAbsolutePath();
        } else {
            // folder is created
            dataFolder.mkdir();
            dataDirectory = dataFolder.getAbsolutePath();
        }

    } 
    
    
    public String getDirectoryDades(){
        return dataDirectory;
    }

    
    public void showDirectory(){
        System.out.println(dataDirectory);
        // it is shown the content of the working directory (first level) 
        File workDirectory = new File(dataDirectory);
        File[] arrayElements = workDirectory.listFiles();

        System.out.println(Constants.DIRECTORY_CONTENT_MESSAGE + " " + workDirectory.getAbsolutePath() + " és:");

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


        File fileToDelete = new File (Filename);
        
        // file is deleted if exists
        if (fileToDelete.isFile()) {
            //System.out.println("file " + Filename + " exists");
            return fileToDelete.delete();
        } else {
            //System.out.println("file " + Filename + " does not exist");
            return false;
        }

    } 


    public boolean fileExists(String Filename){
        
        File fileToCheck = new File (Filename);
        
        // file hast to exist and its length be greater than 0
        if (fileToCheck.isFile() && fileToCheck.length()>0) {
            //System.out.println("file " + Filename + " exists");
            return true;
        } else {
            //System.out.println("file " + Filename + " does not exist");
            return false;
        }
    }

    
    public void saveDataToFile(String[][] playersData, int[][] pointsMatrix) {


        // playerData -> name, surname, age
        // pointsMatrix -> pointsRound1, pointsRound2, ..., pointsRoundN

        // check data matrix are not null and not empty or different length
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

            // path where to add the data.
            String absPathToDataFile = dataDirectory + File.separator + Constants.DATA_FILE; 

            // File object pointing to the abs path
            File dataFile = new File(absPathToDataFile);

            // declaration of a string Builder where to append all the data that will be written to the file. 
            StringBuilder dataToWrite = new StringBuilder(); //StringBuilder)

            // if it contains already data, the new data will be appended 
            dataToWrite.append(getOldDataFile(dataFile));

            // the writer object is declared pointing to the data file (dataBowling.txt)
            PrintStream writer = new PrintStream(dataFile.getAbsolutePath());

            // current data time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);  
            LocalDateTime now = LocalDateTime.now();  
            String current_date = new String(dtf.format(now));
            // what to print -> dtf.format(now))
            
            // declaration of a data line to be written to the file. 
            StringBuilder dataLine = new StringBuilder(); 
            
            // iterate among the two matrixs
            for (int i = 0; i < playersData.length; i++) {

                // Add the data of the player i
                dataLine.append(current_date + getPlayerData(playersData[i]) + Constants.SPLIT_CHAR);
                // Add the points of the player i
                dataLine.append(getPlayerPoints(pointsMatrix[i]));
                // Add the full line to the stringBuilder object of the whole data
                dataToWrite.append(dataLine + System.getProperty("line.separator"));

                // clean the StringBuffer of line
                dataLine.setLength(0);

            }

            // apppend the whole data to the file 
            writer.append(dataToWrite);

            // the file is closed
            writer.close();
        
        }catch (Exception e){
            System.out.println(Constants.MESSAGE_ERROR_PROCESS + e);
        }
        

    }


    public StringBuilder getOldDataFile(File dataFile) {

        StringBuilder oldDataFile = new StringBuilder();
        
        if ( fileExists(dataFile.getAbsolutePath()) ) {

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
            File fileToRead = new File(filePath);
            Scanner reader = new Scanner(fileToRead); // if file does not exist, it will throw an exception.
           
            // while we have a next line to read, the file keeps being read
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

            // finally the folder is closed
            reader.close();

        } catch (Exception e){
            System.out.println(Constants.MESSAGE_ERROR_PROCESS + e);
        }
    }


    public int countRowsWithCode(String lineCode) {
        
        // file object is initialized pointing to the datafile
        File dataFile = new File(dataDirectory + File.separator + Constants.DATA_FILE);
        int numLines = 0;

        try {

            Scanner reader = new Scanner(dataFile); // if file does not exist, it will throw an exception.
           
            // while we have a next line to read, the file keeps being read
            while (reader.hasNextLine()){
                String currentLine = reader.nextLine();
                String[] lineArray = currentLine.split(Constants.SPLIT_CHAR);
                
                if ( (lineArray.length>0) && (lineArray[0].equals(lineCode)) ) {
                    numLines++;
                }
            }

            // finally the folder is closed
            reader.close();

        } catch (Exception e){
            System.out.println(Constants.MESSAGE_ERROR_PROCESS + e);
        }

        return numLines;
    }


    /*
    public void loadDataFromFile(long dataNumber, String[][] playersData, int[][] pointsMatrix) {

    }

    public void deletePartialFile(FileUtils futils, String dateInput) {

    }
    */

}//Fi FileUtils
    


        
        


        
    
