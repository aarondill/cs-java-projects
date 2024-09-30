import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Diane {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "diane.dat";

  private static int[] split(String first) {
    String[] firstNums = first.split("/");
    if (firstNums.length == 1) {
      return new int[] {Integer.parseInt(firstNums[0], 10), 1};
    }
    String[] wholeAndNum = firstNums[0].split(" ");
    int whole = 0, num = 0;
    if (wholeAndNum.length == 1) {
      num = Integer.parseInt(wholeAndNum[0], 10);
    } else {
      whole = Integer.parseInt(wholeAndNum[0], 10);
      num = Integer.parseInt(wholeAndNum[1], 10);
    }
    if (whole < 0) {
      num = -num;
    }
    int denom = Integer.parseInt(firstNums[1], 10);
    return new int[] {num + (whole * denom), denom};
  }

  private static void each(Scanner scan) {
    // Parse the input:
    String line = scan.nextLine();
    String[] numbers = line.split(" and ");
    int[] first = split(numbers[0]);
    int[] second = split(numbers[1]);

    int[] result = {first[0] * second[1] + second[0] * first[1], first[1] * second[1]};
    int whole = result[0] / result[1];
    result[0] -= whole * result[1];
    if (whole != 0) System.out.print(whole + " ");
    if (result[0] != 0) System.out.print(Math.abs(result[0]) + "/" + result[1]);
    if (result[0] == 0 && whole == 0) System.out.print("0");
    System.out.println();

  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        each(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
