import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Lab3B10
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   April 14, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file: Reads a list of names from a file and sorts them
 * alphabetically.
 */

public class Lab3B10 {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(new File("lab3B10.in"));
        ArrayList<Integer> names = new ArrayList<>();
        //Input section
        while (f.hasNextInt()) {
            names.add(f.nextInt());
        }
        //Process Section
        names.sort(null);
        //Output section
        for (Integer name : names) {
            System.out.println(name);
        }
    }
}
