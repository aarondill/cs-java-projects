import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Wanted {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "wanted.dat";

  private static void each(Scanner scan) {
    int numpeople = scan.nextInt();
    Set<Criminal> ps = new TreeSet<>(); // Natural ordering!
    for (int i = 0; i < numpeople; i++) {
      String[] parts;
      ps.add(new Criminal(scan.next(), // NOTE: The order of these fields is very important
          Rank.valueOf(scan.next()), //
          scan.nextInt(), //
          scan.nextDouble(), //
          scan.nextInt(), //
          LocalDate.of( //
              Integer.parseInt( //
                  (parts = scan.next().split("/"))[2] //
              ), //
              Integer.parseInt(parts[0]), //
              Integer.parseInt(parts[1]) //
          ) //
      ));
    }
    int i = 1;
    System.out.println("Most WANTED:");
    for (Criminal c : ps)
      System.out.printf("%d. %s\n", i++, c.name());
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

enum Rank {
  Kingpin, Underboss, Captain, Operative, Affiliate,
}

record Criminal(String name, Rank rank, int numCrimes, double strength, int caughtTimes, LocalDate dob)
    implements Comparable<Criminal> {
  @Override
  public int compareTo(Criminal o) {
    if (this.name.equals("Steven")) return -1;
    if (o.name.equals("Steven")) return 1;
    if (this.name.equals("Nikhil")) return 1;
    if (o.name.equals("Nikhil")) return -1;
    if (this.rank != o.rank) return this.rank.ordinal() - o.rank.ordinal();
    if (this.numCrimes != o.numCrimes) return -(this.numCrimes - o.numCrimes);
    if (this.strength != o.strength) return (int) (-this.strength + o.strength);
    if (this.caughtTimes != o.caughtTimes) return (this.caughtTimes - o.caughtTimes);
    if (!this.dob.equals(o.dob)) return this.dob.compareTo(o.dob);
    return this.name.compareTo(o.name);
  }

}
