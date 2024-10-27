import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    List<Contestent> contestents = new ArrayList<>(numContest);
    for (int i = 0; i < numContest; i++) {
      String name = scan.nextLine();
      int score = scan.nextInt() + scan.nextInt() + scan.nextInt() + scan.nextInt() + scan.nextInt();
      if (scan.hasNextLine()) scan.nextLine();
      Contestent c = new Contestent(score, name);
      contestents.add(c);
    }
    contestents.sort(null);
    contestents = contestents.reversed();
    for (int i = 0; i < numContest; i++) {
      Contestent c = contestents.get(i);
      System.out.printf("%d. (%2d) - %s\n", i + 1, c.score, c.name);
    }
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
