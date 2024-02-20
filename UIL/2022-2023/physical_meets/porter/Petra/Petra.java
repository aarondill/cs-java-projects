import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Petra
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 11, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * output an integer representing the reverse of the GCF of the number
 *
 */
class Petra {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./petra.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            int inputInt = dataScanner.nextInt();
            String inputString = "" + inputInt;
            String reversedInputString = "";
            for (int j = inputString.length() - 1; j >= 0; j--) {
                reversedInputString += inputString.charAt(j);
            }
            int reversedInputInt = Integer.parseInt(reversedInputString);

            double maxFactor = 0;
            if (inputInt != reversedInputInt) {
                for (double j = 0; j < inputInt; j++)
                    if (inputInt % j == 0 && reversedInputInt % j == 0 && j > maxFactor)
                        maxFactor = j;
            } else {
                maxFactor = inputInt;
            }
            System.out.println((int) maxFactor);
        }
    }
}
