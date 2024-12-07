import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Encrypt {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "encrypt.dat";

  private static void each(Scanner scan) {
    char[] key = scan.nextLine().toCharArray();
    String[] allPasswords = scan.nextLine().split("\\s+");

    List<String> encrypted = new ArrayList<>();
    for (String passwordS : allPasswords) {
      char[] password = passwordS.toCharArray();
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < password.length; i++) {
        int newChar = (password[i] - 'A') ^ (key[i] - 'A');
        if (newChar >= 26) newChar -= 26;
        else if (newChar < 0 && Math.abs(newChar) < 26) newChar = -newChar;
        else if (newChar < 0 && Math.abs(newChar) > 26) newChar = -newChar - 26;
        res.append((char) (newChar + 'A'));
      }
      encrypted.add(res.toString());
    }
    encrypted.sort(null);
    System.out.println(String.join(" ", encrypted));
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
