import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kai {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "kai.dat";

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);

      String[] lines = ("""
           _ \s
          (*>\s
          //\\\s
          V_/_""").split("\n");
      for (String l : lines)
        System.out.println(l.repeat(dataCount));

    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
