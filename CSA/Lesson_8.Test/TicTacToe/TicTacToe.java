import java.util.Scanner;

/**
 * class TicTacToe
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    4/5/2024
 * Course:  Computer Science I AP
 * </pre>
 *
 * Summary of file: Drive the GameGrid class to play tic-tac-toe. Prompts for
 * names and commands from stdin. Outputs prompts for input to stdout
 */
class TicTacToe {
  static String x, o; // player names
  static boolean turnX = true; // The current player is X. (X plays first)

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) { // Input through stdin
      System.out.println("Who will be playing this game? (Player 1 is always X.)");
      System.out.println("Player 1:");
      x = scan.nextLine().trim();
      System.out.println("Player 2:");
      o = scan.nextLine().trim();

      GameGrid g = new GameGrid();
      while (true) { // input loop
        System.out.printf("%s it is your turn:\n", turnX ? x : o);
        System.out.println("Enter the row then column of where you would like to play:");
        int row = scan.nextInt(), col = scan.nextInt();
        while (!g.validPlay(row, col)) {
          System.out.println("That is not a valid play.");
          System.out.println("Enter the row and column again:");
          row = scan.nextInt();
          col = scan.nextInt();
        }
        g.play(turnX, row, col);
        System.out.println(g); // Print the state of the board
        System.out.println(); // blank line
        if (g.winner()) {
          System.out.printf("%s is the winner!\n", turnX ? x : o);
          break;
        } else if (g.draw()) {
          System.out.println("The game is a draw!"); // This output is undefined in the program specifications
          break;
        }
        turnX = !turnX;
      }
    }
  }
}
