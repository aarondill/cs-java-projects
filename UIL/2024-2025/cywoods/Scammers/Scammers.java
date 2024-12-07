import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scammers {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "scammers.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String message = "";
    String name = null;

    String[] line = scan.nextLine().split(":", 2);
    name = line[0];
    message += line[1].length() > 0 ? line[1].substring(1) : "";
    String tmp;
    while (scan.hasNextLine() && !(tmp = scan.nextLine()).equals("")) {
      message += tmp;
    }

    message = message.toLowerCase();
    char[] lets = {'s', 'c', 'a', 'm'};
    int i = 0;
    for (char c : message.toCharArray()) {
      if (c == lets[i]) i++;
      if (i == lets.length) break;
    }
    if (i == lets.length) {
      System.out.println(name + " is a scammer!");
    } else {
      System.out.println(name + " is safe to text.");
    }

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
