import java.util.Objects;

class SnakeImpl {
  public int x;
  public int y;
  public Direction direction;
  public int eaten = 0;
  // ListX<ListY<Space>> so board.get(x).get(y) is the coord (x, y)
  // (0, 0) is top left corner!
  Board<Space> board;

  public SnakeImpl(int x, int y, Board<Space> board) {
    if (x < 0 || y < 0) throw new IllegalStateException("Invalid snake position: " + x + ", " + y);
    this.x = x;
    this.y = y;
    this.board = board.clone();
  }

  public boolean move(Direction[] dirs) {
    for (Direction d : dirs) {
      if (!this.move(d)) return false;
    }
    return true;
  }

  private boolean eat() {
    this.eaten++;
    this.board.set(x, y, Space.Empty);
    return true;
  }

  public boolean move(Direction d) {
    switch (d) {
      case Up -> this.y--; // y=0 is top row
      case Down -> this.y++; // y=n is bottom row
      case Left -> this.x--; // x=0 is left row
      case Right -> this.x++; // x=n is right row
      case Onward -> {
        return move(Objects.requireNonNull(this.direction, "Can't continue without a previous direction!"));
      }
    }
    this.direction = d;
    if (!board.validIndex(x, y)) return false;
    return switch (board.get(x, y)) {
      case Food -> eat();
      default -> true;
    };
  }
}
