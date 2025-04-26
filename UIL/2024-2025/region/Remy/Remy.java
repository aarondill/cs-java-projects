import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Remy {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "remy.dat";

  // The constructor is called on each case
  private Remy(Scanner scan) {
    List<String> ips = new ArrayList<>();
    Map<String, Integer> ipCount = new HashMap<>();
    Map<String, Integer> fileOccur = new HashMap<>();
    int errCount = 0;
    int total = 0;
    while (scan.hasNextLine()) {
      total++;
      scan.next(); // [date
      scan.next(); // time]
      String ip = scan.next();
      ips.add(ip);
      ipCount.merge(ip, 1, Integer::sum);
      scan.next(); // TYPE
      String file = scan.next();
      fileOccur.merge(file, 1, Integer::sum);
      int status = scan.nextInt();
      if (status >= 400 && status < 600) errCount++;
      if (scan.hasNextLine()) scan.nextLine();
    }
    double errRate = errCount / (double) total * 100;
    System.out.printf("Total requests: %d\n", total);
    System.out.println("Unique IP addresses: " + new HashSet<>(ips).size());
    var mostIp = ipCount.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get();
    System.out.printf("Most frequent IP address: %s (%d requests)\n", mostIp.getKey(), mostIp.getValue());
    System.out.printf("Error rate: %.2f%%\n", errRate);
    var mostFile = fileOccur.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get();
    System.out.printf("Most requested URL: %s (%d requests)\n", mostFile.getKey(), mostFile.getValue());

  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      new Remy(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
