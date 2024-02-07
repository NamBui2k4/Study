import java.util.Arrays;

public class Main {
    private static void merge(int arr[],int first,int middle,int last) {
                                        // int l, int m, int r
        // Ex: [1, 0, 3, 9, 7, 5, 11]         
        // first = 0, middle = 4 , last = 9

        // Find sizes of two sub-arrays to be merged
        int size_1 = middle - first + 1; // => 4 - 0 + 1 = 5
        int size_2 = last - middle; // => 9 - 4 = 5

        // Create temp arrays
        int L[] = new int[size_1]; int R[] = new int[size_2];
       
        // Copy data to temp arrays
        for (int i = 0; i < size_1; i++)
            L[i] = arr[first + i];  // [1, 0, 3, 9]
        for (int j = 0; j < size_2; j++) 
            R[j] = arr[middle + 1 + j]; // [7, 5  , 11] =>
            
        /* Merge the temp arrays */
        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;
        // Initial index of merged sub-array
        int k = first;
        while (i < size_1 && j < size_2) {
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
        while (i < size_1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy remaining elements of R[] if any
        while (j < size_2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function of merge sort that sorts arr[first..last] using merge() method
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

    public static void mergeSort(int arr[]) throws ArrayIndexOutOfBoundsException{
        if(arr.length == 0)
            throw new ArrayIndexOutOfBoundsException("Arrays have no elements");
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
    }
    public static void main(String[] args){
        int arr[] = new int[args.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(args[i]);
        }
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}