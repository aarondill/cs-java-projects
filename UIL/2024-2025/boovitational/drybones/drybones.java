import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class drybones {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "drybones.dat";

  private static void each(Scanner scan) {
    int t = scan.nextInt();
    int n = scan.nextInt();
    System.out.println(t * n);
    System.out.println("I'm gonna get so much candy!");
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
