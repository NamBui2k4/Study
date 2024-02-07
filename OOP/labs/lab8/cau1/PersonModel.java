import java.util.ArrayList;
public class PersonModel <T> {
    
    private ArrayList<T> al = new ArrayList<T>();
    
    public void add(T obj) {
        al.add(obj);
    }
    public void display() {
        for (T obj : al) {
            System.out.println(obj);
        }
    }
}