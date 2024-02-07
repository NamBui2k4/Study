import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
    public static void radixSort(int[] array) {
        int n = array.length;
        int max = getMax(array);
        // array = 170, 45, 75, 90, 802, 24, 2, 66
        // Do until we reach the largest digit place
        for (int exp = 1; max / exp > 0; exp *= 10) {
            Queue<Integer>[] buckets = new LinkedList[10];          // exp = 1
                                                                    //            24 45 6
            //                                                      //            2  75
                                                                    //      array = 170,90,802,24,2,45,75,6
            for (int i = 0; i < 10; i++) {
                buckets[i] = new LinkedList<>();
            }
            // Count the occurrences of each digit in the current place
            for (int i = 0; i < n; i++) {
                int digit = (array[i] / exp) % 10;
                buckets[digit].add(array[i]);
            }

            // Rebuild the array using the digits in this place
            int index = 0;
            for (int i = 0; i < 10; i++) {
                while (!buckets[i].isEmpty()) {
                    array[index++] = buckets[i].remove();
                }
            }
        }
    }

    // Utility function to find the maximum element in the array
    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(array);

        System.out.println("Sorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}


// input = 170, 45, 75, 90, 802, 24, 2, 66
// max(input) = 170
// num(170) = 3
// {count = 0;
// while(n!=0)
//      n=n/10
//      count++
//}
//1 --> count
//
