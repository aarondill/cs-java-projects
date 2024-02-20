import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class DryRun
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 11, 2023
 * </pre>
 *
 * Summary of file: Write a program that reads a list of items from the input
 * file and outputs a
 * message for each.
 *
 */
class DryRun {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./dryrun.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            System.out.println("I like " + dataScanner.nextLine() + ".");
        }
    }
}
