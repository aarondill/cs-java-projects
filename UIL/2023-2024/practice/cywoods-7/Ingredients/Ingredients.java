import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ingredients {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "Ingredients.dat";

  private static void each(Scanner scan) {
    scan.nextLine(); // Note: first line is (#has, #recipe) - I don't need this, so discard it
    List<Integer> has = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).toList();
    List<Integer> recipe = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).toList();
    // Handle output:
    int special = recipe.get(0); // or `= 1`; It's unclear!
    // int special = 1; // or this. It's unclear from the examples/description!

    if (has.containsAll(recipe)) {
      if (has.contains(special)) System.out.println("Time to take a trip to the stratosphere!");
      else System.out.println("I guess it's time to have a normal brownie...");
    } else System.out.println(":(");

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
