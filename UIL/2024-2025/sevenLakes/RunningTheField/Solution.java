import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
  private enum Space {
    EMPTY, DEFENDER;

    public static Space parse(int c) {
      return c == '.' ? EMPTY : DEFENDER;
    }
  }

  private static void each(Scanner scan) {
    // Parse the input:
    scan.nextInt(); // num spaces
    scan.nextInt(); // Num defenders
    int energy = scan.nextInt();
    scan.nextLine();
    List<Space> spaces = scan.nextLine().chars().mapToObj(Space::parse).collect(Collectors.toList());

    List<Integer> defenderStrengths = Arrays.stream(scan.nextLine().split(" ")).filter(s -> !s.isBlank())
        .map(Integer::parseInt).collect(Collectors.toList());
    // Handle output:
    int usedEnergy = 0;

    int i;
    for (i = spaces.size() - 1; i > 0; i--) {
      usedEnergy += switch (spaces.get(i)) {
        case EMPTY -> 1;
        case DEFENDER -> defenderStrengths.remove(defenderStrengths.size() - 1);
      };
      if (usedEnergy > energy) break;
    }
    System.out.println(i + 1);

  }

  public static void main(String... args) throws IOException {
    byte[] bytes = System.in.readAllBytes();
    byte[] fixed = new byte[bytes.length + 1];
    System.arraycopy(bytes, 0, fixed, 0, bytes.length);
    fixed[bytes.length] = '\n';

    try (Scanner scan = new Scanner(new String(fixed))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
