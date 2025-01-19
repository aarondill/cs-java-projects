import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dominik {
  private static final String INPUT_FILE = "dominik.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    Map<String, LocalDate> dates = new HashMap<>();
    int numDates = scan.nextInt(), numComparisons = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < numDates; i++) {
      Integer[] date = Arrays.stream(scan.next().split("/")).map(Integer::parseInt).toArray(Integer[]::new);
      String name = scan.nextLine().trim();
      LocalDate d = LocalDate.of(date[0], date[1], date[2]);
      dates.put(name, d);
    }
    for (int i = 0; i < numComparisons; i++) {
      LocalDate[] events = Arrays.stream(scan.nextLine().split(":")).map(dates::get).toArray(LocalDate[]::new);
      long days = Math.abs(ChronoUnit.DAYS.between(events[0], events[1]));
      System.out.printf("%,d\n", days);
    }
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
