import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dorian {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "dorian.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String s = scan.nextLine();
    int lineLen = 0;
    ArrayList<Integer> splitPos = new ArrayList<>();
    splitPos.add(0);
    for (int i = 0; i < s.length() - 1; i++) {
      String two = s.substring(i, i + 2);
      if (two.matches("\\w\\s")) splitPos.add(i + 1);
    }
    splitPos.add(s.length());
    ArrayList<String> output = new ArrayList<>();
    for (int i = 0; i < splitPos.size() - 1; i++) {
      output.add(s.substring(splitPos.get(i), splitPos.get(i + 1)));
    }
    for (String o : output) {
      lineLen += o.length();
      if (lineLen > 89) {
        System.out.print("\n      ");
        lineLen = 6;
        o = o.stripLeading();
        lineLen += o.length();
      }
      System.out.print(o);
    }

    System.out.println();
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      while (scan.hasNextLine())
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
