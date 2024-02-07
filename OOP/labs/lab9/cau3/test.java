import java.util.ArrayList;
import java.io.*;
class ClassWork<E>{
    private String path;
    private ArrayList<E> lst;
    public ClassWork(String path, ArrayList<E> lst){
        this.path = path;
        this.lst = lst;
    }

    public <E> boolean writeFile(String path, ArrayList<E> lst){
        
        boolean isSuccess = true;
        try{
            PrintWriter  fw = new PrintWriter(path);
            for(E temp : lst){
                fw.print(temp);
                fw.print(System.lineSeparator());
            }
            fw.close();       
        }catch(IOException e){
            e.printStackTrace();
            isSuccess = false;
        }

        if(isSuccess){
            return true;
        }
        else{
            return false;
        }
        
    }
}
public class test{
    public static void main(String[] args){
        
        ArrayList<Student> listStudents = new ArrayList<Student>();
        listStudents.add(new ITStudent("Nam", 7, 54));
        listStudents.add(new MathStudent("Nhan", 5,"er"));
        String path = "outpt.txt";
        ClassWork<Student> result = new ClassWork<Student>(path,listStudents);
        result.writeFile(path, listStudents);

    }
}