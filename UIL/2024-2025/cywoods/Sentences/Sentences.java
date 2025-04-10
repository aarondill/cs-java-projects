import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sentences {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "sentences.dat";

  private static void each(Scanner scan) {
    int numpeople = scan.nextInt();
    scan.nextLine();
    List<Integer> crimes = new ArrayList<>();
    String[] crimesNames = scan.nextLine().split(" ");
    for (String c : crimesNames) {
      int time = Integer.parseInt(c.split("-")[1]);
      crimes.add(time);
    }

    List<Criminal> personsss = new ArrayList<>();
    for (int i = 0; i < numpeople; i++) {
      String name = scan.next();
      int years = 0;
      for (int crime : crimes)
        years += scan.nextInt() * crime;
      personsss.add(new Criminal(name, years));
    }
    personsss.sort(null);
    for (Criminal crim : personsss) {
      if (crim.years() == 1) {
        System.out.println(crim.name() + " will serve " + crim.years() + " year!");
      } else if (crim.years() != 0) {
        System.out.println(crim.name() + " will serve " + crim.years() + " years!");
      } else System.out.println(crim.name() + " is innocent.");
    }
    System.out.println();

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

record Criminal(String name, int years) implements Comparable<Criminal> {
  public int compareTo(Criminal o) {
    return name.compareTo(o.name);
  }
}
