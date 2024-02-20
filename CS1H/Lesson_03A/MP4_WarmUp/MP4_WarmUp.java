package MP4_WarmUp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class MP4_WarmUp
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
 * The program outputs a response to the prompt given in the following format:
 * 
 * <pre>
 * My name is %s
 * I am %d years old
 * During Spring Break I slept for an average of %.2f hours per day and was online for %.2f hours
 * The 3 things I enjoyed most were %s, %s, and %s
 * </pre>
 */

public class MP4_WarmUp {
    public static void main(String[] args) {
        final var PROMPT_FORMAT = "My name is %s\nI am %d years old\nDuring Spring Break I slept for an average of %.2f hours per day and was online for %.2f hours\nThe 3 things I enjoyed most were %s, %s, and %s\n";
        var firstName = "Aaron";
        var lastName = "Dill";
        var fullName = firstName + " " + lastName;
        long myAge = 16;
        float sleepHrs = 5;
        float onlineHrs = 8;
        List<String> mostEnjoyed = Arrays.asList("Sleeping", "Eating", "Not going to school");
        // PROMPT: The 3 things I enjoyed most were...
        List<Object> printfArgs = new ArrayList<>();
        printfArgs.addAll(Arrays.asList(fullName, myAge, sleepHrs, onlineHrs));
        printfArgs.addAll(mostEnjoyed);
        System.out.printf(PROMPT_FORMAT, printfArgs.toArray());
    }
}
