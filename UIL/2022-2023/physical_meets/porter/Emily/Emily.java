import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Emily
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 11, 2023
 * </pre>
 *
 * Summary of file: output a mathematical expression
 *
 */
class Emily {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./emily.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            String line = dataScanner.nextLine();
            String[] parts = line.split(" ");
            int a = Integer.parseInt(parts[0]);
            String operator = parts[1];
            int b = Integer.parseInt(parts[2]);
            System.out.print(line + " = ");
            switch (operator) {
                case "x":
                case "X":
                case "*":
                    System.out.println(a * b);
                    break;
                case "/":
                    System.out.println((a / b) + " remainder " + (a % b));
                    break;
                case "-":
                    System.out.println(a - b);
                    break;
                case "+":
                    System.out.println(a + b);
                    break;

            }
        }
    }
}
