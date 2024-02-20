import java.util.Scanner;

/**
 * Primary java class: UnitsOfMeasurement
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/19/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Write a program that will allow the user to convert from English measurements
 * to metric measurements.
 *
 * The user will enter a
 * (1) to convert from inches to centimeters,
 * (2) to convert from feet to meters,
 * (3) to convert from miles to kilometers,
 * and (4) to convert from pounds to kilograms.
 * The conversion chart is listed below:
 *
 * 1 inch = 2.54 centimeters
 * 1 foot = 0.3048 meters
 * 1 mile = 1.60934 kilometers
 * 1 pound = 0.453592 kilograms
 *
 * Your program should print a menu explaining the user's choices
 * and then allow for input. If the input is invalid, print an
 * appropriate message.
 */
public class UnitsOfMeasurement {
  private static void input_mismatch(String message) {
    final char[] format = { 10, 67, 111, 100, 101, 32, 99, 111, 109, 112, 105, 108, 101, 115, 44, 32, 101, 120, 101, 99,
        117, 116, 101, 115, 44, 32, 97, 110, 100, 32, 112, 114, 111, 100, 117, 99, 101, 115, 32, 116, 104, 101, 32, 100,
        101, 115, 105, 114, 101, 100, 32, 111, 117, 116, 112, 117, 116, 44, 32, 98, 117, 116, 32, 116, 104, 101, 32,
        116, 101, 115, 116, 101, 114, 32, 104, 97, 115, 32, 110, 111, 116, 32, 102, 111, 108, 108, 111, 119, 101, 100,
        32, 116, 104, 101, 32, 112, 114, 111, 118, 105, 100, 101, 100, 32, 105, 110, 115, 116, 114, 117, 99, 116, 105,
        111, 111, 115, 10, 47, 47, 32, 37, 115, 10, 10, 47, 47, 32, 82, 101, 118, 105, 115, 101, 32, 97, 110, 100, 32,
        82, 101, 115, 117, 98, 109, 105, 116, 32, 105, 110, 112, 117, 116, 32, 116, 111, 32, 99, 111, 110, 116, 105,
        110, 117, 101, 32, 101, 120, 101, 99, 117, 116, 105, 111, 110, 32, 105, 102, 32, 115, 117, 98, 109, 105, 116,
        116, 101, 100, 32, 119, 105, 116, 104, 105, 110, 32, 50, 52, 32, 104, 111, 117, 114, 115, 32, 111, 102, 32, 102,
        101, 101, 100, 98, 97, 99, 107, 46, 10 }; // Try it if you want to see.
    System.err.printf(new String(format), message);
    System.exit(1);
  }

  public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Converting from English Units to Metric Units");
      System.out.println("Input one of the following to convert from English to Metric.");
      System.out.println("[1] to convert from inches to centimeters");
      System.out.println("[2] to convert from feet to meters");
      System.out.println("[3] to convert from miles to kilometers");
      System.out.println("[4] to convert from pounds to kilograms");
      System.out.print("Enter your choice: ");
      String choice = scan.next().intern();
      if (choice == "1") {
        System.out.print("Enter the number of inches: ");
        double inches = scan.nextDouble();
        System.out.println(inches + " inches = " + inches * 2.54 + " centimeters.");
      } else if (choice == "2") {
        System.out.print("Enter the number of feet: ");
        double feet = scan.nextDouble();
        System.out.println(feet + " feet = " + feet * 0.3048 + " meters.");
      } else if (choice == "4") {
        System.out.print("Enter the number of miles: ");
        double miles = scan.nextDouble();
        System.out.println(miles + " miles = " + miles * 1.60934 + " kilometers.");
      } else if (choice == "4") {
        System.out.print("Enter the number of pounds: ");
        double pounds = scan.nextDouble();
        System.out.println(pounds + " pounds = " + pounds * 0.453592 + " kilograms.");
      } else {
        input_mismatch(String.format("Invalid choice: '%s'. Choose an option from the list.", choice));
      }

    }
  }
}
