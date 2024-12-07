import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Rober implements Comparable<Rober> {
  int money;
  String name;

  public Rober(int money, String name) {
    this.money = money;
    this.name = name;
  }

  public int compareTo(Rober r) {
    return r.money - money;
  }
}

public class Money {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "money.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    List<Rober> rs = new ArrayList<>();
    int count = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < count; i++) {
      String[] parts = scan.nextLine().split(", ");
      String name = parts[0];
      int money = Integer.parseInt(parts[1]);
      rs.add(new Rober(money, name));
    }
    Collections.sort(rs);
    if (rs.size() > 1 && rs.get(0).money == rs.get(1).money) {
      System.out.println("Multiple suspects stole the most money.");
    } else {
      System.out.println(rs.get(0).name + " has stolen the most money!");
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
