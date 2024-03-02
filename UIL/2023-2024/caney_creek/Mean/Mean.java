import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Mean {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Mean.class.getResourceAsStream("./mean.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      System.out.println("mean median mode");
      for (int i = 0; i < dataCount; i++) {
        List<Integer> nums = Arrays.stream(dataScanner.nextLine().split(" ")).map(Integer::parseInt)
            .collect(Collectors.toCollection(ArrayList::new));
        nums.sort(null);
        double mean = nums.stream().mapToInt(Integer::intValue).average().getAsDouble();
        double median;
        if (nums.size() % 2 == 1) median = nums.get(nums.size() / 2);
        else median = (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1)) / 2.0;
        Map<Integer, List<Integer>> stat = nums.stream().collect(Collectors.groupingBy(n -> n));
        double maxCount = -1;
        double mode = -1;
        for (var e : stat.entrySet()) {
          if (e.getValue().size() > maxCount) {
            mode = e.getKey();
            maxCount = e.getValue().size();
          }
        }
        System.out.printf("%4.1f %6.1f %4.1f\n", mean, median, mode);

      }
    }

  }
}
