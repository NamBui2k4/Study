import java.util.Arrays;
public class Ex02{
    public static void main(String[] args){
        Student [] a = new Student[3];
        a[0] = new Student("Nam",10,2,1);
        a[1] = new Student("Thanh",0,5,1); 
        a[2] = new Student("Linh",8,5,2);
        a[3] = new Student("Vy",10,0,7);
        Arrays.sort(a, new StudentComparator());
        for(Student i : a){
            System.out.println(i);
        }
    }
}