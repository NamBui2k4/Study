public class ex02 {
    public static int [][] add(int arr1[][],int arr2[][] ){
        if ((arr1.length != arr2.length) || (arr1[0].length != arr2[0].length)){
            int sum[][] = {{-1},{-1}} ;
            return sum;
    }
        else{                    
        int sum[][] = new int[arr1.length][arr1[0].length];
        for(int i = 0; i <arr1.length  ; i++){
            for(int j = 0; j < arr1[0].length; j++){
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return sum;

    }
    
    }
    public static int [][] mutiply(int arr1[][],int arr2[][]){
        if (arr1[0].length != arr2.length){
            int sum[][] = {{-1},{-1}} ;
            return sum;
        }    
        else {
            int new_matrix[][] = new int [arr1.length][arr2[0].length];
            for (int i = 0; i < arr1.length ;i++  ){
                for (int j = 0 ; j < arr2[0].length; j++){
                    for (int k = 0 ; k < arr2.length; k++){
                        new_matrix[i][j] += arr1[i][j]*arr2[i][j];
                    }
                    
                }
            }
            return new_matrix;
        }            
    }

    public static void main(String[]args){
        int arr1[][] = {{1,2,3}, 
                        {4,2,6}};

        int arr2 [][] = {{5,2,1},
                         {3,1,1}};
        int arr3 [][] = {{3,1,5},
                         {9,0,0},
                         {8,1,1}};

        int sum[][] = add(arr1,arr2);
        for(int i = 0; i <arr1.length  ; i++){
            for(int j = 0; j < arr1[0].length; j++){
                System.out.print(sum[i][j] + " ");
            }
        }
        
        int mutiply[][] = mutiply(arr1,arr3);
        for(int i = 0; i <arr1.length  ; i++){
            for(int j = 0; j < arr1[0].length; j++){
                System.out.println(mutiply[i][j] + " ");
            }
        }


}
}
