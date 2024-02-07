

public class ex01 {
    // 1.1
    public static boolean first_element(int arr[]){
        int arr1[] = new int[arr.length -1 ];
        if (arr.length == 0 )
            return false;
        else {
            for (int i = 0; i < arr.length -1  ; i++){
                arr1[i] = arr[i+1];
            }
        }
        return true;
            
    }
    // 1.2
    public static void insert(int arr[], int p, int a){
        if (p > arr.length)
            System.out.println("out of index");
        arr[p] = a;
            for(int i = 0; i < arr.length ; i++){
                System.out.print(arr[i]+ " ");
            }
    }
    public static int []remove(int[]arr){
        int[] unique = new int [arr.length];
        int countunique = 0;
        for(int i =0, j=0; i < arr.length ;i++){
            boolean isExit = false;
            for(int k = 0; k < countunique; k++ ){
                if (arr[i]==unique[k]){
                    isExit = true;
                    break;
                }
            }
            if (!isExit){
                unique[j++] = arr[i];
                countunique++;
            }
        }
        int [] result = new int [countunique];
        for(int i = 0 ; i < countunique ; i++){
            result[i]= unique[i];
        }
        return result;
    
    }
    public static int [] findDuplicate(int arr[]){
      int dem = 0;
      int new_array[] = new int[arr.length];
        for(int i = 0;i < arr.length - 1 ; i++ ){
            for(int j = i+1; j<arr.length; j++){
                if (arr[i] == arr[j]){
                    new_array[dem++] = arr[i];
                    break;
                }

                    
            }
        }
        int duplicates[] = new int[dem];
        for(int i = 0; i< duplicates.length; i++){
            duplicates[i] =  new_array[i];
        }
        return duplicates;

    }
    
    
    
    public static void main(String[]args){
        int arr[] = {2,2,6,6,6,1,24,515,35,1,5,5,1};
        int a = 5;
        int p = 5;

        insert(arr,p,a);
        System.out.println();

        System.out.print(first_element(arr)+ " ");
        System.out.println();
        
        int b[] = findDuplicate(arr);
        for (int i =0 ; i< b.length; i++){
            System.out.print(b[i] + " ");
        }
        
    }
    
}
