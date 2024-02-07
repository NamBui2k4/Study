public class Solve_1 {
    public static int partition(int arr[], int start, int end){
        int pivot = arr[end];
        int i = start - 1;
        for(int j = start; j < end; j++){
            if(arr[j] <= pivot ){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
        return i+1;
    }   
    public static void QuickSort(int[] arr, int start, int end){
        if(start < end){
            int pivot = partition(arr, start, end);
            QuickSort(arr, start, pivot - 1);
            QuickSort(arr, pivot + 1, end);

        }
    }

    public static void main(String[] args){
        int a[] = {27, 38, 12, 39, 27, 16};
        QuickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
