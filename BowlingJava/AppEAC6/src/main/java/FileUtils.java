import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
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

    /*
    public void saveDataToFile(String[][] playersData, int[][] pointsMatrix) {

    }
    */

    public void listUniqueFirstField(String filePath){
        Set<String> uniqueIdentifiers = new HashSet<>();

        try {
            File fileToRead = new File(filePath);
            Scanner reader = new Scanner(fileToRead); // if file does not exist, it will throw an exception.
           
            // while we have a next line to read, the file keeps being read
            while (reader.hasNextLine()){
                String currentLine = reader.nextLine();
                String[] lineArray = currentLine.split(Constants.SPLITTING_CHARACTER);
                
                if (lineArray.length>0) {
                    uniqueIdentifiers.add(lineArray[0]);
                }
            }

            System.out.println(Constants.UNIQUE_IDENTIFIERS_MESSAGE);
            for (String element : uniqueIdentifiers) {
                System.out.println(element);
            }

            // finally the folder is closed
            reader.close();

        } catch (Exception e){
            System.out.println("Error: " + e);
        }
    }


    /*
    public int countRowsWithCode(String lineCode) {

    }

    public void loadDataFromFile(long dataNumber, String[][] playersData, int[][] pointsMatrix) {

    }

    public void deletePartialFile(FileUtils futils, String dateInput) {

    }
    */

}//Fi FileUtils
    


        
        


        
    
