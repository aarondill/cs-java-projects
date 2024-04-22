import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sveta {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "sveta.dat";

  private static List<Integer> fromLine(String line) {
    line = line.substring(line.indexOf(":") + 2);
    if (line.equals("n/a")) return new ArrayList<>();
    return new ArrayList<>(Arrays.asList(line.split(",")).stream().map(Integer::parseInt).toList());
  }

  private static void each(Scanner scan) {
    // Parse the input:
    int bitCount = Integer.parseInt(scan.nextLine().substring(5));
    List<Integer> setOne = fromLine(scan.nextLine());
    List<Integer> setZero = fromLine(scan.nextLine());
    List<Integer> invert = fromLine(scan.nextLine());
    scan.nextLine(); // dashes
    // Handle output:
    if (setOne.isEmpty() && setZero.isEmpty() && invert.isEmpty()) {
      throw new IllegalArgumentException("Invalid input (all empty!)");
    }
    // bad checking
    String message = "This can not be done with a single bitwise operator.";
    if (!setOne.isEmpty()) {
      if (!invert.isEmpty() || !setZero.isEmpty()) {
        System.out.println(message);
        return;
      }
    } else if (!setZero.isEmpty()) {
      if (!invert.isEmpty() || !setOne.isEmpty()) {
        System.out.println(message);
        return;
      }
    } else if (!invert.isEmpty()) {
      if (!setOne.isEmpty() || !setZero.isEmpty()) {
        System.out.println(message);
        return;
      }
    }

    List<Integer> maskBits = null;
    String op = null;
    if (!setOne.isEmpty()) {
      maskBits = setOne;
      op = "|";
    } else if (!setZero.isEmpty()) {
      maskBits = setZero;
      op = "&";
    } else {
      maskBits = invert;
      op = "^";
    }

    List<Integer> bits = new ArrayList<>(bitCount);
    for (int i = 0; i < bitCount; i++)
      bits.add(op.equals("&") ? 1 : 0);

    for (int bit : maskBits) {
      bits.reversed().set(bit, op.equals("&") ? 0 : 1);
      // System.out.println(bit + " mask: " + bits);
    }
    String mask =
        Long.toHexString(Long.parseLong(bits.stream().map(String::valueOf).collect(Collectors.joining("")), 2));
    System.out.println("opnd " + op + " " + mask.toUpperCase());

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
