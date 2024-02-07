public class lab52 {

    public static String shortName(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String[] names = str.split("\\s+");
        if (names.length < 2) {
            return str;
        }
        return names[names.length - 1] + " " + names[0];
    }

    public static String hashtagName(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String[] names = str.split("\\s+");
        if (names.length < 2) {
            return "#" + str;
        }
        return "#" + names[names.length - 1] + names[0];
    }

    public static String upperCaseAllVowel(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ("AEIOUaeiou".indexOf(ch) >= 0) {
                result += Character.toUpperCase(ch);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static String upperCaseAllN(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'n' || ch == 'N') {
                result += Character.toUpperCase(ch);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "Nguyen Le Trong Tin";
        System.out.println("Original string: " + str);

        String shortName = shortName(str);
        System.out.println("Short name: " + shortName);

        String hashtagName = hashtagName(str);
        System.out.println("Hashtag name: " + hashtagName);

        String upperCaseAllVowel = upperCaseAllVowel(str);
        System.out.println("Uppercase all vowels: " + upperCaseAllVowel);

        String upperCaseAllN = upperCaseAllN(str);
        System.out.println("Uppercase all Ns: " + upperCaseAllN);
    }
}