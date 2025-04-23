import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Conrad {
  private static final String INPUT_FILE = "conrad.dat";

  // The constructor is called on each case
  private Conrad(Scanner scan) {
    String word = scan.nextLine();
    long uniqueDiffs = IntStream.range(0, word.length() - 1).map(i -> Math.abs(word.charAt(i) - word.charAt(i + 1)))
        .distinct().count();
    System.out.println(uniqueDiffs == 1 ? word : "BAD!!!");

  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        new Conrad(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
