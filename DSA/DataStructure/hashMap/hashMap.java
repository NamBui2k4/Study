import java.util.*;
import java.util.Map.Entry;
class hashMap{
    public static int findDigit(int input){
        char temp[] = String.valueOf(input).toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        for(Character c : temp){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,0);
            }
        }
    
        int maxValue = Integer.MIN_VALUE;
        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue || maxValue == entry.getValue() ) {
                maxValue = entry.getValue();
            }
        }

        int list_digit[] = new int[10];
        int count = 0;
        
        for(Entry<Character, Integer> entry : map.entrySet()){
            if(maxValue == entry.getValue())
                list_digit[count++] = Character.getNumericValue(entry.getKey());
        }
        int Min = Integer.MAX_VALUE;
        for(int i : list_digit){
            if(Min > i && i != 0){
                Min = i;
            }
               
        }
        return Min;
        // 1 1 3 1 2 6 5 6 7 1 4
    }

    public static int NotUsingHasHMap(int input){
        char temp[] = String.valueOf(input).toCharArray();
        int n = temp.length;
        int frequency[] = new int[10];
        for(int i = 0; i < n - 1; i++){
            int index = 0;
            int count = 1;
            char c = temp[i];
            for(int j = i + 1; j < n ; j++){
                if (c == temp[j])
                    frequency[index++] = count++;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n; i++){
            if(max < frequency[i])
                max = frequency[i];
        }
        int list_digit[] = new int[0];
        for(int i = 0; i < n - 1; i++){
            int index = 0;
            int count = 1;
            char c = temp[i];
            for(int j = i + 1; j < n ; j++){
                if (c == temp[j])
                    count++;
            }
            if(count == max)
                list_digit[index++] = c;
        }
        int Min = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            if()
        }
    }
    public static void main(String[] args){
        int input = 223315;
        System.out.print(findDigit(input));
    }   
}
