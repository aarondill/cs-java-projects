package MP4_WarmUp.Dat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class MP4_WarmUp_Dat
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	March 21, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file:
 * 
 * The program outputs a response to the prompt given in the following format
 * using a .dat file:
 * 
 * <pre>
 * My name is %s
 * I am %d years old
 * During Spring Break I slept for an average of %.2f hours per day and was online for %.2f hours
 * The 3 things I enjoyed most were %s, %s, and %s
 * </pre>
 */

public class MP4_WarmUp_Dat {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("./MP4_WarmUp.Dat"));
        final var PROMPT_FORMAT = "My name is %s\nI am %d years old\nDuring Spring Break I slept for an average of %.2f hours per day and was online for %.2f hours\nThe %d things I enjoyed most were %s\n";
        int enjoyedCount = scan.nextInt();
        scan.nextLine();

        var firstName = scan.nextLine();

        var lastName = scan.nextLine();
        var fullName = firstName + " " + lastName;

        long myAge = scan.nextLong();
        scan.nextLine();
        float sleepHrs = scan.nextFloat();
        scan.nextLine();
        float onlineHrs = scan.nextFloat();
        scan.nextLine();
        List<String> mostEnjoyed = new ArrayList<>();
        for (int i = 0; i < enjoyedCount; i++)
            mostEnjoyed.add(scan.nextLine());
        mostEnjoyed.set(mostEnjoyed.size() - 1, "and " + mostEnjoyed.get(mostEnjoyed.size() - 1));
        // PROMPT: The X things I enjoyed most were...
        System.out.printf(PROMPT_FORMAT, fullName, myAge, sleepHrs, onlineHrs, enjoyedCount,
                String.join(", ", mostEnjoyed));
    }
}
