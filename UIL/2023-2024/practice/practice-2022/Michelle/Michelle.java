import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Primary java class: Michelle
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/29/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Michelle {
  static int testCount = 1;

  private static void loop(ArrayList<Integer> desiredLengths, Map<Integer, Integer> wordLengths, int wordsCount) {
    desiredLengths.add(50);
    System.out.println("Test case #" + testCount++);
    int prev = 1;
    for (int len : desiredLengths) {
      int count = 0;
      for (int i = prev; i <= len; i++) {
        // System.out.println("len: " + i + " get:" + wordLengths.getOrDefault(i, 0));
        count += wordLengths.getOrDefault(i, 0);
      }
      int percent = (int) Math.round(((double) count / wordsCount) * 100);
      System.out.printf("%02d:%02d -> %-5d %s\n", prev, len, percent, "x".repeat(percent));
      prev = len + 1;
    }
    System.out.println("=".repeat(15));

  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Michelle.class.getResourceAsStream("./michelle.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        ArrayList<Integer> desiredLengths = new ArrayList<>();
        Map<Integer, Integer> wordLengths = new HashMap<>();
        String[] wordLengthsStrs = dataScanner.nextLine().split(" ");
        for (String wordLengthsStr : wordLengthsStrs)
          desiredLengths.add(Integer.parseInt(wordLengthsStr));

        String line = dataScanner.nextLine();
        int wordsCount = 0;
        while (!line.equals("#")) {
          for (String word : line.split(" ")) {
            wordsCount++;
            wordLengths.put(word.length(), wordLengths.getOrDefault(word.length(), 0) + 1);
          }
          line = dataScanner.nextLine();
        }
        loop(desiredLengths, wordLengths, wordsCount);

      }
    }
  }
}
