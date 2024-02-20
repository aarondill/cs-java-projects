import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Primary java class: Max
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/20/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Max {
  static Map<String, String> alpha = new HashMap<>();
  static {
    alpha.put("A", "Alpha");
    alpha.put("B", "Bravo");
    alpha.put("C", "Charlie");
    alpha.put("D", "Delta");
    alpha.put("E", "Echo");
    alpha.put("F", "Foxtrot");
    alpha.put("G", "Golf");
    alpha.put("H", "Hotel");
    alpha.put("I", "India");
    alpha.put("J", "Juliett");
    alpha.put("K", "Kilo");
    alpha.put("L", "Lima");
    alpha.put("M", "Mike");
    alpha.put("N", "November");
    alpha.put("O", "Oscar");
    alpha.put("P", "Papa");
    alpha.put("Q", "Quebec");
    alpha.put("R", "Romeo");
    alpha.put("S", "Sierra");
    alpha.put("T", "Tango");
    alpha.put("U", "Uniform");
    alpha.put("V", "Victor");
    alpha.put("W", "Whiskey");
    alpha.put("X", "Xray");
    alpha.put("Y", "Yankee");
    alpha.put("Z", "Zulu");

    alpha.put("0", "Zero");
    alpha.put("1", "Wun");
    alpha.put("2", "Too");
    alpha.put("3", "Tree");
    alpha.put("4", "Fower");
    alpha.put("5", "Fife");
    alpha.put("6", "Six");
    alpha.put("7", "Seven");
    alpha.put("8", "Ait");
    alpha.put("9", "Niner");
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(Max.class.getResourceAsStream("./max.dat"))) {
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        System.out.println(Stream.of(line.split("")).map(alpha::get).collect(Collectors.joining(" ")));
      }

    }
  }
}
