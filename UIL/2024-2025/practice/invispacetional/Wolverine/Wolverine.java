import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Wolverine {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "wolverine.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String[] input = scan.nextLine().split("/");
    LocalDate date = LocalDate.of(Integer.parseInt(input[2]), Integer.parseInt(input[0]), Integer.parseInt(input[1]));
    char mode = scan.next().charAt(0);
    int distance = scan.nextInt();
    scan.nextLine();
    date = switch (mode) {
      case 'D' -> date.plusDays(distance);
      case 'M' -> date.plusMonths(distance);
      case 'Y' -> date.plusYears(distance);
      default -> throw new IllegalArgumentException("Invalid mode: " + mode);
    };
    String m = date.getMonth().toString();
    m = m.substring(0, 1) + m.substring(1).toLowerCase();
    System.out.printf("%s %02d, %04d\n", m, date.getDayOfMonth(), date.getYear());

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
