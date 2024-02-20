import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Gael
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 15, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * Output: Output the shape created using the word given. It will be filled with
 * spaces in the
 * middle and the border will consist of the word multiple times. The corners
 * should match up so
 * that all the words are still spelled correctly, meaning certain words will
 * have to be backwards.
 * The two that will be backwards for this program are the word on the bottom of
 * the box, and the
 * word on the right side of the box. The necessary orientations of the 4 words
 * in the design is as
 * follows: The word on top of the box will go from left to right, the word on
 * the left side of the
 * box will go from top to bottom, the word on the bottom of the box will go
 * from right to left, and
 * the word on the right side of the box will go from bottom to top, see the
 * sample output for
 * clarification.
 * 
 */
class Gael {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./gael.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            String word = dataScanner.nextLine();
            System.out.println(word);
            for (int j = 1; j < word.length() - 1; j++) {
                System.out.println(word.charAt(j) + " ".repeat(word.length() - 2)
                        + word.charAt(word.length() - j));
            }
            for (int j = word.length() - 1; j >= 0; j--) {
                System.out.print(word.charAt(j));
            }
            System.out.println();
        }
    }
}
