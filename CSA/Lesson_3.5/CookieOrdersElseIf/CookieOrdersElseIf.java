import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Primary java class: CookieOrdersElseIf
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/23/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that will calculate the cost of a cookie order, given the
 * number of boxes of cookies ordered. The following chart breaks down the cost
 * per box based on the number of boxes ordered.
 * 
 * <pre>
 * 1 – 4 boxes: 6.95 per box
 * 5 – 9 boxes: 5.95 per box
 * 10 – 15 boxes: 5.50 per box
 * 16 or more boxes: 4.95 per box
 * </pre>
 * 
 * Your program should print a menu explaining the cost of the cookies and then
 * allow for input. If the input is invalid, print an appropriate message.
 * Output the number of boxes purchased, the cost per box, and the total cost of
 * the cookies. Your output should be in the format shown below
 *
 */
public class CookieOrdersElseIf {
  private static double costPerBox(int boxes) {
    if (boxes <= 0) {
      return -1;
    } else if (boxes <= 4) {
      return 6.95;
    } else if (boxes <= 9) {
      return 5.95;
    } else if (boxes <= 15) {
      return 5.50;
    } else {
      return 4.95;
    }
  }

  public static void main(String... args) {
    System.out.println("********** Cookie Order **********");
    System.out.println("Welcome to Mrs. Baker's Cookie Shop");
    System.out.println("The price per box is as follows:");
    System.out.println("1 – 4 boxes:      6.95 per box");
    System.out.println("5 – 9 boxes:      5.95 per box");
    System.out.println("10 – 15 boxes:    5.50 per box");
    System.out.println("16 or more boxes: 4.95 per box");
    System.out.print("Enter the number of boxes you wish to purchase: ");
    int boxes = -1;
    try (Scanner input = new Scanner(System.in)) {
      boxes = input.nextInt();
      System.out.println();
    } catch (InputMismatchException e) {
      System.out.println();
      System.out.println("Your input is invalid.");
      System.exit(1);
    }
    double costPerBox = costPerBox(boxes);
    if (costPerBox == -1) {
      System.out.println("Your input is invalid.");
    } else {
      System.out.printf("You bought %d boxes of cookies at $%.2f per box.\n", boxes, costPerBox);
      System.out.printf("Your total bill is $%.2f.\n", costPerBox * boxes);
    }
  }
}
