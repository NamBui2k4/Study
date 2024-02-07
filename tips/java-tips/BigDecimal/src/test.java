import java.math.BigDecimal;
public class test{
    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal("10.50");
        BigDecimal num2 = new BigDecimal("5.20");
        BigDecimal num3 = new BigDecimal("10.50");
        
        // Sử dụng compareTo() để so sánh giá trị
        System.out.println(num1.compareTo(num2)); // 1
        System.out.println(num1.compareTo(num3)); // 0
    
        // Sử dụng equals() để kiểm tra sự bằng nhau
        System.out.println(num1.equals(num2)); // false
        System.out.println(num1.equals(num3)); // true
    }
}