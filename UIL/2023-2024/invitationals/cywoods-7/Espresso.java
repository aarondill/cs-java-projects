import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Espresso {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("espresso.dat"));

        int numIn = in.nextInt();
        in.nextLine();
        for (int fun = 0; fun < numIn; fun++) {

            int numDeals = in.nextInt();
            double max = Double.MAX_VALUE;
            int maxIndex = 0;

            for (int i = 0; i < numDeals; i++) {
                int beans = in.nextInt();
                int price = in.nextInt();
                double pricePerBean = (double) price / beans;

                if (pricePerBean < max) {
                    max = pricePerBean;
                    maxIndex = i;
                }
            }

            System.out.println(maxIndex + 1);

        }

    }

}
