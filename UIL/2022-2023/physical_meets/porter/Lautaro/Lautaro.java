import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Lautaro
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 11, 2023
 * </pre>
 *
 * Summary of file: Validate a phone number
 *
 */
class Lautaro {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./lautaro.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            String phoneNumber = dataScanner.nextLine();
            boolean valid = phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}");
            if (valid)
                System.out.println("Valid Phone Number.");
            else
                System.out.println("No Calls for You.");
        }
    }
}
