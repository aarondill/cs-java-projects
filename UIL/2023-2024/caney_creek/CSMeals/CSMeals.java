import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSMeals {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(CSMeals.class.getResourceAsStream("./csmeals.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int len = dataScanner.nextInt();
        dataScanner.nextLine();
        List<String> need = new ArrayList<>();
        List<String> has = new ArrayList<>();
        for (int j = 0; j < len; j++)
          Arrays.stream(dataScanner.nextLine().split(" ")).forEach(need::add);
        for (int j = 0; j < len; j++)
          Arrays.stream(dataScanner.nextLine().split(" ")).forEach(has::add);
        if (need.stream().sorted().toList().equals(has.stream().sorted().toList())) {
          System.out.println("OK");
        } else if (need.size() > has.size()) { // buy more
          need.removeAll(has);
          System.out.println("BUY MORE " + String.join(" ", need));
        } else { // put back
          has.removeAll(need);
          System.out.println("PUT BACK " + String.join(" ", has));
        }
      }
    }

  }
}
