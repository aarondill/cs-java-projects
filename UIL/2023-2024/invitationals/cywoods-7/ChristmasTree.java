import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChristmasTree {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("ChristmasTree.dat"));

        int numIn = in.nextInt();
        for (int fun = 0; fun < numIn; fun++) {

            int numRows = in.nextInt();
            in.nextLine();
            String words = in.nextLine();
            Scanner scanner = new Scanner(words);
            String symbol = scanner.next();

            ArrayList<Integer> positions = new ArrayList<>();

            while (scanner.hasNext()) {
                positions.add(scanner.nextInt());
            }

            int listLength = 0;
            for (int a = 1; a < numRows; a++) {
                listLength += a*2;
            }

            int currentPos = 1;
            for (int a = 0; a < numRows; a++) {
                System.out.print(" ".repeat(numRows-1-a));
                System.out.print("/");
                for (int b = 1; b <= a*2; b++) {
                    if (positions.contains(currentPos)) {
                        System.out.print(symbol);
                    } else {
                        System.out.print('-');
                    }
                    currentPos++;
                }
                System.out.println("\\");
            }
            System.out.println(" ".repeat(numRows-1) + "||");

            System.out.println();
        }

    }

}
