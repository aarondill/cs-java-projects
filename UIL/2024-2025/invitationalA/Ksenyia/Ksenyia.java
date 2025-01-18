import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ksenyia {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "ksenyia.dat";

  static Set<String> prevUsedUsers = new HashSet<>();

  private static boolean userValid(String username) {
    if (username.length() < 8 || username.length() > 20) return false;
    if (!username.substring(0, 1).equals(username.substring(0, 1).toUpperCase())) return false;
    if (!username.matches("[0-9a-zA-Z]+")) return false;
    if (prevUsedUsers.contains(username)) return false;
    return true;
  }

  static Set<String> prevUsedPass = new HashSet<>();

  private static boolean passValid(String pass) {
    if (pass.length() < 10 || pass.length() > 30) return false;
    if (pass.matches(".*(.)\\1{2,}.*")) return false; // 3 or more dups
    if (pass.matches(".*\\s.*")) return false;
    if (!pass.matches(".*[0-9].*")) return false;
    if (!pass.matches(".*[A-Z].*")) return false;
    if (!pass.matches(".*[a-z].*")) return false;
    if (!pass.matches(".*[!@#$%^&*?+].*")) return false;

    if (prevUsedPass.contains(pass)) return false;
    return true;
  }

  private static void each(Scanner scan) {
    // Parse the input:
    String username = scan.nextLine();
    String pass = scan.nextLine();
    boolean userValid = userValid(username);
    boolean passValid = passValid(pass);
    if (userValid && passValid) {
      prevUsedUsers.add(username);
      prevUsedPass.add(pass);
      System.out.println("Valid");
    } else if (!userValid && !passValid) System.out.println("Both Invalid");
    else if (!passValid) System.out.println("Password Invalid");
    else if (!userValid) System.out.println("Username Invalid");
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
