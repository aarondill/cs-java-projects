import java.util.Scanner;

/**
 * Class Raymond
 *
 * <pre>
 * Author1: Aaron Dill
 * Date:	March 25, 2023
 * </pre>
 *
 * Summary of file:
 * 
 *
 */
public class Raymond {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Raymond.class.getResourceAsStream("./raymond.dat"));
        while (scan.hasNextInt()) {
            int i = scan.nextInt();
            System.out.printf("%d %d\n", i, ~i);
        }
    }
}
