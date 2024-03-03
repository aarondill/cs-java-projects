import java.util.List;

enum Space {
  Food, Empty, Snake; // Note: Snake is used in parse to ensure all types are parseable

  public static Space parse(char c) {
    return switch (Character.toUpperCase(c)) {
      case 'X' -> Snake;
      case 'F' -> Food;
      case ' ' -> Empty;
      default -> throw new IllegalArgumentException("Unable to parse Space: " + c);
    };
  }

  public static Space[] parse(char[] cArr) {
    Space[] res = new Space[cArr.length];
    for (int i = 0; i < cArr.length; i++)
      res[i] = parse(cArr[i]);
    return res;
  }

  public static List<Space> parse(List<Character> s) {
    return s.stream().map(Space::parse).toList();
  }

  // Maps each char in s to a Space
  public static Space[] parse(String s) {
    return parse(s.toCharArray());
  }
}
