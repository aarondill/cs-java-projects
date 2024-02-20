import java.util.Scanner;

/**
 * Primary java class: NumberCruncher
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/18/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class NumberCruncher {
  static int count = 0;
  static double total = 0.0, average = 0.0;
  static Scanner kb = new Scanner(System.in);

  public static void main(String[] args) {
    int num = inputNumber();
    while (num > 0) {
      processNumber(num);
      num = inputNumber();
    }
    printResults();
  }

  public static int inputNumber() {
    System.out.print("Enter a positive number or 0 to quit: ");
    return kb.nextInt();
  }

  public static void processNumber(int num) {
    count++;
    total += num;
    average = total / count;
  }

  public static void printResults() {
    System.out.printf("Count = %d\n", count);
    System.out.printf("Average = %s\n", average);
  }
}
