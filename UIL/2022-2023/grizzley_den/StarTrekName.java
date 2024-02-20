
/* 
*  Your Team’s Name: Data Piratess
*  Title: StarTrekName
*  Purpose: Create a StarTrekName for each race baced on user input
*  Function: (see above)
*  Date: November 2, 2022
*/
import java.util.Random;
import java.util.Scanner;

public class StarTrekName {
    // This method takes a String name and returns the first consonant character
    public static String firstConsonant(String name) {
        String vowels = "aeiou";
        for (int i = 0; i < name.length(); i++) {
            int ind = vowels.indexOf(name.toLowerCase().charAt(i));
            if (ind == -1)
                return name.charAt(i) + "";
        }
        return "NO CONSONANT";
    }

    // This takes a char letter and returns the int index of it in the alphabet.
    public static int findAlphabetIndex(char letter) {
        return (int) (Character.toLowerCase(letter)) - 96;
    }

    // This method produces a random number between 1 and 20
    public static int randomNumToTwenty() {
        return new Random().nextInt(20) + 1;
    }

    // method returns a random String from a String[] array
    public static String randomStringFromArray(String[] array) {
        int i = new Random().nextInt(array.length);
        return array[i];
    }

    public static String getKlingonName(String name) {
        String[] klingonEndings = { "arot", "Ghor", "uras", "owron", "arot", "'Ghor", "uras", "owron", "rilka", "orkon",
                "ahless", "ang", "oloth", "orax", "lavek", "'Rell", "artok", "ogh", "orf" };
        String consonant = firstConsonant(name);
        return consonant.toUpperCase() + randomStringFromArray(klingonEndings);
    }

    public static String getVulcanName(String name, char maleFemale) {
        String r = "";
        if (maleFemale == 'f') {
            // female
            String[] femaleEndings = new String[] { "loren", "ar", "arra", "in", "lass", "osa", "eng", "ona", "ana",
                    "elek", "au", "ring", "esik", "ora" };
            String Const = firstConsonant(name).toUpperCase();
            r = "T\'" + Const + randomStringFromArray(femaleEndings);

        } else if (maleFemale == 'm') {
            // male
            String[] maleEndings = new String[] { "esh", "ovar", "irak", "alok", "elik", "alor", "ybok", "utok", "pock",
                    "arek", "urok", "avek", "urak", "uvok", "arek", "elik" };
            String Const = firstConsonant(name).toUpperCase();
            r = Const + randomStringFromArray(maleEndings);
        }
        return r;
    }

    public static String getBorgName(String name) {
        int firstIndex = findAlphabetIndex(name.charAt(0));
        int second = firstIndex + randomNumToTwenty();
        return firstIndex + " of " + second;
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String name = scanner.nextLine();
        if (name.length() == 0) {
            System.out.println("please input a name");
            scanner.close();
            return;
        }
        System.out.print("Klingon, Vulcan, or Borg?: (Klingon) ");
        String modein = scanner.nextLine().toLowerCase();
        char mode;
        if (modein.length() > 0)
            mode = modein.charAt(0);
        else
            mode = ' ';
        switch (mode) {
            default:
                System.out.println("Your Klingon name is: " + getKlingonName(name));
                break;
            case 'v':
                System.out.print("Male or Female?(m/f): ");
                char maleFemale = scanner.next().toLowerCase().charAt(0);
                System.out.println("Your " + (maleFemale == 'f' ? "fe" : "") + "male Vulcan name is: "
                        + getVulcanName(name, maleFemale));
                break;
            case 'b':
                System.out.println("Your Borg name is: " + getBorgName(name));
                break;
        }
        scanner.close();
    }
}
