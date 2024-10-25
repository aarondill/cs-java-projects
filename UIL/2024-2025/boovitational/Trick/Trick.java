import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trick {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "trick.dat";

  private static void each(Scanner scan) {
    while (scan.hasNextLine()) {
      Scanner line = new Scanner(scan.nextLine());
      String first = line.next();
      boolean firstB = false;
      if (first.equals("not")) {
        firstB = true;
        first = "";
      }
      String tmp = "";
      while (!(tmp = line.next()).equals("AND") && !tmp.equals("OR")) {
        first += " " + tmp;
      }
      if (tmp.equals("AND")) tmp = "OR";
      else tmp = "AND";

      String second = line.next();
      boolean secondB = false;
      if (second.equals("not")) {
        secondB = true;
        second = "";
      }
      while (line.hasNext()) {
        second += " " + line.next();
      }
      System.out.print("not (");
      if (!firstB) System.out.print("not ");
      System.out.print(first.trim() + " " + tmp + " ");

      if (!secondB) System.out.print("not ");
      System.out.println(second.trim() + ")");

    }
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
