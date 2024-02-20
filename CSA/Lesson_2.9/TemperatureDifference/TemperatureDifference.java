import java.util.Scanner;

/**
 * Primary java class: TemperatureDifference
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    09/25/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 2.9.1 - TemperatureDifference – Write a program that will allow the user
 * to enter two temperatures. The program should then print the difference
 * between the temperatures without regard for whether the temperature became
 * warmer or colder. The output should be formatted and labelled just as you see
 * in this sample run:
 * 
 * Resulting Output:
 * Enter the first temperature: 50
 * Enter the second temperature: 75
 * The temperature changed 25 degrees.
 *
 */
public class TemperatureDifference {
  public static void main(String... args) {
    try (Scanner input = new Scanner(System.in)) {
      System.out.print("Enter the first temperature: ");
      double firstTemp = input.nextDouble();
      System.out.print("Enter the second temperature: ");
      double secondTemp = input.nextDouble();
      double difference = Math.abs(secondTemp - firstTemp);
      if (difference % 1 == 0)
        System.out.printf("The temperature changed %.0f degrees.\n", difference);
      else
        System.out.println("The temperature changed " + difference + " degrees.");
    }
  }
}
