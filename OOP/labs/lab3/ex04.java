public class ex04 {
    public static int lengthString(String character []){
        return character.length;
    }
    public static int countNumberWord(String character){
        String characterPart[] = character.split(" ");
        int dem = 0;
        for(int i = 0; i< characterPart.length; i++){
            dem++;
        }
        return dem;
    }
    
    public static void main(String[]args){
        String character = "Hello World";
        System.out.println(character);
        System.out.println(countNumberWord(character));


    }
    
}
