import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Class Nandita
 *
 * <pre>
 * Author1: Aaron Dill
 * Date:	March 25, 2023
 * </pre>
 *
 * Summary of file:
 * output the dates given in multiple formats
 */
public class Nandita {
    final static private DateFormat DATE_PARSER = DateFormat.getDateInstance();
    final static private SimpleDateFormat MIDDLE_ENDIAN = new SimpleDateFormat("MM/dd/YY");
    final static private SimpleDateFormat LITTLE_ENDIAN = new SimpleDateFormat("dd.MM.YYYY");
    final static private SimpleDateFormat BIG_ENDIAN = new SimpleDateFormat("YYYY-MM-dd");

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(Nandita.class.getResourceAsStream("./nandita.dat"));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Date d = DATE_PARSER.parse(line);
            System.out.println(MIDDLE_ENDIAN.format(d));
            System.out.println(LITTLE_ENDIAN.format(d));
            System.out.println(BIG_ENDIAN.format(d));
            System.out.println("=====");
        }
    }
}
