import java.util.ArrayList;
public class test {
    public static void main(String[] args){
        Point A = new Point(0.5,0.3);
        Point B = new Point(1,9);
        Point C = new Point(4,8);
        ArrayList<Point> point = new ArrayList<Point>();
        point.add(A);
        point.add(B);
        point.add(C);
        for(int i = 0; i < point.size(); i++){
            if (point.get(i).Distance() < 1)
                System.out.println(point.get(i));
        }

        
    }
}
