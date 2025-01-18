import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jason {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "jason.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    List<Integer> averages = new ArrayList<>();
    List<Integer> months = List.of(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

    for (int days : months) {
      double nums = 0;
      for (int i = 0; i < days; i++)
        nums += scan.nextDouble();
      double averageJan = nums / days;
      averages.add((int) Math.round(averageJan));
    }
    // System.out.println(averages);
    int heighest = (averages.stream().max(Integer::compareTo).get());
    while (heighest > 0) {
      for (int average : averages) {
        if (average >= heighest) System.out.print("*****");
        else System.out.print("     ");
        System.out.print(" ");
      }
      heighest--;
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
