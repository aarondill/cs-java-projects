import java.util.Scanner;

public class Hellen {
  private static void each(boolean turb[], int days[]) {
    for (int i = 0; i < days.length; i++) {
      int k = days[i];
      for (int j = 0; j < turb.length; j++) {
        if ((j + 1) % k == 0)
          turb[j] = !turb[j];
      }
    }
    int count = 0;
    for (boolean state : turb) {
      if (state)
        count++;
    }
    System.out.println(count);

  }

  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(Hellen.class.getResourceAsStream("./hellen.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        boolean turb[] = new boolean[dataScanner.nextInt()];
        int days[] = new int[dataScanner.nextInt()];

        for (int j = 0; j < days.length; j++)
          days[j] = dataScanner.nextInt();
        for (int j = 0; j < turb.length; j++)
          turb[j] = true;

        each(turb, days);

      }
    }

  }
}
