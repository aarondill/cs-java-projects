import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dominik {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "dominik.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    Map<String, Calendar> dates = new HashMap<>();
    int numDates = scan.nextInt();
    int numComparisons = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < numDates; i++) {
      String[] date = scan.next().split("/");
      String name = scan.nextLine().trim();
      Calendar c = Calendar.getInstance();
      c.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]) - 1, // NOTE: months are 0-index
          Integer.parseInt(date[2]));
      dates.put(name, c);
    }
    for (int i = 0; i < numComparisons; i++) {
      String[] events = scan.nextLine().split(":");
      Calendar a = dates.get(events[0]), b = dates.get(events[1]);
      long diff = Math.abs(a.getTimeInMillis() - b.getTimeInMillis());
      if (a.get(Calendar.YEAR) > 1582 ^ b.get(Calendar.YEAR) > 1582) {
        diff += 10 * (1000 * 60 * 60 * 24);
      }
      System.out.printf("%,.0f\n", (double) diff / (1000 * 60 * 60 * 24));

    }

    // Handle output:
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
