import java.util.ArrayList;
import java.util.Scanner;

public class Ella {
  private static void each(ArrayList<Integer> frogsLocations, int[] dayMovement) {
    int max = Integer.MIN_VALUE;
    for (int x : dayMovement) {
      int count = 0;
      for (int i = 0; i < frogsLocations.size(); i++) {
        int frog = frogsLocations.get(i);
        // System.out.printf("\nfrog: %d, x: %d, count: %d\n", frog, x, count);
        if (frog <= x && frog > max) {
          count++;
        }
      }
      System.out.print(count + " ");
      max = Math.max(x, max);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(Ella.class.getResourceAsStream("./ella.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int days = dataScanner.nextInt();
        int frogs = dataScanner.nextInt();
        int[] dayMovement = new int[days];
        ArrayList<Integer> frogsLocations = new ArrayList<Integer>();
        for (int j = 0; j < days; j++)
          dayMovement[j] = dataScanner.nextInt();
        for (int j = 0; j < frogs; j++)
          frogsLocations.add(dataScanner.nextInt());

        each(frogsLocations, dayMovement);
      }
    }
  }
}
