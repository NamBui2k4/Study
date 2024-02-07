import java.util.*;
public class Main{
    public static boolean swap(int arr[]){
        for(int i =0; i < arr.length - 1; i++){
            if(arr[i] == 0){
                for(int j = i + 1; j < arr.length; j ++){
                    if(arr[j] != 0){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static String findWinner(int listCow[]){
        int listStall[] = new int[listCow.length - 1];
        //      
        // listCow = {1,2,4}
        // cowInStall = 1 2 3 4 5
        //          i = 0 1 2 3 4  , i + 1 => 1 2 3 4 5
        // listStall = {0,0,0,0,0}

        //             
        int i = 0;
        while(i < listStall.length){
            int j = 0;
            while(j < listCow.length){
                if(listCow[j] == i + 1){
                    listStall[i] = listCow[j];
                }
                j++;
            }
           i++;
        }
        // {1,2,0,4,0} 
        boolean checkHieu =  false;
        boolean checkRR = false;
        boolean endGame = false;
        while(!endGame){
            checkHieu = swap(listStall);
            if(!checkHieu)
                return "RR";
            
            if(!checkRR)
                return "Hieu";
        }
        return null;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numCase;
        do{
            numCase = sc.nextInt();
        }while(numCase > 100000);
        sc.nextLine();
        int count = 0;
        while(count < numCase){
            int numCow = sc.nextInt();
            int listCow[] = new int[numCow];
            int i = 0;
            while(i < numCow){
                int index = sc.nextInt(); 
                listCow[i] = index;
                i++;
            }
            count ++;
            System.out.println(findWinner(listCow));
        }
        sc.close();
        
    }
}


