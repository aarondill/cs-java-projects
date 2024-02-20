import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Primary java class: Dhruv
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/02/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Dhruv {
  static Map<Integer, String> stationCallSigns = new HashMap<>();
  static List<Integer> stations = new ArrayList<>();

  private static String radio(int station) {
    if (station < 535 || station > 1605) return "BAD INPUT";
    int nearest = stations.get(0);
    for (int s : stations) {
      if (Math.abs(s - station) <= Math.abs(nearest - station)) nearest = s;
    }
    return stationCallSigns.get(nearest);

  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(Dhruv.class.getResourceAsStream("./dhruv.dat"))) {
      for (int i = 0; i < 8; i++) {
        String sign = scan.next();
        int s = scan.nextInt();
        stationCallSigns.put(s, sign);
        stations.add(s);
      }
      stations.sort(null);

      int dataCount = scan.nextInt();
      scan.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int station = scan.nextInt();
        System.out.println(radio(station));
      }
    }
  }
}
