import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fernando {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "fernando.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int num = scan.nextInt();
    int digit = scan.nextInt();
    scan.nextLine();
    // find the factors of num
    List<String> factors = new ArrayList<>();
    for (int i = 1; i <= num; i++) {
      if (num % i == 0 && !String.valueOf(i).contains(String.valueOf(digit))) {
        factors.add(i + "");
      }
    }
    if (factors.size() == 0) {
      System.out.println("NONE");
    } else System.out.println(String.join(" ", factors));
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
