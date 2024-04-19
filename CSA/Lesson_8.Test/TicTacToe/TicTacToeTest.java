import java.util.Arrays;

public class TicTacToeTest {
  public static void main(String[] args) {
    boolean assertOn = false;
    assert assertOn = true;
    if (!assertOn) throw new AssertionError("Please make sure to pass -ea on the command line!");
    GameGrid g = new GameGrid();
    for (boolean x : new boolean[] {true, false}) {
      // Vertical
      for (int col = 0; col < 3; col++) {
        g.clear();
        g.play(x, 0, col);
        g.play(x, 1, col);
        g.play(x, 2, col);
        assert g.winnerVertical() : "winnerVertical works";
        assert !g.winnerHorizontal() : "winnerHorizontal works";
        assert !g.winnerDiagonalTopLeftBottomRight() : "winnerDiagonalTopLeftBottomRight works";
        assert !g.winnerDiagonalTopRightBottomLeft() : "winnerDiagonalTopRightBottomLeft works";
        assert !g.draw() : "draw works";
        assert g.winner() : "winner() works";
      }

      // Horizontal
      for (int row = 0; row < 3; row++) {
        g.clear();
        g.play(x, row, 0);
        g.play(x, row, 1);
        g.play(x, row, 2);
        assert !g.winnerVertical() : "winnerVertical works";
        assert g.winnerHorizontal() : "winnerHorizontal works";
        assert !g.winnerDiagonalTopLeftBottomRight() : "winnerDiagonalTopLeftBottomRight works";
        assert !g.winnerDiagonalTopRightBottomLeft() : "winnerDiagonalTopRightBottomLeft works";
        assert !g.draw() : "draw works";
        assert g.winner() : "winner() works";
      }

      // DiagonalTopLeftBottomRight
      {
        g.clear();
        for (int i = 0; i < 3; i++)
          g.play(x, i, i);
        assert !g.winnerVertical() : "winnerVertical works";
        assert !g.winnerHorizontal() : "winnerHorizontal works";
        assert g.winnerDiagonalTopLeftBottomRight() : "winnerDiagonalTopLeftBottomRight works";
        assert !g.winnerDiagonalTopRightBottomLeft() : "winnerDiagonalTopRightBottomLeft works";
        assert !g.draw() : "draw works";
        assert g.winner() : "winner() works";
      }

      // DiagonalTopRightBottomLeft
      {
        g.clear();
        for (int i = 0; i < 3; i++)
          g.play(x, i, 3 - 1 - i);
        assert !g.winnerVertical() : "winnerVertical works";
        assert !g.winnerHorizontal() : "winnerHorizontal works";
        assert !g.winnerDiagonalTopLeftBottomRight() : "winnerDiagonalTopLeftBottomRight works";
        assert g.winnerDiagonalTopRightBottomLeft() : "winnerDiagonalTopRightBottomLeft works";
        assert !g.draw() : "draw works";
        assert g.winner() : "winner() works";
      }
    }

    // Test draw
    {
      g.clear();
      String s = """
          oxo
          xxo
          xox""";
      char[] chars = s.replaceAll("\\s+", "").toCharArray();
      for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
          char c = chars[row * 3 + col];
          g.play(c == 'x', row, col);
          assert !g.winnerVertical() : "winnerVertical works";
          assert !g.winnerHorizontal() : "winnerHorizontal works";
          assert !g.winnerDiagonalTopLeftBottomRight() : "winnerDiagonalTopLeftBottomRight works";
          assert !g.winnerDiagonalTopRightBottomLeft() : "winnerDiagonalTopRightBottomLeft works";
          assert !g.winner() : "winner() works";
          if (row != 2 || col != 2) assert !g.draw() : "draw works";
        }
      }
      assert g.draw() : "draw works";
    }

  }
}
