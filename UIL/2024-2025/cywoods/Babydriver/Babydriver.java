import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Babydriver {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "babydriver.dat";
  final Type[][] grid;

  private Babydriver(Scanner scan) {
    // Parse the input:
    int height = scan.nextInt();
    int width = scan.nextInt();
    int testNumbers = scan.nextInt();
    if (scan.hasNextLine()) scan.nextLine();
    grid = new Type[height][width];
    Set<Point> exits = new HashSet<>();
    Set<Point> police = new HashSet<>();
    for (int y = 0; y < height; y++) {
      String row = scan.nextLine();
      for (int x = 0; x < width; x++) {
        switch (Type.fromChar(row.charAt(x))) {
          // Police are mobile, so replace them with a road; exits are fixed,
          // but allows to move onto, so replace them with road
          case EXIT -> exits.add(new Point(x, y));
          case POLICE -> police.add(new Point(x, y));
          case ROAD -> grid[y][x] = Type.ROAD;
          case WALL -> grid[y][x] = Type.WALL;
        }
        if (grid[y][x] == null) grid[y][x] = Type.ROAD; // Handle police and exits
      }
    }
    boolean hasNonRoad = Arrays.stream(grid).flatMap(Arrays::stream).anyMatch(t -> t != Type.ROAD && t != Type.WALL);
    if (hasNonRoad) throw new AssertionError("Police or Exit tile exists"); // These should've been filtered out

    MiniMax minimax = new MiniMax(grid, exits);
    final int MAX_DEPTH = 10;
    for (int i = 0; i < testNumbers; i++) {
      int y = scan.nextInt(), x = scan.nextInt();
      Point player = new Point(x, y);
      if (scan.hasNextLine()) scan.nextLine();
      // If there are no exits, we're cooked
      // NOTE: if there *are* exits, and no police, we may still be cooked if we're trapped by walls
      boolean canExit = !exits.isEmpty() && minimax.play(player, police, MAX_DEPTH);
      System.out.println(canExit ? "We're gonna make it out!" : "We're a little cooked.");
    }
    System.out.println();
  }
  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Babydriver(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}

record GameState(Point player, Set<Point> police, boolean playerTurn) {}

// Actually Alpha-Beta pruning: https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning
class MiniMax {

  private Set<Point> exits; // these don't move
  private Type[][] grid;
  private int width, height;

  public MiniMax(Type[][] grid, Set<Point> exits) {
    this.exits = exits;
    this.grid = grid;
    this.height = grid.length;
    if (height > 0) this.width = grid[0].length;
  }
  /**
   * Returns true if the player can reach one of the exits without being caught by
   * one of the police.
   */
  public boolean play(Point player, Set<Point> police, int maxDepth) {
    var best =
        alphaBeta(new GameState(player, police, true), maxDepth, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    System.out.println("best: " + best);
    return best == Double.POSITIVE_INFINITY; // We win if we get Infinity
  }
  /**
   * <code>
   * function alphabeta(node, depth, α, β, maximizingPlayer) is
   *   if depth == 0 or node is terminal then
   *       return the heuristic value of node
   *   if maximizingPlayer then
   *       value := −∞
   *       for each child of node do
   *           value := max(value, alphabeta(child, depth − 1, α, β, FALSE))
   *           if value ≥ β then
   *               break (* β cutoff *)
   *           α := max(α, value)
   *       return value
   *   else
   *       value := +∞
   *       for each child of node do
   *           value := min(value, alphabeta(child, depth − 1, α, β, TRUE))
   *           if value ≤ α then
   *               break (* α cutoff *)
   *           β := min(β, value)
   *       return value
   *       </code>
   */
  public double alphaBeta(GameState state, int maxDepth, double alpha, double beta) {
    if (maxDepth == 0 /* We've reached the depth limit */
        || exits.contains(state.player()) /* We've reached an exit */
        || state.police().contains(state.player()) /* We've reached a police */
    ) return heuristic(state);
    if (state.playerTurn()) {
      double value = Double.NEGATIVE_INFINITY;

      for (GameState child : (Iterable<GameState>) children(state)::iterator) {
        value = Math.max(value, alphaBeta(child, maxDepth - 1, alpha, beta));
        if (value >= beta) break;
        alpha = Math.max(alpha, value);
      }
      return value;
    } else {
      double value = Double.POSITIVE_INFINITY;
      for (GameState child : (Iterable<GameState>) children(state)::iterator) {
        value = Math.min(value, alphaBeta(child, maxDepth - 1, alpha, beta));
        if (value <= alpha) break;
        beta = Math.min(beta, value);
      }
      return value;
    }
  }
  private Stream<Point> validMoves(Point p) {
    return p.cardinals().stream().filter(q -> q.valid(width, height)).filter(q -> q.get(grid) != Type.WALL);
  }

  public Stream<GameState> children(GameState state) {
    // Aproximately: 4 possible moves for player or 4 possible moves for each police
    if (state.playerTurn()) { // Player moves this turn
      return validMoves(state.player()).map(p -> new GameState(p, state.police(), false));
    } else { // Opponent moves this turn
      // moves[i] is the list of points that police i can move to
      List<Set<Point>> moves = state.police().stream().map(p -> validMoves(p).collect(Collectors.toSet())).toList();
      // Each game state's police() is a permutation of the police's moves
      return getOpponentMoves(moves).map(police -> new GameState(state.player(), police, true));
    }
  }
  /*
   * Returns a list of all possible game states (in each state, every police picks one of it's moves)
   * This is a recursive function
   * @param possibleMoves: [[P1_1, P1_2, ..., P1_n], [P2_1, P2_2, ..., P2_n], ...] Where Pn is a given cop and Pn_i is a
   * possible move for cop n
   * @return [[P1_1, Pn_1, ..., Pn_1], [P1_1, P2_2, ..., Pn_1], ...] Where Pn is a given cop and Pn_i is a possible move
   * for cop n
   */
  private Stream<Set<Point>> getOpponentMoves(List<Set<Point>> policesMoves) {
    if (policesMoves.isEmpty()) return Stream.empty();
    if (policesMoves.size() == 1) return policesMoves.get(0).stream().map(Set::of); // If there's one cop, each move is a new state
    // get a list n^2 long of all possible game states (in each state, every police picks one of it's moves)
    // Remove the first police, then add the police to each index in the results
    Set<Point> police = policesMoves.get(0); // [P1_1, P2_2, ..., Pn_1]
    return getOpponentMoves(policesMoves.subList(1, policesMoves.size())).flatMap(newLocations -> {
      return police.stream() //
          .map(policeMove -> {
            Set<Point> newPossibleMoves = new HashSet<>(newLocations);
            newPossibleMoves.add(policeMove);
            return newPossibleMoves;
          });
    }).distinct();
  }

  public DoubleStream manhattan(Point p, Collection<Point> points) {
    return points.stream().mapToDouble(q -> Math.abs(p.x() - q.x()) + Math.abs(p.y() - q.y()));
  }
  /**
   * The heuristic value is a score measuring the favorability of the node for the maximizing player.
   * Let Dt be the Manhattan distance (number of squares) that Theseus is from the exit.
   * Let Dm be the Manhattan distance (number of squares) that the Minotaur is from Theseus.
   * Let T be 1 if it's Theseus turn and -1 if it's the Minotaur's.
   * If Dm is not zero and Dt is not zero, return Dm + (Dt/2)
   * If Dm is zero, return -Infinity
   * If Dt is zero, return Infinity
   */
  public double heuristic(GameState state) {
    // Distance to closest exit
    double dExit = manhattan(state.player(), exits).min().orElse(Double.POSITIVE_INFINITY);
    // Distance to closest police (average?)
    double dPolice = manhattan(state.player(), state.police()).min().orElse(Double.POSITIVE_INFINITY);
    // If dm is zero, player lost; if dt is zero, player won
    if (dPolice == 0 || dExit == 0) return dPolice == 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
    // We value escaping the police more than escaping the exit
    return dPolice + (dExit / 2);
  }

}

record Point(int x, int y) {

  public List<Point> cardinals() {
    return List.of(new Point(x, y + 1), new Point(x + 1, y), new Point(x, y - 1), new Point(x - 1, y));
  }
  public boolean valid(int width, int height) {
    return x >= 0 && x < width && y >= 0 && y < height;
  }

  public Point add(Point other) {
    return new Point(x + other.x, y + other.y);
  }

  public <T> T get(T[][] array) {
    return array[y][x];
  }
}

enum Type {
  ROAD('-'), WALL('#'), EXIT('E'), POLICE('P');

  final char ch;

  Type(char c) {
    this.ch = c;
  }
  public static Type fromChar(char c) {
    return Arrays.stream(values()).filter(t -> t.ch == c).findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid type: " + c));
  }
}
