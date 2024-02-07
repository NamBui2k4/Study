import java.nio.channels.SelectableChannel;

public class Ex01{
    
    private static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
        /* Merge the temp arrays */
        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;
        // Initial index of merged sub-array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
            } else {
            arr[k] = R[j];
            j++;
            }
            k++;
        }
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

        // Main function of merge sort that sorts arr[first..last] using
    public static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            // Find the middle point
            int middle = (first + last) / 2;
            // Sort first and second halves
            mergeSort(arr, first, middle);
            mergeSort(arr, middle + 1, last);
            // Merge the sorted halves
            merge(arr, first, middle, last);
        }
    }

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

    public static void  SelectionSort(int arr[]){
        for(int i = 0; i< arr.length - 1 ; i++){
            for(int j = i + 1 ; j < arr.length; j++ ){
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void BubbleSort( int arr[]){
        for(int i = 0; i < arr.length - 1 ; i++){
            for(int j = 0 ; j < arr.length - i - 1; j++ ){
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }                                              
    public static void main(String[] args){
    int a[] = { 9,1,4,7,2,2,10};
    BubbleSort(a);
    for(int i : a){
        System.out.print(i + " ");
    }
    
}

}








