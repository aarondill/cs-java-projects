import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Girish {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "girish.dat";

  private static void each(Scanner scan) {
    List<Double> means = new ArrayList<>();
    List<Double> sums = new ArrayList<>();
    Map<Long, Long> counts = new HashMap<>();
    Set<Long> possibleExtra = new HashSet<>();
    boolean isFirst = true;
    while (true) {
      String line = scan.nextLine();
      if (line.equals("----------")) break;
      List<Long> nums = Arrays.asList(line.split(" ")).stream().map(Long::parseLong).toList();
      long sum = nums.stream().mapToLong(x -> x).reduce(0, Long::sum);
      long total = nums.size();
      means.add((double) sum / total);
      sums.add((double) sum);
      for (long n : nums) {
        counts.put(n, counts.getOrDefault(n, 0l) + 1);
      }
      Set<Long> list = new HashSet<>();
      if (isFirst) {
        list.addAll(nums);
        isFirst = false;
      } else {
        for (long n : nums) {
          if (possibleExtra.contains(n)) list.add(n);
        }
      }
      possibleExtra = list;
    }
    means.sort(null);
    double median = means.size() % 2 == 0 ? (means.get(means.size() / 2 - 1) + means.get(means.size() / 2)) / 2
        : means.get(means.size() / 2);
    System.out.printf("Median Mean: %.2f\n", median);

    double sumSums = sums.stream().mapToDouble(x -> x).sum();
    double meanSum = sumSums / sums.size();
    System.out.printf("Mean Sum: %.2f\n", meanSum);

    var d = new ArrayList<>(counts.entrySet().stream().toList());
    d.sort((a, b) -> b.getValue().compareTo(a.getValue()));
    int i = 1;
    long mode = d.get(0).getKey();
    while (possibleExtra.contains(mode)) {
      mode = d.get(i++).getKey();
    }
    System.out.printf("Mode Kinda: %d\n", mode);

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
