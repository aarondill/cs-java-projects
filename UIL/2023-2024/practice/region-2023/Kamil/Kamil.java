import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kamil {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "kamil.dat";

  private static String rev(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  private static void each(Scanner scan) {
    // Parse the input:
    List<String> words = new ArrayList<>(Arrays.asList(scan.nextLine().split("\\s+")));
    // Handle output:
    words.sort((a, b) -> rev(a).compareToIgnoreCase(rev(b)));
    System.out.println(String.join(" ", words));
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
