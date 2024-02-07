import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class test{
    public static void main(String[] args){
    
    File inputFile = new File("input.txt");

    try{
        if(inputFile.createNewFile())
            System.out.println("file name: " + inputFile.getName());
       
    } 
    catch(IOException e) {
        System.out.println("error: could'nt create new file");
        e.printStackTrace();
    }

    try{
        
        Scanner sc = new Scanner(inputFile);
        FileWriter fw = new FileWriter("output.txt");

        // sc.hasNextLine(): kiểm tra dòng tiếp theo có tồn tại trong file ko, nếu có trả về True
        while(sc.hasNextLine()){  // ( vòng lặp đầu tiên, kiểm tra dòng đầu tiên )
        
            String data = sc.nextLine().toUpperCase();
            //  chọn dòng tiếp theo(dòng đầu tiên) và in hoa chúng
            System.out.println(data);
        
            fw.write(data); // ghi vào ouput
            fw.write(System.lineSeparator()); // thêm ký tự xuống dòng

            // lặp tương tự với dòng tiếp theo
        }
        sc.close();
        fw.close();
       
    }catch(IOException e){
        System.out.println("error:  ");
        e.printStackTrace();
    }
    
    
}
}
