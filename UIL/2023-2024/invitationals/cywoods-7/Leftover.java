import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Leftover {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("leftover.dat"));

        int numIn = in.nextInt();
        for (int fun = 0; fun < numIn; fun++) {

            int numPeople = in.nextInt();
            int numPizza = in.nextInt();

            double sum = 0;
            for (int a = 0; a < numPeople; a++) {
                in.next();
                sum += in.nextDouble();
            }

            if (sum < numPizza) {
                System.out.println("Leftover for Bowen");
            } else {
                System.out.println("Bowen's crying");
            }

        }

    }

}
