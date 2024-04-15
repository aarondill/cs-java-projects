import java.util.Random;
import java.util.Scanner;

public class PRJ_02_DP {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		// task1: get user name and print first consonant
		System.out.println(findConsonant(kb));
		// task 2: Create and then print 6 random numbers
		System.out.println(luckyNumbers());
		// task 3: get letter input and return position in alphabet
		System.out.println(findLetterNumber(kb));
		kb.close();
	}

	public static String findLetterNumber(Scanner kb) {
		// task 3: get letter input and return position in alphabet
		System.out.print("Enter a letter: ");
		char scanned = kb.next().charAt(0);
		// charcode 97 == a --- 122 == z
		int charCode = (int) (Character.toLowerCase(scanned)) - 96;
		return "The letter " + scanned + " is at position: " + String.valueOf(charCode);
	}

	private static Random random = new Random();

	public static int getRandom(int min, int max) {
		return random.ints(min, (max + 1)).findFirst().getAsInt();
	}

	public static String luckyNumbers() {
		// task 2: Create and then print 6 random numbers
		String r = String.valueOf(getRandom(0, 60));
		for (int i = 0; i <= 4; i++) {
			int t = getRandom(0, 60);
			if (r.contains(String.valueOf(t)))
				i--;
			else
				r += ", " + String.valueOf(t);
		}
		return "Your lucky lotto numbers are: " + r;
	}

	public static String findConsonant(Scanner kb) {
		// task1: get user name and print first consonant
		String vowels = "aeiou";
		System.out.print("First Name? ");
		String scanned = kb.next();
		for (int i = 0; i < scanned.length(); i++) {
			int ind = vowels.indexOf(scanned.toLowerCase().charAt(i));
			if (ind == -1)
				return "The first consonant in " + scanned + " is: " + scanned.charAt(i);
		}
		return "There is no consonant in " + scanned;
	}

}
