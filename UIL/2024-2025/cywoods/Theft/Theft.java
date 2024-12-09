import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Theft {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "theft.dat";

  private static void each(Scanner scan) {
    int capacicty = scan.nextInt();
    int capacityCopy = capacicty;
    int items = scan.nextInt();
    scan.nextLine();
    List<Integer> weights = new ArrayList<>();
    List<Integer> prices = new ArrayList<>();

    for (int i = 0; i < items; i++)
      weights.add(scan.nextInt());
    scan.nextLine();
    for (int i = 0; i < items; i++)
      prices.add(scan.nextInt());
    scan.nextLine();
    List<String> objects = new ArrayList<>(Arrays.asList(scan.nextLine().split(", ")));
    List<String> objectsCopy = new ArrayList<>(objects);

    List<String> stolen = new ArrayList<>();

    int profit = 0;
    while (true) {
      double maxVal = Integer.MIN_VALUE;
      int maxI = Integer.MIN_VALUE;
      for (int i = 0; i < objects.size(); i++) {
        if ((double) prices.get(i) / weights.get(i) > maxVal && capacicty >= weights.get(i)) {
          maxVal = (double) prices.get(i) / weights.get(i);
          maxI = i;
        }
      }
      if (maxI == Integer.MIN_VALUE) break;
      capacicty -= weights.remove(maxI);
      profit += prices.remove(maxI);
      stolen.add(objects.remove(maxI));
    }
    System.out.println("Max Capacity: " + capacityCopy);
    System.out.println("Max Profit: $" + profit);
    if (profit == 0) System.out.println("Nothing could be stolen...");
    else {
      objectsCopy.removeAll(objects);
      System.out.println(String.join("\n", objectsCopy));

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
