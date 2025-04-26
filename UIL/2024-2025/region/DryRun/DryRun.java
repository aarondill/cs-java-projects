import java.util.Scanner;

public class DryRun {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(DryRun.class.getResourceAsStream("./dryrun.dat"))) {
      int dataCount = scan.nextInt();
      scan.nextLine();
      for (int i = 0; i < dataCount; i++) {
        System.out.println("I like " + scan.nextLine() + ".");
      }
    }

  }
}
