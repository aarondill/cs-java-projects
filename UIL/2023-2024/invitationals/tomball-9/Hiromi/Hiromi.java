import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Hiromi {
  private static boolean solved(List<List<Integer>> board) {
    for (int x = 0; x < board.size(); x++) {
      Set<Integer> seen = new HashSet<Integer>();
      var column = board.get(x);
      for (int y = 0; y < column.size(); y++) {
        int num = column.get(y);
        if (seen.contains(num)) return false;
        seen.add(num);
      }
    }
    for (int y = 0; y < board.get(0).size(); y++) {
      Set<Integer> seen = new HashSet<Integer>();
      for (int x = 0; x < board.size(); x++) {
        var row = board.get(x);
        int num = row.get(y);
        if (seen.contains(num)) return false;
        seen.add(num);
      }
    }

    for (int x = 1; x < board.size(); x += 3) {
      for (int y = 1; y < board.get(0).size(); y += 3) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int xi = -1; xi < 1; xi++) {
          for (int yi = -1; yi < 1; yi++) {
            int num = board.get(x + xi).get(y + yi);
            if (seen.contains(num)) return false;
            seen.add(num);
          }
        }
      }
    }
    return true;
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Hiromi.class.getResourceAsStream("./hiromi.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        dataScanner.nextLine();
        List<List<Integer>> board = new ArrayList<>();
        for (int x = 0; x < 9; x++) {
          List<Integer> row = new ArrayList<>();
          board.add(row);
          for (int y = 0; y < 9; y++)
            row.add(dataScanner.nextInt());
          dataScanner.nextLine();
        }
        System.out.println("Puzzle #" + (i + 1) + ": " + solved(board));
      }
    }

  }
}
