import java.util.ArrayList;
import java.util.Scanner;

/**
 * Primary java class: Eugene
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    12/04/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Eugene {

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Eugene.class.getResourceAsStream("./eugene.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      ArrayList<String> names = new ArrayList<>();
      for (int i = 0; i < dataCount; i++) {
        names.add(dataScanner.nextLine());
      }

      ArrayList<String> ids = new ArrayList<>();
      for (String name : names) {
        char first = name.charAt(0);
        char last = name.split(" ")[1].charAt(0);
        int generated = (int) last + ((int) first) * 100;
        while (ids.contains("" + first + last + generated)) {
          generated += 100;
        }
        ids.add("" + first + last + generated);
      }
      for (int i = 0; i < names.size(); i++) {
        String name = names.get(i);
        System.out.println(name + " " + ids.get(i).toLowerCase());
      }

    }
  }
}
