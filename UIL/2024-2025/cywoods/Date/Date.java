import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class Date {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "date.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int m = scan.nextInt();
    int d = scan.nextInt();
    int y = scan.nextInt();
    if (scan.hasNextLine()) scan.nextLine();

    Calendar c = Calendar.getInstance();
    c.set(y, m - 1, d);
    int dow = c.get(Calendar.DAY_OF_WEEK);
    int last = -1;
    if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) last = 31;
    else if (m == 4 || m == 6 || m == 9 || m == 11) last = 30;
    else if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) last = 29;
    else last = 28;

    if (dow >= 2 && dow <= 6 && d == last) System.out.println("TODAY IS THE DAY!");
    else System.out.println("NO ROBBING!");
    // Handle output:
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
