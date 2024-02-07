public class Ex07 {
    // a)
    public static int findMinimum(int[] arr, int size) {
        if (size == 1) {
            return arr[0]; // Base case: if the array has only one element, it's the minimum.
        } else {
            int minInRest = findMinimum(arr, size - 1); // Find the minimum in the rest of the array.
            if (minInRest < arr[size - 1]) {
                return minInRest; // If minInRest is smaller, return it.
            } else {
                return arr[size - 1]; // Otherwise, return the last element as the minimum.
            }
        }
    }
    // input = {2 1 4 0 3 9}
    // min(input, 6) : min(input,5) < 9 ? min(input,5) : 9
    // min(input,5) : min(input,4) < 3 ? min(input,4) : 3
    // min(input,4) : min(input,3) < 0 ? min(input,3) : 0
    // min(input,3) : 1 < 4 ? => 1
    // min(input,2) : 2 < 1 ? => 1
    // min(input,1)  => 2

    public static int minimum(int input[]){
        return  findMinimum(input, input.length);
    }
    // 2 1 4 0 3 9
    //  min(2,1) : 2 > 1
    public static int sum(int input[] , int end){
        if(input.length == 0)
            return 0;
        if(end == 0)
            return input[0];
        return  input[end] + sum(input, end - 1);
    }
    public static int sum(int input[]){
        return  sum(input, input.length - 1);
    }
    // { 1,2,3 }
    //  6 + sum(input[],)

    public static void main(String [] args){
        int a[] = { 2 ,1 ,4 ,0 ,3 ,9};
        System.out.println(sum(a));
        System.out.println(minimum(a));
    }
}