import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
public class test {
    public static void main(String[] args) {
      List<Integer> list = Arrays.asList(1,2,2,2,2,3,4,5);
      Stream<Integer> stream = list.stream().distinct();
      // distinct dùng để xóa các 
      System.out.println(list);
      System.err.println(stream.toString());
  }
}
