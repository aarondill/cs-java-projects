import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Feng
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Date:	February 11, 2023
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
class Feng {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./feng.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            String time = dataScanner.nextLine();
            String hour = time.substring(0, 2);
            String minute = time.substring(3, 5);
            int hourInt = Integer.parseInt(hour);
            int minuteInt = Integer.parseInt(minute);

            double minuteAngle = minuteInt * 6;
            double hourAngle = hourInt * 30 + (minuteAngle / 12.0);

            double normalizedHourAngle = (360 + (90 - hourAngle)) % 360;
            double normalizedMinuteAngle = (360 + (90 - minuteAngle)) % 360;

            System.out.printf("Hour: %.1f Minute: %.1f\n", normalizedHourAngle,
                    normalizedMinuteAngle);
        }
    }
}
