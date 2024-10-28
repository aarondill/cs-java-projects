import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Confcostumes {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "confcostumes.dat";

  private static void each(Scanner scan) {
    int numPeople = Integer.parseInt(scan.nextLine());
    List<List<String>> people = IntStream.range(0, numPeople).mapToObj(i -> {
      scan.nextLine(); // num of costumes
      return Arrays.asList(scan.nextLine().split(" "));
    }).toList();
    if (isValid(people, Collections.emptySet())) System.out.println("Everyone's happy!");
    else System.out.println("Someone's out of luck!");
  }

  // Recursive algorithm to choose a each chostume for the first person, then check if the rest of the people can be assigned
  // No duplicates are allowed
  // NOTE: This works (brute force), but is susceptible to timeout or stack overflow
  private static boolean isValid(List<List<String>> remaining, Set<String> chosen) {
    if (remaining.isEmpty()) return true;
    // make copies of input
    remaining = new LinkedList<>(remaining);
    chosen = new HashSet<>(chosen);

    List<String> first = remaining.remove(0);
    for (int i = 0; i < first.size(); i++) {
      String costume = first.get(i);
      if (chosen.contains(costume)) continue;
      chosen.add(costume);
      if (isValid(remaining, chosen)) return true;
      chosen.remove(costume);
    }
    // we're out of outfits for this person, so we can't assign them
    return false;
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
