import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

record Point(int x, int y) {
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}

public class Haru {
  private static int caseNum = 1;
  private static final String INPUT_FILE = "haru.dat";

  private static Point move(Point p, String instr) {
    var newP = switch (instr) {
      case "R" -> new Point(p.x() + 1, p.y());
      case "L" -> new Point(p.x() - 1, p.y());
      case "U" -> new Point(p.x(), p.y() + 1);
      case "D" -> new Point(p.x(), p.y() - 1);
      default -> throw new IllegalArgumentException("Invalid instruction: " + instr);
    };
    return newP;
  }

  static List<Point> spikes = new ArrayList<>(); // NOTE: locations less than zero and greater than 100 contain implicit spikes
  // Note, implicit spikes!

  private static boolean spike(Point p) {
    if (p.x() < 0 || p.x() > 100 || p.y() < 0 || p.y() > 100) {
      return true;
    }
    var has = spikes.contains(p);
    return has;
  }

  private static void addSpike(Point p) {
    spikes.add(p);
  }

  private static void each(Scanner scan) {
    spikes.clear(); // reset
    // Parse the input:
    // 1
    // 5 6 R
    // 6 6 L
    int turns = scan.nextInt(); // instruction length (string len)
    scan.nextLine();
    Point p1 = new Point(scan.nextInt(), scan.nextInt());
    List<String> p1instr = Arrays.asList(scan.next().split(""));
    scan.nextLine();
    Point p2 = new Point(scan.nextInt(), scan.nextInt());
    List<String> p2instr = Arrays.asList(scan.next().split(""));
    scan.nextLine();
    if (p1instr.size() != p2instr.size() || p1instr.size() != turns)
      throw new IllegalArgumentException("Invalid input! Sizes don't match. " + caseNum);
    // Handle output:
    for (int i = 0; i < turns; i++) { // both players move "at the same time"
      // Add spike at current location
      addSpike(p1);
      addSpike(p2);
      // Move players
      var p1new = move(p1, p1instr.get(i));
      var p2new = move(p2, p2instr.get(i));
      // check if collide (into the same space || going into each other's space)
      if (p1new.equals(p2new) || (p1new.equals(p2) && p2new.equals(p1))) {
        System.out.println("HEAD ON");
        return;
      }

      p1 = p1new;
      p2 = p2new;

      // Check if spike
      boolean p1Spike = spike(p1), p2Spike = spike(p2);
      if (!p1Spike && !p2Spike) continue;

      if (p1Spike && p2Spike) {
        System.out.println("DOUBLE SPIKE");
      } else if (p1Spike) {
        System.out.println("P2 WIN");
      } else if (p2Spike) {
        System.out.println("P1 WIN");
      }
      return;
    }
    System.out.println("DRAW");
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
