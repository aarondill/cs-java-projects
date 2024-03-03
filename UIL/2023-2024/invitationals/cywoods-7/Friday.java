import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Friday {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("friday.dat"));

        int numIn = in.nextInt();
        in.nextLine();
        for (int fun = 0; fun < numIn; fun++) {

            int month = in.nextInt();
            int date = in.nextInt();
            int year = in.nextInt();
            Date currentDate;


        }

    }

}
