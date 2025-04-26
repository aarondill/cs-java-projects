import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cole {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "cole.dat";

  // The constructor is called on each case
  private Cole(Scanner scan) {
    // int machineCount = scan.nextInt();
    // int goalCount = scan.nextInt();
    // Map<String, Resource> names = new HashMap<>();
    // for (int i = 0; i < machineCount; i++) {
    //   String name = scan.next().transform(s -> s.substring(0, s.length() - 1)); // remove ,
    //   String frac = scan.next().transform(s -> s.substring(0, s.length() - 1));
    //
    // }
    // for (int i = 0; i < dataCount; i++, caseNum++)
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      new Cole(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

record Resource(String name, double perTick, Map<Resource, Integer> deps) {};
