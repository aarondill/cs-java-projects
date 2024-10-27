import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Letter implements Comparable<Letter> {
  char let;
  int pos;

  public int compareTo(Letter o) {
    return let - o.let;
  }

  public Letter(int pos, char let) {
    this.pos = pos;
    this.let = let;
  }
}

public class Crypt {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "crypt.dat";

  private static void each(Scanner scan) {
    String first = scan.next().toUpperCase();
    String rest = scan.nextLine().trim();
    List<char[]> sentanceDec = new ArrayList<>();
    for (int i = 0; i < rest.length(); i++) {
      char c = rest.charAt(i);
      if (i % first.length() == 0) sentanceDec.add(new char[first.length()]);
      sentanceDec.get(i / first.length())[i % first.length()] = c;
    }

    List<Letter> lets = new ArrayList<>();
    for (char c : first.toCharArray())
      lets.add(new Letter(lets.size(), c));
    lets.sort(null);
    for (Letter a : lets) {
      int pos = a.pos;
      for (int i = 0; i < sentanceDec.size(); i++) {
        System.out.print(sentanceDec.get(i)[pos]);
      }
    }

    System.out.println();
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      while (scan.hasNextLine())
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
