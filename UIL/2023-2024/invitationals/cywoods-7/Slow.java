import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Slow {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("slow.dat"));

        int numIn = in.nextInt();
        in.nextLine();
        for (int fun = 0; fun < numIn; fun++) {

            String[] nums = in.nextLine().split("\\+");
            int sum = 0;
            for (String num : nums) {
                sum += Integer.parseInt(num);
            }

            System.out.println("1" + "+1".repeat(sum-1) + " makes " + sum + "!");

        }

    }

}
