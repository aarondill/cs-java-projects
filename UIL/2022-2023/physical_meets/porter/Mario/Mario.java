import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Mario
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 11, 2023
 * </pre>
 *
 * Summary of file: magic
 *
 */
class Mario {
    private static String reverse(String str) {
        String r = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            r += str.charAt(i);
        }
        return r;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./mario.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            int letterCount = dataScanner.nextInt();
            String word = dataScanner.nextLine();
            if (letterCount > word.length()) {
                System.out.println("error");
                continue;
            }
            if (letterCount > word.length() / 2) {
                System.out.println(reverse(word));
                continue;
            }

            String start = word.substring(0, letterCount + 1);
            String end = word.substring(word.length() - letterCount);
            String reversedStart = reverse(start);
            String reversedEnd = reverse(end);
            String main = word.substring(letterCount + 1, word.length() - letterCount);
            System.out.printf("%s%s%s\n", reversedEnd, main, reversedStart);
        }
    }
}
