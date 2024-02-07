import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class test{

    public static ArrayList<File> GetFile(String extention, File folder){
        ArrayList<File> result = new ArrayList<File>();

        if(folder.exists() && folder.isDirectory() ){
            for(File temp : folder.listFiles()){
                if(temp.isFile() && temp.getName().endsWith(extention)){
                    result.add(temp);
                }
        }
        }
        return result;
    }
    public static void appendToAFile(File file, String content){
        try{
        FileWriter writer = new FileWriter(file);
        if(file.exists())
            writer.write(content);
        writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("error writing file");
        }
    }

    public boolean CheckExists(String path){
        File folder = new File(path);

        if(folder.exists())
            return true;
        else 
            return false;
    }

    public String getLongestWordInFile(File file){
        String LongestWord = "";
        try{
            
            Scanner sc = new Scanner(file);
            if(file.exists()){
                while(sc.hasNext()){
                    String word = sc.next();
                    if(word.length() > LongestWord.length())
                        LongestWord = word;
                }
      }
            sc.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("error finding longest word");
        }
        return LongestWord;
    }

    public void CheckDirectoryOrFile(String path){
        File folder = new File(path);
        if(folder.isDirectory())
            System.out.println("is a directory");
        if(folder.isFile())
            System.out.println("is a file");
    }
   

    public static void main(String[] args){
       File folder = new File("C:\\Users\\ASUS\\OneDrive\\laptrinh\\java\\522h0002-522H0002_BuiPhuongNam\\lab9\\cau3");
       ArrayList<File> ListFile = GetFile(".txt", folder);
        for(File file : ListFile){
            System.out.println(file.getName());
        }
    }
}
