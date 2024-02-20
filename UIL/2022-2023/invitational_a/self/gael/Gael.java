import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Gael
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Daniel Behringer
 * Author4: Christian Adusei
 * Date:	February 08, 2023
 * </pre>
 *
 * Summary of file: Make a box from some words
 *
 */
class Gael {
    private static void printSides(String word) {
        String spacing = " ".repeat(word.length() - 2);
        System.out.println(word);
        for (int i = 1; i < word.length() - 1; i++) {
            System.out.print(word.charAt(i));
            System.out.print(spacing);
            System.out.println(word.charAt(word.length() - 1 - i));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner datScanner = new Scanner(new File("./gael.dat"));
        int dataCount = datScanner.nextInt();
        datScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            String word = datScanner.nextLine();
            printSides(word);
            for (int j = word.length() - 1; j >= 0; j--) {
                System.out.print(word.charAt(j));
            }
            System.out.println();
        }
    }
}
