import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Party {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "party.dat";

  private static void each(Scanner scan) {
    double sum = 0;
    while (scan.hasNextLine()) {
      double p = scan.nextDouble();
      double n = scan.nextInt();
      sum += p * n;
    }
    System.out.println((int) Math.ceil(sum));
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
