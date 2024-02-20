/**
 * public class PoundsToKilograms
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    08/21/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: The formula to convert a weight in pounds to kilograms is:
 * pounds/2.205. Write a program that will convert 115 pounds to kilograms and
 * print the result. Declare double type variables for pounds and kilograms
 * named lbs and kg. Assign the value 115 to lbs and then use that variable to
 * calculate the kilograms and assign the result to kg. Your output should look
 * like this.
 *
 */
public class PoundsToKilograms {
  public static void main(String... args) {
    double lbs = 115;
    double kg = lbs / 2.205;
    System.out.println(lbs + " pounds = " + kg + " kilograms");
  }
}
