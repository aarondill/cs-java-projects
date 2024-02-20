import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Gael
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Date:	February 08, 2023
 * </pre>
 *
 * Summary of file: Make a box from some words
 *
 */
class Gael {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner datScanner = new Scanner(new File("./gael.dat"));
        int dataCount = datScanner.nextInt();
        datScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            String word = datScanner.nextLine();

            String spacing = " ".repeat(word.length() - 2);
            System.out.println(word);
            for (int j = 1; j < word.length() - 1; j++) {
                System.out.println(word.charAt(j) + spacing + word.charAt(word.length() - j - 1));
            }
            for (int k = word.length() - 1; k >= 0; k--) {
                System.out.print(word.charAt(k));
            }
            System.out.println();
        }
    }
}
