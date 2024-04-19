/**
 * class GameGrid
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    4/5/2024
 * Course:  Computer Science I AP
 * </pre>
 *
 * Summary of file: Handle state of TicTacToe board
 */
public class GameGrid {

  /**
   * Field named grid initialized to all spaces.
   *
   * Valid values are: "X", "O", or null;
   *
   * @implNote: hard coded to 3x3
   */
  private String[][] grid = new String[3][3];

  /** Default constructor. */
  public GameGrid() {}

  /**
   * Places an X or an O in the appropriate grid space. <br>
   * Precondition: {@link validPlay}(r, c) == true
   *
   * @param x true if player1 false if player2
   * @param r row
   * @param c column
   */
  public void play(boolean x, int r, int c) {
    grid[r][c] = x ? "X" : "O";
  }

  public void clear() {
    grid = new String[grid.length][grid[0].length];
  }

  // Check rows
  public boolean winnerHorizontal() {
    outer: for (String[] row : grid) {
      for (String pos : row)
        if (pos == null || !pos.equals(row[0])) continue outer;
      return true; // if the previous for-loop terminated, all positions on this row are the same.
    }
    return false;
  }

  // Check cols - note: requires a square array
  public boolean winnerVertical() {
    outer: for (int col = 0; col < grid[0].length; col++) {
      for (int row = 0; row < grid.length; row++)
        if (grid[row][col] == null || !grid[row][col].equals(grid[0][col])) continue outer;
      return true; // if the previous for-loop terminated, all positions on this col are the same.
    }
    return false;
  }

  // Check diagonals - note: requires a square array
  // Check (0,0) -> (2,2)
  public boolean winnerDiagonalTopLeftBottomRight() {
    for (int i = 0; i < grid.length; i++) {
      if (grid[i][i] != null && grid[i][i].equals(grid[0][0])) continue;
      return false;
    }
    return true;
  }

  // Check diagonals - note: requires a square array
  // Check (2,0) -> (0,2)
  public boolean winnerDiagonalTopRightBottomLeft() {
    for (int i = 0; i < grid.length; i++) { // i is the row
      String pos = grid[i][grid[i].length - 1 - i];
      if (pos != null && pos.equals(grid[0][grid[0].length - 1])) continue;
      return false;
    }
    return true;
  }

  /** @return true if the current game state results in a winner. */
  public boolean winner() {
    return winnerHorizontal() || winnerVertical() || winnerDiagonalTopLeftBottomRight()
        || winnerDiagonalTopRightBottomLeft();
  }

  /**
   * @return true if the game ended in a draw.
   */
  public boolean draw() {
    // Any empty space means it's not a draw
    for (String[] row : grid)
      for (String pos : row)
        if (pos == null) return false;
    return true;
  }

  /**
   * @param r row
   * @param c column
   * @return true if r and c are within the game grid and (r,c) is not occupied.
   */
  public boolean validPlay(int r, int c) {
    return r < grid.length && c < grid[r].length && grid[r][c] == null;
  }

  /**
   * Returns a string representing the current state of the game grid using the
   * format shown in the problem statement.
   */
  public String toString() {
    String[] out = new String[grid.length];
    int idx = 0; // An index into the output array
    for (String[] row : grid) {
      String output = "|";
      for (String pos : row)
        output += (pos == null ? " " : pos) + "|";
      out[idx++] = output;
    }
    // Note: requires a square array
    // Each cell needs 2 dashes, plus an extra at the end
    String sep = "-".repeat(2 * grid[0].length + 1);
    String[] lines = new String[out.length * 2 + 1];
    idx = 0; // An index into the lines array (now)
    lines[idx++] = sep;
    for (String s : out) {
      lines[idx++] = s;
      lines[idx++] = (sep);
    }
    return String.join("\n", lines);
  }

}
