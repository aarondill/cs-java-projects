import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Synonyms {
  static Map<String, List<String>> syns = new HashMap<>();

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Synonyms.class.getResourceAsStream("./synonyms.dat"))) {
      int lineCount = dataScanner.nextInt();
      dataScanner.nextLine();
      List<List<String>> lines = new ArrayList<>(lineCount);
      for (int i = 0; i < lineCount; i++) {
        List<String> words = new ArrayList<>();
        for (String word : dataScanner.nextLine().split("\\s+"))
          words.add(word);
        lines.add(words);
      }
      int synCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < synCount; i++) {
        List<String> res = new ArrayList<>();
        for (String word : dataScanner.nextLine().split("\\s+"))
          res.add(word);
        String word = res.get(0);
        syns.put(word, res);
      }
      for (List<String> words : lines) {
        for (String word : words) {
          List<String> wordSyns = syns.get(word);
          if (wordSyns != null) System.out.print(wordSyns.remove(0));
          else System.out.print(word);
          System.out.print(" ");
        }
        System.out.println();
      }
      System.out.println();
    }

  }
}
