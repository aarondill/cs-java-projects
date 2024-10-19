import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
  public static boolean isValid(String name[]) {
    // neither name may contain two capital letters in a row
    for (String s : name)
      if (s.matches("[A-Z]{2,}")) return false;
    if (!Character.isUpperCase(name[0].charAt(0))) return false;
    for (String s : name)
      if (s.toLowerCase().contains("johnson")) return false;
    int vowels = 0, consonants = 0;
    for (String s : name) {
      for (char c : s.toLowerCase().toCharArray()) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels++;
        else consonants++;
      }
    }
    if (vowels > consonants) return false;

    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      sc.nextLine();
      List<String[]> names = new ArrayList<>(n);
      for (int i = 0; i < n; i++)
        names.add(sc.nextLine().split(" "));
      Map<String, Integer> firstNameCounts = new HashMap<>();
      for (String[] name : names) {
        if (!isValid(name)) {
          System.out.printf("%s has to change his/her name\n", String.join(" ", name));
          continue;
        }
        String firstName = name[0];
        firstNameCounts.putIfAbsent(firstName, 0);
        firstNameCounts.put(firstName, firstNameCounts.get(firstName) + 1);
        if (firstNameCounts.get(firstName) > k) {
          System.out.printf("%s has to change his/her name\n", String.join(" ", name));
          continue;
        }

        System.out.printf("%s is a valid name\n", String.join(" ", name));
      }

    }
  }
}
