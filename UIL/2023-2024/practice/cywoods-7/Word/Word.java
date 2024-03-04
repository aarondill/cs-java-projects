import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Word {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "word.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int wordCount = Integer.parseInt(scan.nextLine(), 10);
    List<String> words = new ArrayList<>(wordCount);
    for (int i = 0; i < wordCount; i++)
      words.add(scan.nextLine());
    // Handle output:
    System.out.println(words.stream().map(String::toLowerCase).filter(s -> s.contains("christmas")).count());
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
