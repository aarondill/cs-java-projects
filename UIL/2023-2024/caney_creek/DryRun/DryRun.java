import java.util.Scanner;

public class DryRun {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(DryRun.class.getResourceAsStream("./dryrun.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        System.out.println("I like " + dataScanner.nextLine() + ".");
        // Do Some Stuff
      }
    }
  }
}
