import java.util.HashMap;
import java.util.Scanner;

public class Klaudia {
  static HashMap<String, String> morseCode = new HashMap<>();
  static {
    morseCode.put(".-", "A");
    morseCode.put("-...", "B");
    morseCode.put("-.-.", "C");
    morseCode.put("-..", "D");
    morseCode.put(".", "E");
    morseCode.put("..-.", "F");
    morseCode.put("--.", "G");
    morseCode.put("....", "H");
    morseCode.put("..", "I");
    morseCode.put(".---", "J");
    morseCode.put("-.-", "K");
    morseCode.put(".-..", "L");
    morseCode.put("--", "M");
    morseCode.put("-.", "N");
    morseCode.put("---", "O");
    morseCode.put(".--.", "P");
    morseCode.put("--.-", "Q");
    morseCode.put(".-.", "R");
    morseCode.put("...", "S");
    morseCode.put("-", "T");
    morseCode.put("..-", "U");
    morseCode.put("...-", "V");
    morseCode.put(".--", "W");
    morseCode.put("-..-", "X");
    morseCode.put("-.--", "Y");
    morseCode.put("--..", "Z");

    morseCode.put(".----", "1");
    morseCode.put("..---", "2");
    morseCode.put("...--", "3");
    morseCode.put("....-", "4");
    morseCode.put(".....", "5");
    morseCode.put("-....", "6");
    morseCode.put("--...", "7");
    morseCode.put("---..", "8");
    morseCode.put("----.", "9");
    morseCode.put("-----", "0");

  }

  // Decode a message in morse code.
  private static String decode(String[] words) {
    StringBuilder decoded = new StringBuilder();
    for (String word : words) {
      for (String letter : word.split(" ")) {
        decoded.append(morseCode.get(letter));
      }
      decoded.append(" ");
    }
    return decoded.toString();
  }

  public static void main(String[] args) {
    try (Scanner dataScanner = new Scanner(Klaudia.class.getResourceAsStream("./klaudia.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        String[] words = dataScanner.nextLine().split("\\s+/\\s+"); // slashes mean a new word
        System.out.println(decode(words));
      }
    }

  }
}
