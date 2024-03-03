import java.util.PriorityQueue;
import java.util.Scanner;

public class Cindy {
  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(Cindy.class.getResourceAsStream("./cindy.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      PriorityQueue<Integer> q = new PriorityQueue<>();
      for (int i = 0; i < dataCount; i++) {
        int n = dataScanner.nextInt(); // number bread
        int money = dataScanner.nextInt(); // money
        int count = 0;
        for (int j = 0; j < n; j++)
          q.add(dataScanner.nextInt());

        while (true) {
          if (q.isEmpty())
            break;
          Integer cost = q.remove();
          money = money - cost;
          if (money < 0)
            break;
          count++;
        }
        System.out.println(count);
      }
    }
  }
}
