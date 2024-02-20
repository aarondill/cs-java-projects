import java.util.Scanner;

/**
 * Class Layla
 *
 * <pre>
 * Author1: Aaron Dill
 * Date:	March 24, 2023
 * </pre>
 *
 * Summary of file:
 * Output the values of a imaginary measurement system
 */
public class Layla {
    public static void main(String[] args) {
        Scanner input = new Scanner(Layla.class.getResourceAsStream("./layla.dat"));
        while (input.hasNextLine()) {
            Scanner lineScan = new Scanner(input.nextLine());
            int x = lineScan.nextInt();
            int y = lineScan.nextInt();
            double d = lineScan.nextDouble();
            String c = lineScan.next();
            lineScan.close();
            double A = 0, B = 0, C = 0;
            switch (c) {
                case "A":
                    A = d;
                    B = A / x;
                    C = B / y;
                    break;
                case "B":
                    B = d;
                    A = B * x;
                    C = B / y;
                    break;
                case "C":
                    C = d;
                    B = d * y;
                    A = B * x;
                    break;
            }
            System.out.printf("A = %.3f\n", A);
            System.out.printf("B = %.3f\n", B);
            System.out.printf("C = %.3f\n", C);
            System.out.println("=====");
        }
    }
}
