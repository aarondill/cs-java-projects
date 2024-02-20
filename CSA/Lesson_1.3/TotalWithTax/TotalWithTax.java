/**
 * public class TotalWithTax
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/21/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will print the price of an item that
 * has been purchased, the sales tax applied to that purchase and the total
 * cost. Declare a constant of type double for the tax rate named TAXRATE and
 * assign a value of 0.0825 to the constant. Declare double variables for the
 * price of the item, tax amount and the total cost named price, tax and total.
 * The price of the item is $52.75. Assign that value to price. Calculate the
 * tax amount and assign that value to tax. Then, using the variables price and
 * tax, calculate the total cost and assign that value to totalCost. The output
 * should be on three separate lines and labeled as shown below.
 * 
 * <pre>
 * Price: $52.75
 * Sales Tax: $4.351875000000001
 * Total: $57.101875
 * </pre>
 */
public class TotalWithTax {
  public static void main(String... args) {
    final double TAXRATE = 0.0825;
    double price = 52.75;
    double tax = price * TAXRATE;
    double totalCost = price + tax;
    System.out.println("Price: $" + price);
    System.out.println("Sales Tax: $" + tax);
    System.out.println("Total: $" + totalCost);
  }
}
