import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Word {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("word.dat"));

        int numIn = in.nextInt();
        in.nextLine();
        for (int fun = 0; fun < numIn; fun++) {

            int numWords = in.nextInt();
            in.nextLine();

            int sum = 0;
            for (int a = 0; a < numWords; a++) {
                if (in.nextLine().toLowerCase().contains("christmas")) {
                    sum++;
                }
            }
            System.out.println(sum);
        }

    }

}
