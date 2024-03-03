import java.util.Scanner;

public class DryRun {
  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(DryRun.class.getResourceAsStream("./dryrun.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      String res = "";
      for (int i = 0; i < dataCount; i++) {
        res += dataScanner.nextLine();

      }
      System.out.println(res);
    }
  }
}
