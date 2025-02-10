import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Danger {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "danger.dat";

  private static void each(Scanner scan) {
    Map<LocalTime, String> timeMap = new HashMap<>();
    int dataCount = Integer.parseInt(scan.nextLine(), 10);
    for (int i = 0; i < dataCount; i++) {
      String[] data = scan.nextLine().split(" ");
      String name = data[1];
      LocalTime time = LocalTime.parse(data[0]);
      timeMap.put(time, name);
    }
    List<LocalTime> sorted = timeMap.keySet().stream().sorted().toList();
    for (LocalTime time : sorted) {
      System.out.println(time + " " + timeMap.get(time));
    }
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
