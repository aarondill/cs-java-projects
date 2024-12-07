import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

enum Rank {
  Kingpin, Underboss, Captain, Operative, Affiliate,
}

class Criminal implements Comparable<Criminal> {
  String name;
  Rank rank;
  int numCrimes;
  double strength;
  int caughtTimes;
  Calendar dob;

  public Criminal(String name, String rank, int numCrimes, double strength, int caughtTimes, Calendar dob) {
    this.dob = dob;
    this.name = name;
    this.rank = Rank.valueOf(rank);
    this.numCrimes = numCrimes;
    this.strength = strength;
    this.caughtTimes = caughtTimes;
  }

  @Override
  public int compareTo(Criminal o) {
    if (this.name.equals("Steven")) {
      return -1;
    }
    if (o.name.equals("Steven")) {
      return 1;
    }
    if (this.name.equals("Nikhil")) {
      return 1;
    }
    if (o.name.equals("Nikhil")) {
      return -1;
    }
    if (this.rank != o.rank) {
      return this.rank.ordinal() - o.rank.ordinal();
    }
    if (this.numCrimes != o.numCrimes) {
      return -(this.numCrimes - o.numCrimes);
    }
    if (this.strength != o.strength) {
      return (int) (-this.strength + o.strength);
    }
    if (this.caughtTimes != o.caughtTimes) {
      return (this.caughtTimes - o.caughtTimes);
    }
    if (!this.dob.equals(o.dob)) {
      return this.dob.compareTo(o.dob);
    }
    {
      return this.name.compareTo(o.name);
    }
  }

}

public class Wanted {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "wanted.dat";

  private static void each(Scanner scan) {
    int numpeople = scan.nextInt();
    List<Criminal> ps = new ArrayList<>();
    for (int i = 0; i < numpeople; i++) {
      Criminal self = new Criminal(scan.next(), scan.next(), scan.nextInt(), scan.nextDouble(), scan.nextInt(), null);
      Calendar c = Calendar.getInstance();
      String[] parts = scan.next().split("/");
      c.set(Integer.parseInt(parts[2]), Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
      self.dob = c;

      ps.add(self);
    }
    ps.sort(null);
    System.out.println("Most WANTED:");
    for (int i = 0; i < ps.size(); i++) {
      System.out.printf("%d. %s\n", i + 1, ps.get(i).name);
    }
    System.out.println("----------");
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
