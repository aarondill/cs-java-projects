import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

enum Space {
  Food, Empty
}

public class Snake {
  public static int x;
  public static int y;
  public static final int WIDTH = 15;
  public static final int HEIGHT = 15;
  static List<List<Space>> board = new ArrayList<>();

  static String direction = null;
  static int eaten = 0;

  private static void move(String m) {
    switch (m) {
      case "U":
        y++;
        break;
      case "D":
        y--;
        break;
      case "L":
        x--;
        break;
      case "R":
        x++;
        break;
      case "O":
        Objects.requireNonNull(direction, "Can't continue without direction!");
        move(direction);
        return;
    }
    direction = m;
    if (board.get(y).get(x) == Space.Food) {
      eaten++;
      board.get(y).set(x, Space.Empty);
    }
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Snake.class.getResourceAsStream("./snake.dat"))) {
      for (int y = 0; y < HEIGHT; y++) {
        char[] spaces = dataScanner.nextLine().toCharArray();
        List<Space> row = new ArrayList<>();
        board.add(row);
        int snakeLen = 0;
        for (int x = 0; x < spaces.length; x++) {
          char space = spaces[x];
          if (space == 'X') {
            snakeLen++;
            if (snakeLen == 3) {
              Snake.x = x;
              Snake.y = y;
            }
            row.add(Space.Empty);
          } else if (space == 'F') {
            row.add(Space.Food);
          } else {
            row.add(Space.Empty);
          }

        }
      }
      int moveLines = dataScanner.nextInt();
      dataScanner.nextLine();
      int xSaved = x, ySaved = y;
      for (int i = 0; i < moveLines; i++) {
        x = xSaved;
        y = ySaved;
        eaten = 0;
        direction = null;

        String line = dataScanner.nextLine();
        try {
          Arrays.stream(line.split("")).filter(s -> s.length() > 0).forEach(Snake::move);
        } catch (java.lang.IndexOutOfBoundsException e) {
          System.out.println("GAME OVER!");
          continue;
        }
        System.out.println(eaten + " pellets");
      }
    }

  }
}
