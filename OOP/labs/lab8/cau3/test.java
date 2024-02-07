import java.util.ArrayList;

class Processing{
    public ArrayList<Student> findStudent(ArrayList<Student> lstStu){
        
        ArrayList<Student> result = new ArrayList<Student>();
        for(Student mem : lstStu){
            if(mem.getRank() == "A" || mem.getRank() == "Passed")
                result.add(mem);
        }
        return result;
    }
}

    public class test {
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new ITStudent("Nam", 7, 54));
        students.add(new MathStudent("Nhan", 5,"er"));
        Processing process = new Processing();
        System.out.println(process.findStudent(students).toString());



    }   
}
