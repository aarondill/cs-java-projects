import java.util.Scanner;

// Perform a binary search over 0 to max to find the target.
public class Arya {
  public static void main(String... args) {
    int max, target;
    try (Scanner dataScanner = new Scanner(Arya.class.getResourceAsStream("./arya.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      outer: for (int i = 0; i < dataCount; i++) {
        max = dataScanner.nextInt();
        target = dataScanner.nextInt();
        dataScanner.nextLine();
        int left = 1;
        int right = max;
        while (left <= right) {
          int mid = left + (right - left) / 2;
          System.out.printf("%d-%d-%d\n", left, mid, right);
          if (target == mid) {
            System.out.println("GOT IT!!!");
            continue outer;
          } else if (target < mid) {
            right = mid - 1;
          } else {
            left = mid + 1;
          }
        }

      }
    }
  }
}
