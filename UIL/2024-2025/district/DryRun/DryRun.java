import java.util.Scanner;

public class DryRun {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(DryRun.class.getResourceAsStream("./dryrun.dat"))) {
      int i = scan.nextInt();
      scan.nextLine();
      while (i-- > 0)
        System.out.println("I like " + scan.nextLine() + ".");
    }
  }
}
