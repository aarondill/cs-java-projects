import java.util.Arrays;
import java.util.Scanner;

/**
 * Primary java class: FindMinAndMax
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    11/02/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 4.1.6 – FindMinAndMax - Write a program that allows the user to enter
 * exactly 5 whole numbers that can be positive or negative. The program should
 * then print the largest number that was entered and the smallest number that
 * was entered. (Hint: Use Integer.MIN_VALUE and Integer.MAX_VALUE to initialize
 * the variables that store the minimum and maximum values.)
 *
 */
public class FindMinAndMax {
  public static void main(String... args) {
    int count = 5;
    int[] nums = new int[count];
    try (Scanner scan = new Scanner(System.in)) {
      for (int i = 0; i < nums.length; i++) {
        System.out.print("Number: ");
        nums[i] = scan.nextInt();
      }
    }
    System.out.println("Max value is: " + Arrays.stream(nums).max().orElse(Integer.MAX_VALUE));
    System.out.println("Min value is: " + Arrays.stream(nums).min().orElse(Integer.MIN_VALUE));
  }
}
