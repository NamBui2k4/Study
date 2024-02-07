import java.util.Scanner;

public class lab51 {
    public static int maxEven(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int num : a) {
            if (num % 2 == 0 && num > max) {
                max = num;
            }
        }
        return max;
    }
    
    public static int minOdd(int[] a) {
        int min = Integer.MAX_VALUE;
        for (int num : a) {
            if (num % 2 != 0 && num < min) {
                min = num;
            }
        }
        return min;
    }
    
    public static int sumMEMO(int[] a) {
        int maxEven = maxEven(a);
        int minOdd = minOdd(a);
        return maxEven + minOdd;
    }
    
    public static int sumEven(int[] a) {
        int sum = 0;
        for (int num : a) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }
    
    public static int prodOdd(int[] a) {
        int prod = 1;
        for (int num : a) {
            if (num % 2 != 0) {
                prod *= num;
            }
        }
        return prod;
    }
    
    public static int idxFirstEven(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                return i;
            }
        }
        return -1; // no even number found
    }
    
    public static int idxLastOdd(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] % 2 != 0) {
                return i;
            }
        }
        return -1; // no odd number found
    }
    
    public static int[] input(int n) {
        int[] a = new int[n];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            a[i] = scanner.nextInt();
        }
        return a;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] a = input(n);
        
        System.out.println("The maximum even number in the array is: " + maxEven(a));
        System.out.println("The minimum odd number in the array is: " + minOdd(a));
        System.out.println("The sum of the greatest even number and the smallest odd number in the array is: " + sumMEMO(a));
        System.out.println("The sum of even numbers in the array is: " + sumEven(a));
        System.out.println("The product of odd numbers in the array is: " + prodOdd(a));
        int idx = idxFirstEven(a);
        if (idx != -1) {
            System.out.println("The position of the first even number in the array is: " + idx);
        } else {
            System.out.println("No even number found in the array.");
        }
        idx = idxLastOdd(a);
        if (idx != -1) {
            System.out.println("The position of the last odd number in the array is: " + idx);}
    }}