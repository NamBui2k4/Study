import java.util.Arrays;

public class Test {
  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    // index of smaller element
    int i = (low - 1);
    for (int j = low; j < high; j++) {
        // If current element is smaller than or equal to pivot
        if (arr[j] <= pivot) {
        i++;
        // swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
// swap arr[i+1] and arr[high] (or pivot)
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}


// The main function that implements QuickSort algorithm
// arr[] --> Array to be sorted ,
// low --> Starting index ,
// high --> Ending index
public static void QuickSort(int[] arr, int low, int high) {
if (low < high) {
    // pi is partitioning index , arr[pi] is now at right place
    int pi = partition(arr, low, high);
    // Recursively sort elements before partition and after
    QuickSort(arr, low, pi - 1);
    QuickSort(arr, pi + 1, high);
}
}
public static void main(String[] args){
    Fraction d = new Fraction('D');
    System.out.println(d);

    Fraction b = new Fraction('B');
    System.out.println(b);

    FractionComparator c = new FractionComparator();
    System.out.println(c.compare(d, b));
}
  }