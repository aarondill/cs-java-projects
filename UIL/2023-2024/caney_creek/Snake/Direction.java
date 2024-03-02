import java.util.List;

enum Direction {
  Up, Down, Left, Right, Onward;

  public static Direction parse(char c) {
    return switch (Character.toUpperCase(c)) {
      case 'U' -> Up;
      case 'D' -> Down;
      case 'L' -> Left;
      case 'R' -> Right;
      case 'O' -> Onward;
      default -> throw new IllegalArgumentException("Unable to parse Direction: " + c);
    };
  }

  public static Direction[] parse(char[] cArr) {
    Direction[] res = new Direction[cArr.length];
    for (int i = 0; i < cArr.length; i++)
      res[i] = parse(cArr[i]);
    return res;
  }

  public static List<Direction> parse(List<Character> s) {
    return s.stream().map(Direction::parse).toList();
  }

  // Maps each char in s to a direction
  public static Direction[] parse(String s) {
    return parse(s.toCharArray());
  }

}
