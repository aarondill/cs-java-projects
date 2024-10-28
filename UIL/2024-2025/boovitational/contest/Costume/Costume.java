import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class Contestent implements Comparable<Contestent> {
  public int score;
  public String name;

  public int compareTo(Contestent c) {
    return score - c.score;
  }

  public Contestent(int score, String name) {
    this.score = score;
    this.name = name;
  }

}

public class Costume {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "costume.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int numContest = scan.nextInt();
    scan.nextLine();
    List<Contestent> contestents = IntStream.range(0, numContest).mapToObj(i -> {
      String name = scan.nextLine();
      int score = scan.nextInt() + scan.nextInt() + scan.nextInt() + scan.nextInt() + scan.nextInt();
      if (scan.hasNextLine()) scan.nextLine();
      return new Contestent(score, name);
    }).sorted(Comparator.reverseOrder()).toList();

    IntStream.range(0, contestents.size())
        .mapToObj(i -> String.format("%d. (%2d) - %s", i + 1, contestents.get(i).score, contestents.get(i).name))
        .forEach(System.out::println);
    System.out.println("----------------");
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
