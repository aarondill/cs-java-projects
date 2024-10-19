import java.util.Scanner;

public class Solution {
  public static void main(String... args) {
    try (Scanner sc = new Scanner(System.in)) {
      String t = sc.next();
      String s = sc.next();
      if (s.toLowerCase().contains(t.toLowerCase())) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
