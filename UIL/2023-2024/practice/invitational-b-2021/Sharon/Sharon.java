import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Primary java class: Sharon
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    12/04/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class Sharon {
  /**
   * Plays a game and returns the winner's name. Each game, start from 0 and count
   * C players. The selected player is eliminated and begining from the next
   * player, count C more players eliminating the selected player. When the end of
   * players is reached, loop to player 0 and continue counting. The winner is the
   * last player in the list.
   *
   * @param C The 'cicle number'
   * @param players The names of the players.
   */
  private static String play(int C, String[] players) {
    ArrayList<String> playersList = new ArrayList<>(Arrays.asList(players));
    int i = 0;
    while (playersList.size() > 1) {
      // C - 1 because you need to count the first player.
      i = (i + C - 1) % playersList.size();
      playersList.remove(i);
    }
    return playersList.get(0);
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Sharon.class.getResourceAsStream("./sharon.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        int C = dataScanner.nextInt();
        int P = dataScanner.nextInt();
        // Use substring(1) to remove the first character, which is a space.
        String[] players = dataScanner.nextLine().substring(1).split(" ");
        if (players.length != P) throw new IllegalArgumentException("Players length does not match P.");
        System.out.printf("The winner is %s\n", play(C, players));
      }
    }
  }
}
