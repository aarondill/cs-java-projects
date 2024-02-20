import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class Cho
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 08, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * Output the alphabetic (A-Za-z) character which occurred in the input line the
 * most, do not
 * include numbers, whitespace, special characters, or anything else that isn’t
 * a letter. If there
 * is a tie, just choose the letter that comes first alphabetically, with the
 * ENTIRE capital
 * alphabet coming before the lowercase alphabet (basically sort by ascii
 * values). *
 */
class Cho {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./cho.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            String line = dataScanner.nextLine();
            Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
            for (char c : line.toCharArray()) {
                if (c >= 97 && c <= 122 || c >= 65 && c <= 90) {
                    if (dictionary.containsKey(c)) {
                        dictionary.put(c, dictionary.get(c) + 1);
                    } else {
                        dictionary.put(c, 1);
                    }
                }
            }
            String maxChar = "a";
            int maxInt = 0;
            for (char key : dictionary.keySet()) {
                int count = dictionary.get(key);
                String stringKey = Character.toString(key);
                if (count > maxInt) {
                    maxChar = stringKey;
                    maxInt = count;
                } else if (count == maxInt) {
                    maxChar = stringKey.compareTo(maxChar) > 0 ? maxChar : stringKey;
                }
            }
            System.out.println(maxChar);
        }
    }
}
