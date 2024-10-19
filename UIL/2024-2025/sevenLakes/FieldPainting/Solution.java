import java.util.Scanner;

public class Solution {
  private static int[] mostWhite(char[][] field) {
    int maxWhite = 0;
    int[] maxPosition = new int[] {-1, -1};
    for (int i = 0; i < field.length - 1; i++) {
      for (int j = 0; j < field[i].length - 1; j++) {
        char[] block = new char[] {field[i][j], field[i][j + 1], field[i + 1][j], field[i + 1][j + 1]};
        int count = 0;
        for (char c : block)
          if (c == '.') count++;
        if (count > maxWhite) {
          maxWhite = count;
          maxPosition[0] = i;
          maxPosition[1] = j;
        }
      }
    }
    return maxPosition;
  }

  private static void each(Scanner scan) {
    // Parse the input:
    int rows = scan.nextInt(), cols = scan.nextInt();
    scan.nextLine();
    char[][] field = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      String line = scan.nextLine();
      for (int j = 0; j < cols; j++)
        field[i][j] = line.charAt(j);
    }
    int steps = 0;
    while (true) {
      int[] maxPosition = mostWhite(field);
      if (maxPosition[0] == -1 && maxPosition[1] == -1) break;
      int i = maxPosition[0], j = maxPosition[1];
      steps++;
      field[i][j] = '#';
      field[i + 1][j] = '#';
      field[i][j + 1] = '#';
      field[i + 1][j + 1] = '#';
    }
    System.out.println(steps);
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++)
        each(scan);
    }
  }
}
