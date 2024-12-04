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
    
    /* 
    public String getDirectoryDades(){

    }
    public void showDirectory(){
    }
    public boolean deleteFile(String Filename){

    } 
    public boolean fileExists(String Filename){

    }
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
    


        
        


        
    
