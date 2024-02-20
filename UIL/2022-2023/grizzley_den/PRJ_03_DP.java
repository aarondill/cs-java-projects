import java.util.Random;
import java.util.Scanner;

public class PRJ_03_DP {

   // Task 1) Take the code that you created for PRJ_02 revise it so that...
   // it takes advantage of the Random class (simplifies creating a random number)
   // it takes advantage of the String class (i.e. toLowerCase and/or toUpperCase)

   // returns the position in the alphabet for a letter gotten through user input
   public static String findLetterNumber(Scanner scanner) {
      System.out.print("Enter a letter ");
      char scanned = scanner.next().charAt(0);
      int charCode = (int) (Character.toLowerCase(scanned)) - 96;
      return "The letter " + scanned + " is at position: " + String.valueOf(charCode);
   }

   // returns a string with 6 random numbers between 0 and 60
   public static String luckyNumbers() {
      Random ran = new Random();
      String r = "";
      for (int i = 0; i <= 5; i++) {
         int t = ran.nextInt(61);
         if (r.contains(String.valueOf(t)))
            i--;
         else
            r += String.valueOf(t) + ", ";
      }
      return "Your lucky lotto numbers are: " + r.substring(0, r.length() - 2);
   }

   // returns a string with the first consonant in a name gotten through user input
   public static String findConsonant(Scanner scanner) {
      String vowels = "aeiou";
      System.out.print("First Name? ");
      String scanned = scanner.next();
      for (int i = 0; i < scanned.length(); i++) {
         int ind = vowels.indexOf(scanned.toLowerCase().charAt(i));
         if (ind == -1)
            return "The first consonant in " + scanned + " is: " + scanned.charAt(i);
      }
      return "There is no consonant in " + scanned;
   }

   // Task 2) Create the following methods using the code you created for PRJ_02

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

   // Task 3) Write the code and create the method below

   // method returns a random String from a String[] array
   public static String randomStringFromArray(String[] array) {
      int i = new Random().nextInt(array.length);
      return array[i];
   }

   // main method printlns each function result.
   public static void main(String[] arg) {
      // return formatted strings
      Scanner scanner = new Scanner(System.in);
      System.out.println(luckyNumbers());
      System.out.println(findLetterNumber(scanner));
      System.out.println(findConsonant(scanner) + "\n");
      scanner.close();
      // need formatting on the return value
      System.out.println("The first consonant in Heiser is: " + firstConsonant("Heiser"));
      System.out.println(String.format("The letter j is at position %s in the alphabet", findAlphabetIndex('j')));
      System.out.println("A random number between 1 and 20: " + randomNumToTwenty());
      String[] fruits = { "apples", "bananas", "peaches", "oranges", "strawberries", "blueberries", "raspberries",
            "blackberries" };
      System.out.println("A random element from the given fruits array is: " + randomStringFromArray(fruits)); // oranges
   }
}
