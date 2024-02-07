
public class ex05 {
    public static String[][] countWords(String str) {
        str = str.replace(",",""); // O(1)
       
        String[] spl = str.split(" "); //O(1)
        String[] unique = new String[spl.length];// O(1)
        int uniqueCount = 0; // O(1)
        for(int i = 0, k = 0; i < spl.length; i++) {
            boolean isExist = false;// O(n)
            for(int j = 0; j < uniqueCount; j++) {
                if(spl[i].equalsIgnoreCase(unique[j])) {    
                    isExist = true; // O(n^2)
                    break;
                }
            }
            if(!isExist) {
                unique[k++] = spl[i];   // O(n)
                uniqueCount++;// O(n)
            }
        }
        int[] frequency = new int[unique.length];// O(1)
        for(String temp : spl) {
            for(int i = 0; i < unique.length; i++) {
                if(temp.equalsIgnoreCase(unique[i])) {
                    frequency[i]++; // O(n^2)
                }
            }
        }
        String[][] result = new String[uniqueCount][2]; //O(1)
        for(int i = 0; i < uniqueCount; i++) {
            result[i][0] = unique[i]; // O(n)
            result[i][1] = Integer.toString(frequency[i]); // O(n)
        }
        return result;
    }
    // 3n^2 + 5n + 6

    public static void main(String[] args) {
        String str = "You are living on a Plane. What you style Flatland is the vast level surface of what I may call a fluid, on, or in, the top of which you and your countrymen move about, without rising above it or falling below it.";
        String[][] result = countWords(str);
        // for(int i = 0; i < result.length; i++) {
        //     System.out.println("'" + result[i][0] + "': " + result[i][1] + ",");
        // }
        String[] format = new String[result.length];
        for(int i = 0; i < result.length; i++) {
            format[i] = "'" + result[i][0] + "': " + result[i][1];
        }
        System.out.println(String.join(",\n", format));
    }
} 