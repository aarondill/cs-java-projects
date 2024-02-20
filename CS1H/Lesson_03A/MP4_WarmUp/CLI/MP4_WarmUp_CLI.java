package MP4_WarmUp.CLI;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class MP4_WarmUp_CLI
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
 * using CLI arguments:
 * 
 * <pre>
 * My name is %s
 * I am %d years old
 * During Spring Break I slept for an average of %.2f hours per day and was online for %.2f hours
 * The 3 things I enjoyed most were %s, %s, and %s
 * </pre>
 */

public class MP4_WarmUp_CLI {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 6) {
            System.out.println(MP4_WarmUp_CLI.class.getName() + " requires at least 6 arguments");
            System.exit(2);
        }
        final var PROMPT_FORMAT = "My name is %s\nI am %d years old\nDuring Spring Break I slept for an average of %.2f hours per day and was online for %.2f hours\nThe %d things I enjoyed most were %s\n";
        var firstName = args[0];

        var lastName = args[1];
        var fullName = firstName + " " + lastName;

        long myAge = Long.parseLong(args[2]);
        float sleepHrs = Float.parseFloat(args[3]);
        float onlineHrs = Float.parseFloat(args[4]);
        List<String> mostEnjoyed = new ArrayList<>();
        var enjoyedCount = args.length - 5;
        for (int i = 0; i < enjoyedCount; i++) {
            mostEnjoyed.add(args[i + 5]);
        }
        mostEnjoyed.set(mostEnjoyed.size() - 1, "and " + mostEnjoyed.get(mostEnjoyed.size() - 1));
        // PROMPT: The X things I enjoyed most were...
        System.out.printf(PROMPT_FORMAT, fullName, myAge, sleepHrs, onlineHrs, enjoyedCount,
                String.join(", ", mostEnjoyed));
    }
}
