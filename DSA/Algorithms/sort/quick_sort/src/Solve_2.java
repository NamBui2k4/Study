public class Solve_2{
    
        public static void main(String[] args) {
          int[] x = {6, 2, 3, 4, 5, 9, 1};
          printArray(x);
      
          int left = 0;
          int right = x.length - 1;
      
          quickSort(x, left, right);
          printArray(x);
        }
      
        public static void quickSort(int[] arr, int left, int right) {
          if (arr == null || arr.length == 0)
            return;
      
          if (left >= right)
            return;
      
          int middle = left + (right - left) / 2;
          int pivot = arr[middle];
          int i = left, j = right;
      
          while (i <= j) {
            while (arr[i] < pivot) {
              i++;
            }
      
            while (arr[j] > pivot) {
              j--;
            }
      
            if (i <= j) {
              int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
              i++;
              j--;
            }
          }
      
          if (left < j)
            quickSort(arr, left, j);
      
          if (right > i)
            quickSort(arr, i, right);
        }
      
        public static void printArray(int[] arr) {
          for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
          }
      
          System.out.println();
        }
      
}