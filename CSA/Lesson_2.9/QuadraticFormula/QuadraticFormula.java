import java.util.Scanner;

/**
 * Primary java class: QuadraticFormula
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    09/25/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 2.9.3 - QuadraticFormula – To find the solutions to a quadratic equation
 * you must use the quadratic formula. The quadratic formula states that where
 * ax2 + bx + c the solutions are
 * 
 * 
 * 
 * There can be two solutions, one solution or no solutions to any given
 * equation depending on how many times the graph of the equation crosses the x
 * axis. You are going to write a program that will calculate the value of x for
 * equations that always have two solutions. Allow the user to enter the values
 * for a, b and c then calculate both solutions to the equation. A sample run
 * for the equation x2+5x+6=0 would look like this.
 * 
 * <pre>
 * Enter the values for a, b, and c:  1 5 6
 * x = -2.0 and -3.0
 * </pre>
 *
 */
public class QuadraticFormula {
  public static void main(String... args) {
    try(Scanner input = new Scanner(System.in)){
    System.out.print("Enter the values for a, b, and c: ");
    double a = input.nextDouble();
    double b = input.nextDouble();
    double c = input.nextDouble();
    double d = b * b - 4 * a * c;
    double x1 = (-b + Math.sqrt(d)) / (2 * a);
    double x2 = (-b - Math.sqrt(d)) / (2 * a);
    System.out.println("x = " + x1 + " and " + x2);
    }
  }
}
