import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Decoder {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "decoder.dat";

  private static void each(Scanner scan) {
    Stack<Character> st = new Stack<>();
    // Parse the input:
    Arrays.stream(scan.nextLine().split("\\s+")).map(s -> s.charAt(0)).forEach(c -> {
      // Handle output:
      switch (c) {
        case '%' -> {
          char top = st.pop();
          char bottom = st.pop();
          st.push(top);
          st.push(bottom);
        }
        case '1' -> st.pop();
        case '2' -> {
          char top = st.pop();
          st.pop(); // discard bottom
          st.push(top);
        }
        case '+' -> st.push(' ');
        default -> st.push(c);
      }
    });
    st.stream().map(Character::toUpperCase).map(String::valueOf).forEach(System.out::print);
    System.out.println();
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
