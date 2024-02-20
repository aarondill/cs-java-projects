import java.math.BigInteger;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
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
 * 
 * Number -- Single Thread -- Multiple Threads (8)
 * 255 -- 0m0.449s -- 0m0.491s (near-zero performance penalty)
 * 900009941238943893 -- 0m37.791s -- 0m23.833s
 * 2700029823716831679 -- 1m9.269s -- 0m41.226s
 *
 */
public class FactorsThreaded {
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
    // if (number.compareTo(BigInteger.ZERO) <= 0)
    // throw new IllegalArgumentException("Number must be positive");

    int cores = Runtime.getRuntime().availableProcessors();

    Set<BigInteger> factors;
    try {
      factors = doThreaded(number, cores);
    } catch (InterruptedException e) {
      e.printStackTrace();
      System.exit(1);
      return;
    }
    String out = factors.stream().sorted().map(x -> x.toString()).collect(Collectors.joining(" "));
    System.out.println("The factors of " + number + " are: " + out);

    // Set<BigInteger> factorsSync = run(number);
    // if (!factors.equals(factorsSync))
    // throw new RuntimeException("Factors are not equal!");

  }

  public static Set<BigInteger> run(BigInteger number, BigInteger start, BigInteger end) {
    Set<BigInteger> factors = new HashSet<>();
    if (number.compareTo(BigInteger.ZERO) == 0)
      return factors;
    boolean isNeg = number.compareTo(BigInteger.ZERO) < 0;
    if (isNeg)
      number = number.negate(); // Find positive factors.

    for (BigInteger i = start; i.compareTo(end) <= 0; i = i.add(BigInteger.ONE)) {
      if (!number.mod(i).equals(BigInteger.ZERO))
        continue;
      factors.add(i);
      factors.add(number.divide(i));
    }

    if (isNeg) { // If negative, then add all negative factors (duplicate positives)
      Set<BigInteger> negFactors = new HashSet<>();
      for (BigInteger i : factors)
        negFactors.add(i.negate());
      factors.addAll(negFactors);
    }

    return factors;
  }

  public static Set<BigInteger> run(BigInteger number) {
    return run(number, BigInteger.ONE, number.abs().sqrt());
  }

  private static Set<BigInteger> doThreaded(BigInteger num, int threadCount) throws InterruptedException {
    final CountDownLatch latch = new CountDownLatch(threadCount);
    final Map<Integer, Set<BigInteger>> ret = new Hashtable<>();

    final BigInteger end = num.abs().sqrt(); // i <= end
    final BigInteger start = BigInteger.ONE;
    // +1 to avoid decimal issues. double-calculates, but that's better than missing
    final BigInteger count = end.subtract(start).divide(BigInteger.valueOf(threadCount)).add(BigInteger.ONE).abs();
    for (int i = 0; i < threadCount; i++) {
      final int index = i; // store the index in a captured variable
      final BigInteger tStart = start.add(BigInteger.valueOf(i).multiply(count)),
          tmpEnd = tStart.add(count),
          tEnd = tmpEnd.compareTo(end) > 0 ? end : tmpEnd; // Window is too large, use the end.

      if (tStart.compareTo(end) >= 0) {// Start >= end. Stop creating threads.
        for (int j = i; j < threadCount; j++)
          latch.countDown(); // Count down the remaining unused threads.
        break;
      }

      Runnable r = () -> {
        Set<BigInteger> res = FactorsThreaded.run(num, tStart, tEnd); // Get the result
        ret.put(index, res); // Store the result in the map.
        latch.countDown(); // This one is done!
      };
      new Thread(r).start(); // Start a new thread.
    }

    latch.await(); // Wait for all threads to complete their work.

    Set<BigInteger> factors = new HashSet<>();
    for (Set<BigInteger> i : ret.values()) // Flattern the returned values.
      factors.addAll(i);

    return factors;
  }
}
