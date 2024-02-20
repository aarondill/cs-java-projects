import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Kathleen {
  private static void each(String[] cities, Set<String> flights) {
    boolean suc = true;
    if (!(cities.length == 1 && flights.size() == 0)) {
      for (String c : cities) {
        if (!flights.contains(c)) {
          suc = false;
          break;
        }
      }
    }
    System.out.println(suc ? "Yes" : "No");
  }

  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(Kathleen.class.getResourceAsStream("./kathleen.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int listCount = dataScanner.nextInt();
        int flightCount = dataScanner.nextInt();

        String[] cities = new String[listCount];
        Set<String> flights = new HashSet<String>();

        for (int j = 0; j < listCount; j++)
          cities[j] = dataScanner.next();
        for (int j = 0; j < flightCount * 2; j++)
          flights.add(dataScanner.next());
        each(cities, flights);

      }
    }
  }
}
