import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Sweater {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("sweater.dat"));
        while (in.hasNextInt()) {
            int num = in.nextInt();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < num ; j++) {
                    System.out.println("X".repeat(num* 4 + 3));
                }
                System.out.println("X".repeat(num)+"*"+"X".repeat(num)+"*"+"X".repeat(num)+"*"+"X".repeat(num));

            }
            for (int j = 0; j < num ; j++) {
                System.out.println("X".repeat(num* 4 + 3));
            }
            System.out.println();
        }

    }
}