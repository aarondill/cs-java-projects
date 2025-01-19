import java.io.File;
import java.io.FileNotFoundException;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Jason {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "jason.dat";

  static final List<Integer> daysInMonths = List.of(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

  private static void each(Scanner scan) {
    // Parse the input:
    List<Integer> averages = new ArrayList<>();
    for (int daysInMonth : daysInMonths) {
      double average = IntStream.range(0, daysInMonth).mapToDouble(n -> scan.nextDouble()).average().getAsDouble();
      averages.add((int) average);
    }

    int heighest = averages.stream().max(Integer::compareTo).get();
    for (int n = heighest; n >= 0; n--) {
      for (int average : averages) {
        if (average >= n) System.out.print("*****");
        else System.out.print("     ");
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println(" Jan   Feb   Mar   Apr   May   Jun   Jul   Aug   Sep   Oct   Nov   Dec");
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
