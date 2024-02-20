import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Feng
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 08, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * For each test case, output the corresponding angle measures each of the two
 * hands would be
 * pointing to. Hour angle (denoted as H_Angle below) and minute angle (denoted
 * as M_Angle) will be
 * guaranteed to be in range of [0,359]. Formatting for the output should be
 * ”Hour: H_Angle Minute:
 * M_Angle”
 */
public class Feng {
    private static class Angles {
        Angles(double hour, double minute) {
            this.hour = hour;
            this.minute = minute;
        }

        double hour;
        double minute;
    }

    private static double getAnglesFromParts(double part, double segments) {
        double angle = 90.0 - ((360.0 / segments) * part);
        double positiveAngle = (angle + 360) % 360;
        return positiveAngle;
    }

    private static Angles getAngles(String time) {
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        double hourAngle = getAnglesFromParts(hours + (minutes / 60.0), 12);
        double minuteAngle = getAnglesFromParts(minutes, 60);
        return new Angles(hourAngle, minuteAngle);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./feng.dat"));
        int testCases = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            String time = dataScanner.nextLine();
            Angles angles = getAngles(time);
            System.out.printf("Hour: %.1f Minute: %.1f\n", angles.hour, angles.minute);
        }
    }
}
