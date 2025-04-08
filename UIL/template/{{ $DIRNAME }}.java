:DELIMS tag="{{ }}" stmt="#@" comment="%#"
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class {{ $BASENAME }} {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "{{ ${BASENAME,} }}.dat";

  // The constructor is called on each case
  private {{$BASENAME}}(Scanner scan) {
    // Parse the input:
    scan.nextLine();
    // Handle output:
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new {{$BASENAME}}(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
