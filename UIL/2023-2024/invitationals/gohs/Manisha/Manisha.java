import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Primary java class: Manisha
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/03/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Manisha {
  private static List<String> sort(List<String> grades) {
    grades.sort((x, y) -> x.replaceAll("\\/", "").compareTo(y.replaceAll("\\/", "")));

    for (int i = 0, j = 0; i < grades.size(); i++) {
      j = i;
      while (j < grades.size() && grades.get(j).contains("/"))
        j++;
      if (i == j) continue;
      j--; // j doens't contain /
      var gradesArr = grades.toArray(String[]::new);
      Arrays.sort(gradesArr, i, j + 1, (x, y) -> {
        int xs = x.indexOf("/");
        int ys = y.indexOf("/");
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        if (xs == -1) return 1;
        if (ys == -1) return -1;
        return xs == ys ? 0 : xs > ys ? -1 : 1;
      });
      for (int m = i; m < j; m++)
        grades.set(m, gradesArr[m]);

      System.out.println("run: " + i + " " + j);
      i = j;
    }
    return grades;
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Manisha.class.getResourceAsStream("./manisha.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        List<String> grades = new ArrayList<String>();
        Arrays.stream(dataScanner.nextLine().split("\\+")).map(s -> s.replaceAll("\s+", "")).map(s -> {
          return String.valueOf(s.chars().boxed().sorted((x, y) -> {
            return x == '/' || y == '/' ? 0 : Integer.compare(x, y);
          }).map(x -> "" + (char) x.intValue()).collect(Collectors.joining()));
        }).forEach(grades::add);
        System.out.println(sort(grades));
      }
    }

  }
}
