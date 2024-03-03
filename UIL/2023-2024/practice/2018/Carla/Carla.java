import java.util.Scanner;

/**
 * Primary java class: Carla
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
public class Carla {
  private static String parse_perms(String perms) {
    String res = "";
    String type = perms.charAt(0) + "";
    if (type.equals("F"))
      res += '-';
    else
      res += type.toLowerCase();

    char[] perm_types = { 'r', 'w', 'x' };
    for (char c : perms.substring(1).toCharArray()) {
      int perm_int = Integer.parseInt(c + "", 8);

      String bin_string = (Integer.toBinaryString(perm_int) + "0".repeat(3)).substring(0, 3);
      for (int i = 0; i < bin_string.length(); i++) {
        if (bin_string.charAt(i) == '1')
          res += perm_types[i];
        else
          res += '-';

      }
    }
    return res;

  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(Carla.class.getResourceAsStream("./carla.dat"))) {
      while (scan.hasNextLine()) {
        String perms = scan.nextLine();
        System.out.println(parse_perms(perms));
      }
    }
  }
}
