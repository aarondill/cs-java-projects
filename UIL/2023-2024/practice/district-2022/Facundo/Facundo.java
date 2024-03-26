import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Facundo {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "facundo.dat";

  private static String cut(String cards) {
    int mid = (int) Math.ceil((double) cards.length() / 2);
    List<String> a =
        new ArrayList<>((cards.substring(0, mid).chars().mapToObj(c -> "" + (char) c).collect(Collectors.toList())));
    List<String> b =
        new ArrayList<>((cards.substring(mid).chars().mapToObj(c -> "" + (char) c).collect(Collectors.toList())));
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < cards.length(); i++) {
      if (i % 2 == 0) sb.append(a.removeLast());
      else sb.append(b.removeFirst());
    }
    return sb.reverse().toString();
  }

  private static void each(Scanner scan) {
    // Parse the input:
    String line = scan.next();
    int i = scan.nextInt();
    // Handle output:
    for (int j = 0; j < i; j++) {
      line = cut(line);
      System.err.printf("line: %s, j: %d\n", line, j);
    }
    System.out.println(line);
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
