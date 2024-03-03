import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * Primary java class: Svetlana
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/03/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Svetlana {
  private enum Piece {
    red, red_king, black, black_king, none,
  }

  static int num = 1;

  private static void each(Piece[][] board) {
    int red_count = 0;
    int black_count = 0;
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        try {
          switch (board[x][y]) {
            case red:
              if (board[x + 1][y + 1] == Piece.none) red_count++;
              if (board[x - 1][y + 1] == Piece.none) red_count++;
              break;
            case red_king:
              if (board[x + 1][y + 1] == Piece.none) red_count++;
              if (board[x - 1][y + 1] == Piece.none) red_count++;
              if (board[x + 1][y - 1] == Piece.none) red_count++;
              if (board[x - 1][y - 1] == Piece.none) red_count++;
              break;
            case black:
              if (board[x + 1][y - 1] == Piece.none) black_count++;
              if (board[x - 1][y - 1] == Piece.none) black_count++;
              break;
            case black_king:
              if (board[x + 1][y + 1] == Piece.none) black_count++;
              if (board[x - 1][y + 1] == Piece.none) black_count++;
              if (board[x + 1][y - 1] == Piece.none) black_count++;
              if (board[x - 1][y - 1] == Piece.none) black_count++;
              break;
            case none:
              break; // die inside
          }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
          // no.
        }

      }
    }
    System.out.println("Test case: " + (num++));
    System.out.println("Red valid single moves: " + red_count);
    System.out.println("Black valid single moves: " + black_count);

  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Svetlana.class.getResourceAsStream("./svetlana.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        dataScanner.nextLine();
        Piece[][] board = new Piece[8][8];
        for (int y = 0; y < board.length; y++) {
          for (int x = 0; x < board[y].length; x++) {
            char c = dataScanner.next().charAt(0);
            board[y][x] = switch (c) {
              case 'r' -> Piece.red;
              case 'R' -> Piece.red_king;
              case 'b' -> Piece.black;
              case 'B' -> Piece.black_king;
              default -> Piece.none;
            };
          }
        }
        each(board);
        dataScanner.nextLine();

      }
    }
  }
}
