import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

record Candy(String name, int price, int avail) implements Comparable<Candy> {
  public int compareTo(Candy c) {
    return price - c.price;
  }

};

public class CandyStore {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "candy.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    int budget = scan.nextInt();
    int numCandy = scan.nextInt();
    scan.nextLine();
    List<String> names = new ArrayList<>(Arrays.asList(scan.nextLine().split(" ")));
    List<String> avail = new ArrayList<>(Arrays.asList(scan.nextLine().split(" ")));
    List<String> price = new ArrayList<>(Arrays.asList(scan.nextLine().split(" ")));

    List<Candy> candies = new ArrayList<>();
    for (int i = 0; i < names.size(); i++) {
      Candy c = new Candy(names.get(i), Integer.parseInt(price.get(i)), Integer.parseInt(avail.get(i)));
      candies.add(c);
    }
    candies.sort(null);
    int counter = 0;
    while (budget >= 0) {
      Candy cheapest = candies.remove(0);
      if (cheapest.price() > budget) break;
      budget -= cheapest.price();
      counter++;
      Candy newC = new Candy(cheapest.name(), cheapest.price(), cheapest.avail() - 1);
      if (newC.avail() != 0) candies.add(0, newC);

      if (candies.size() == 0) break;
    }
    System.out.println(counter);
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
