import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Saim {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "saim.dat";

  static int win, loss, draw;

  // The constructor is called on each case
  private Saim(Scanner scan) {
    String p1Name = scan.next();
    String p2Name = scan.next();
    int numMoves = scan.nextInt();
    if (scan.hasNextLine()) scan.nextLine();

    Player p1 = moves.get(p1Name);
    Player p2 = moves.get(p2Name);
    int p1Health = p1.health();
    int p2Health = p2.health();
    if (numMoves > 0) {
      String[] p1Moves = scan.nextLine().split(" ");
      String[] p2Moves = scan.nextLine().split(" ");
      boolean p1Block = false, p2Block = false;
      boolean p1double = false, p2double = false;
      for (int turn = 0; turn < numMoves; turn++) {
        p1double = false;
        p1Block = false;
        String p1Move = p1Moves[turn];
        switch (p1Move) {
          case "RT" -> {
            if (!p2Block) p2Health -= (p2double ? 2 : 1) * p1.rt();
          }
          case "LT" -> p1Block = true;
          case "RB" -> {
            if (!p2Block) p2Health -= (p2double ? 2 : 1) * p1.rb();
            p1double = true;
          }
          case "LB" -> p1Health += p1.lb();
          default -> throw new IllegalArgumentException("WHAT???!");
        }
        if (p1Health <= 0 || p2Health <= 2) break;

        p2double = false;
        p2Block = false;
        String p2Move = p2Moves[turn];
        switch (p2Move) {
          case "RT" -> {
            if (!p1Block) p1Health -= (p1double ? 2 : 1) * p2.rt();
          }
          case "LT" -> p2Block = true;
          case "RB" -> {
            if (!p1Block) p1Health -= (p1double ? 2 : 1) * p2.rb();
            p2double = true;
          }
          case "LB" -> p2Health += p2.lb();
          default -> throw new IllegalArgumentException("WHAT???!");
        }
        if (p2Health <= 0 || p1Health <= 1) break;
      }
    }

    if (p1Health <= 0) {
      System.out.println("Saim");
      loss++;
    } else if (p2Health <= 0) {
      System.out.println("You");
      win++;
    } else {
      System.out.println("Draw");
      draw++;
    }

  }

  static Map<String, Player> moves = Map.of("A", new Player(100, 200, 40, 1000), "B", new Player(100, 260, 20, 1500),
      "C", new Player(120, 220, 50, 800), "D", new Player(80, 150, 80, 1000));

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Saim(scan);
      System.out.printf("%d-%d-%d\n", win, draw, loss);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

record Player(int rt, int rb, int lb, int health) {}
