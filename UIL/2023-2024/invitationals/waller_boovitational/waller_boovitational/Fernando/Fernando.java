import java.util.Scanner;

public class Fernando {
  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(Fernando.class.getResourceAsStream("./fernando.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int n = dataScanner.nextInt();
        int[] daysArr = new int[n];
        for (int j = 0; j < n; j++)
          daysArr[j] = dataScanner.nextInt();
        System.out.print(daysArr[0] + " ");
        if (daysArr.length > 1)
          System.out.print(daysArr[0] + daysArr[1] + " ");
        for (int j = 2; j < daysArr.length; j++)
          System.out.print(daysArr[j - 2] + daysArr[j - 1] + daysArr[j] + " ");
        System.out.println();

      }
    }
  }
}
