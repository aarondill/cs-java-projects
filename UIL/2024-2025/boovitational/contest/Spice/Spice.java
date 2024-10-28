import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

class Alternative {
  final String ingred;
  private final List<String> subs;

  public String get(int i) {
    return subs.get(i);
  }

  public Alternative(String ingred, List<String> subs) {
    this.subs = subs;
    this.ingred = ingred;
  }
}

public class Spice {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "spice.dat";

  private static void each(Scanner scan, List<Alternative> spices) {
    Map<Alternative, Integer> indicies = new HashMap<>(); // Keep track of the used ingredients for each alternative
    int numIngred = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < numIngred; i++) {
      List<String> line = Arrays.asList(scan.nextLine().split(" "));
      String name = line.getLast();
      spices.stream().filter(s -> name.equals(s.ingred)).findFirst().ifPresent(a -> {
        String sub = a.get(indicies.getOrDefault(a, 0));
        indicies.merge(a, 1, Integer::sum);
        line.set(line.size() - 1, sub);
      });
      System.out.println(String.join(" ", line));
    }
    System.out.println();
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int numSpices = scan.nextInt();
      scan.nextLine();
      List<Alternative> spices = IntStream.range(0, numSpices).mapToObj(i -> {
        List<String> words = Arrays.asList(scan.nextLine().split(" "));
        String name = words.getFirst();
        List<String> alternatives = words.subList(1, words.size());
        return new Alternative(name, alternatives);
      }).toList();

      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan, spices);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
