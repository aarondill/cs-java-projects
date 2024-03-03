/**
 * Primary java class: Alice
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
public class Alice {
  private static String indent(int count) {
    return " ".repeat(count);
  }

  public static void main(String... args) {
    System.out.println(indent(11) + "&");
    System.out.println(indent(11) + "&&");
    System.out.println(indent(11) + "&&&");
    System.out.println(indent(11) + "&&-&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(3) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(4) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(1) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(2) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(3) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(4) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(5) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(6) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(7) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(8) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(9) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(10) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(11) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(12) + "-".repeat(2) + "&");
    System.out.println(indent(11) + "&&" + "-".repeat(2) + ".".repeat(13) + "-".repeat(2) + "&");
    System.out.println(indent(12) + "||" + indent(19) + "\\o/");
    System.out.println(indent(12) + "||" + indent(20) + "|");
    System.out.println(indent(1) + "=".repeat(38));
    System.out.println(indent(3) + "=".repeat(34));
    System.out.println("^".repeat(40));

  }
}
