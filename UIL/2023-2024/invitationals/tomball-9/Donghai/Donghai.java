import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Donghai {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Donghai.class.getResourceAsStream("./donghai.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : dataScanner.nextLine().toCharArray()) {
          c = Character.toUpperCase(c);
          if (c < 'A' || c > 'Z') continue;
          map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : map.keySet())
          System.out.println(Character.toUpperCase(c) + ": " + map.get(c));
        System.out.println("==========");
      }
    }

  }
}
