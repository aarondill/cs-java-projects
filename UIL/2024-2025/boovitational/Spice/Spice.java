import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Alternative {
  String ingred;
  List<String> subs;
  int counter = 0;

  public Alternative(String ingred, List<String> subs) {
    this.subs = new ArrayList<>(subs);
    this.ingred = ingred;
  }
}

public class Spice {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "spice.dat";

  private static void each(Scanner scan) {
    for (var a : spices) {
      a.counter = 0;
    }
    int numIngred = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < numIngred; i++) {
      String[] line = scan.nextLine().split(" ");
      for (int j = 0; j < line.length - 1; j++)
        System.out.print(line[j] + " ");

      String name = line[line.length - 1];
      for (var a : spices) {
        if (a.ingred.equals(name)) {
          name = a.subs.get(a.counter);
          a.counter++;
          break;
        }
      }
      System.out.println(name);
    }
    System.out.println();
  }

  static int numSpices;
  static List<Alternative> spices = new ArrayList<>();

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      numSpices = scan.nextInt();
      scan.nextLine();
      for (int i = 0; i < numSpices; i++) {
        String name = scan.next();
        String[] alternatives = scan.nextLine().trim().split(" ");
        Alternative ingred = new Alternative(name, Arrays.asList(alternatives));
        spices.add(ingred);
      }

      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
