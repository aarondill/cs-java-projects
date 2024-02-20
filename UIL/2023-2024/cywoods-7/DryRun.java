import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DryRun {

    public static void main(String[] args) throws IOException {

        System.out.println("team53");
        System.out.println("Daniel Myers");
        System.out.println("Carson Winter");
        System.out.println("Aaron Dill");
        System.out.println("Grand Oaks High School");
        System.out.println("Advanced");

        Scanner in = new Scanner(new File("dryrun.dat"));

        int length = in.nextInt();

        int total = 0;
        for (int a = 0; a < length; a++) {
            total += in.nextInt();
        }

        System.out.println(total);

    }

}