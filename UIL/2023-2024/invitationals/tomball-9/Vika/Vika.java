import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vika {
  private static Set<String> subsets(String str) {
    Set<String> set = new HashSet<String>();
    if (str.length() == 0) return set;
    char initial = str.charAt(0);
    var sub = subsets(str.substring(1));
    set.add(initial + "");
    set.addAll(sub);
    sub.stream().map(s -> initial + s).forEach(set::add);
    return set;
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Vika.class.getResourceAsStream("./vika.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        String one = dataScanner.next();
        String two = dataScanner.next();
        var twoSub = subsets(two);
        int max = 0;
        for (String s : subsets(one)) {
          if (twoSub.contains(s)) max = Math.max(max, s.length());
        }
        System.out.println(max);

      }
    }

  }
}
