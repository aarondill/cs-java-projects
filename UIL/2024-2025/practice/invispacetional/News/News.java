import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class News {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "news.dat";

  final static List<String> threats = List.of("Thanos", "Galactus", "Kang", "Ultron", "Graviton");
  final static List<String> villains = List.of("Magneto", "Juggernaut", "Apocalypse", "Mystique", "Sentinels");

  private static void each(Scanner scan) {
    String line = scan.nextLine();
    if (threats.stream().anyMatch(line::contains)) System.out.println("Calling All Heroes.");
    else if (villains.stream().anyMatch(line::contains)) System.out.println("Sharpen Your Claws Wolverine.");
    else System.out.println("Business as Usual.");
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
