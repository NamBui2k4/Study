
public class ex03 {
    public static String firstLastName(String name){
        String namePart[] = name.split(" ");
        String firstName = namePart[namePart.length - 1];
        String lastName = namePart[0];
        return lastName + " " + firstName;
    }
    public static String [] middleName(String name){
        String namePart[] = name.split(" ");
        String middleName[] = new String[namePart.length - 2];
        for (int i = 0 ; i < middleName.length ; i++){
            middleName[i] = namePart[i+1];
        }
        return middleName;
        
    }

    public static String [] Capitalize(String name){
        String namePart[] = name.split(" ");
        for(int i =0; i < namePart.length; i++){
            namePart[i] = namePart[i].substring(0,1).toUpperCase() + namePart[i].substring(1);
        }
        return namePart;
    }
    public static void main(String[]args){
        String name = "nguyen van chien";

        System.out.println(firstLastName(name));
        
        String middleName[] = middleName(name);

        for (int i = 0 ; i < middleName.length ; i++){
            System.out.print(middleName[i] + " ");
        }
        System.out.println();
        String Capitalize[] = Capitalize(name);
        for (int i = 0 ; i < Capitalize.length ; i++){
            System.out.print(Capitalize[i] + " ");
        }

    }
}
