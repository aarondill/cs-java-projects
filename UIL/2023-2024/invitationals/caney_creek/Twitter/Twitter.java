import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Twitter {
  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Twitter.class.getResourceAsStream("./twitter.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      List<String> tweets = new ArrayList<>();
      StringBuilder buffer = new StringBuilder();
      while (dataScanner.hasNextLine()) {
        String line = dataScanner.nextLine();
        if (line.charAt(0) == '@') {
          tweets.add(buffer.toString());
          buffer = new StringBuilder();
        }
        buffer.append(line);
      }
      tweets.add(buffer.toString());
      for (String tweet : tweets) {
        if (tweet.length() == 0) continue;
        int count = tweet.length();
        if (tweet.charAt(0) == '@' && count <= 140) System.out.println("tweet");
        else System.out.println("not tweet");
      }
    }

  }
}
