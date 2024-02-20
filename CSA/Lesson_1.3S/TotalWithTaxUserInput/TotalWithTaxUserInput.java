import java.util.Scanner;
import java.util.function.Supplier;

/**
 * public class TotalWithTaxUserInput
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/23/23
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will print the price of an item that
 * has been purchased, the sales tax applied to that purchase and the total
 * cost. Declare a constant of type double for the tax rate named TAXRATE and
 * assign a value of 0.0825 to the constant. Declare double variables for the
 * price of the item, tax amount and the total cost named price, tax and total.
 * Prompt the user of the price of the item, read the price from the console and
 * then assign that value to price. Calculate the tax amount and assign that
 * value to tax. Then, using the variables price and tax, calculate the total
 * cost and assign that value to totalCost. A sample run and example output is
 * shown below.
 * 
 * <pre>
 * Enter the price: 20
 * Price: $52.75
 * Sales Tax: $4.351875000000001
 * Total: $57.101875
 * </pre>
 */
public class TotalWithTaxUserInput {
  private static <T> T prompt(Supplier<Boolean> check, Supplier<T> func, String prompt) {
    System.out.print(prompt);
    if (check.get()) {
      return func.get();
    }
    System.out.println(); // after prompt
    throw new RuntimeException(
        "Something went wrong reading your input. Please ensure your input is the correct type.");
    // Should never be reached
  }

  public static void main(String... args) {
    final double TAXRATE = 0.0825;
    try (Scanner scan = new Scanner(System.in)) {
      double price = args.length > 0 ? Double.parseDouble(args[0])
          : prompt(scan::hasNextDouble, scan::nextDouble, "Enter the price: ");
      double tax = price * TAXRATE;
      double totalCost = price + tax;
      System.out.println("Price: $" + price);
      System.out.println("Sales Tax: $" + tax);
      System.out.println("Total: $" + totalCost);
    }
  }
}
