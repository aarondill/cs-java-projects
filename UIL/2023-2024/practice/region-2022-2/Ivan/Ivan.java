import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ivan {
  private static int caseNum = 1;
  private static final String INPUT_FILE = "ivan.dat";
  private static String[] key;

  private static void each(Scanner scan) {
    // Parse the input:
    String[] qs = scan.nextLine().split("");
    // Handle output:
    int score = 0;
    int answered = 0;
    int correctCount = 0;
    for (int i = 0; i < qs.length; i++) {
      if (qs[i].equals("_")) continue;
      answered++;
      if (qs[i].equals(key[i])) {
        score += 6;
        correctCount++;
      } else score -= 2;
    }
    double percent = (double) correctCount / answered * 100.0;
    if (answered == 0) percent = 0;
    System.out.printf("Exam #%d: %d %.1f\n", caseNum, score, percent);

  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      key = scan.nextLine().split("");
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
