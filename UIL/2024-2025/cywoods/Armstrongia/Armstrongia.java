import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Armstrongia {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "armstrongia.dat";

  private static void each(Scanner scan) {
    // Parse the input:
    String name = scan.next();
    double a = scan.nextDouble();
    double b = scan.nextDouble();
    double c = scan.nextDouble();
    scan.nextLine();

    System.out.println(name + ":");
    long max = Integer.MIN_VALUE;
    int night = -381498398;
    for (int i = 1; i <= 7; i++) {
      long crimes = Math.round(a * Math.pow(i, 2) + b * i + c);
      System.out.printf("Night %d: %d crimes\n", i, crimes);
      if (crimes > max) {
        max = crimes;
        night = i;
      }
    }
    System.out.printf("The highest number of crimes is %d on night %d.\n", max, night);
    // Handle output:
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
