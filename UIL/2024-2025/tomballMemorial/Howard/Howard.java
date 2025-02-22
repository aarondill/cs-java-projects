import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Howard {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "howard.dat";

  private static void each(Scanner scan) {
    int dataCount = Integer.parseInt(scan.nextLine(), 10);
    List<Player> ps = new ArrayList<>();
    for (int i = 0; i < dataCount; i++, caseNum++) {// Parse the input:
      int jNum = scan.nextInt();
      String name = scan.next();
      Pos pos = Pos.valueOf(scan.next());
      double pts = scan.nextDouble(), apg = scan.nextDouble(), fga = scan.nextDouble(), fta = scan.nextDouble(),
          tpg = scan.nextDouble();
      scan.nextLine();
      double ts = pts / (2 * (fga + .44 * fta));
      double ratio = apg / tpg;
      Player p = new Player(name, pos, jNum, ts, ratio);
      ps.add(p);
    }
    ps.sort(null);
    Pos pg = null;
    outer: for (Player p : ps) {
      while (p.pos() == pg)
        continue outer;
      pg = p.pos();
      System.out.printf("%s: %d. %s\n", p.pos(), p.jNum(), p.name());
    }
    // Handle output:
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

enum Pos {
  PG, SG, SF, PF, C
}

record Player(String name, Pos pos, int jNum, double ts, double ratio) implements Comparable<Player> {
  @Override
  public int compareTo(Player p) {
    int c;
    c = pos.compareTo(p.pos);
    if (c != 0) return c;
    c = Double.compare(p.ts, ts);
    if (c != 0) return c;
    c = Double.compare(p.ratio, ratio);
    return c;
  }
}
