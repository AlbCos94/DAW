import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
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

    public void listUniqueFirstField(String filePath){

    }

    public int countRowsWithCode(String lineCode) {

    }

    public void loadDataFromFile(long dataNumber, String[][] playersData, int[][] pointsMatrix) {

    }

    public void deletePartialFile(FileUtils futils, String dateInput) {

    }
    */

}//Fi FileUtils
    


        
        


        
    
