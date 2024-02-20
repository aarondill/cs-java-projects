import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Primary java class: Factors
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/02/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * X is a factor of Y if Y is divisible by X. For example the positive factors
 * of 12 are 1, 2, 3, 4, 6 and 12. Write a program that modifies lab 4.1.3 so
 * that a user may enter a number and the program prints all of the positive
 * factors of that number.
 *
 */
public class Factors {
  public static void main(String... args) {
    BigInteger number;
    if (args.length > 0) {
      number = new BigInteger(args[0]);
    } else {
      try (Scanner input = new Scanner(System.in)) {
        System.out.print("Enter your number: ");
        number = input.nextBigInteger();
      }
    }
    if (number.compareTo(BigInteger.ZERO) <= 0)
      throw new IllegalArgumentException("Number must be positive");

    Set<BigInteger> factors = new HashSet<>();
    BigInteger sqrt = number.sqrt();
    for (BigInteger i = BigInteger.ONE; i.compareTo(sqrt) <= 0; i = i.add(BigInteger.ONE)) {
      if (!number.mod(i).equals(BigInteger.ZERO))
        continue;
      factors.add(i);
      factors.add(number.divide(i));
    }
    String out = factors.stream().sorted().map(x -> x.toString()).collect(Collectors.joining(" "));
    System.out.println("The factors of " + number + " are: " + out);
  }
}
