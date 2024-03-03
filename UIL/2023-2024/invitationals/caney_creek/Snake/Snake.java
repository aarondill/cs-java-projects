import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake {
  public static final int WIDTH = 15;
  public static final int HEIGHT = 15;
  public static final int SNAKE_LEN = 3;

  public static void main(String... args) {
    List<String> moves = new ArrayList<>(), lines = new ArrayList<>();
    try (Scanner dataScanner = new Scanner(Snake.class.getResourceAsStream("./snake.dat"))) {
      for (int y = 0; y < HEIGHT; y++)
        lines.add(dataScanner.nextLine());
      int moveLines = Integer.parseInt(dataScanner.nextLine());
      for (int i = 0; i < moveLines; i++)
        moves.add(dataScanner.nextLine());
    }

    Board<Space> b = new Board<>(WIDTH, HEIGHT);
    int snakeX = -1, snakeY = -1;
    for (int y = 0; y < HEIGHT; y++) {
      int snakeLen = 0; // Note: Snake can only begin horizontally
      Space[] spaces = Space.parse(lines.get(y));
      for (int x = 0; x < WIDTH; x++) {
        b.add(x, switch (spaces[x]) {
          case Snake -> {
            if (++snakeLen == SNAKE_LEN) {
              snakeX = x;
              snakeY = y;
            }
            yield Space.Empty;
          }
          default -> spaces[x];
        });
      }
    }
    for (String move : moves) {
      SnakeImpl snake = new SnakeImpl(snakeX, snakeY, b);
      String status = snake.move(Direction.parse(move)) ? snake.eaten + " pellets" : "GAME OVER!";
      System.out.println(status);
    }
  }

}
