import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Primary java class: LeftShift
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/01/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class LeftShift {
  public static void main(String... args) {
    int[] nums = {1, 0, 1, 1, 0, 1, 0, 1};
    printArray(nums);

    int shift = 0;
    try (Scanner scan = new Scanner(System.in)) {
      System.out.print("Enter shift value ==> ");
      shift = scan.nextInt();
    }

    nums = leftShift(nums, shift);
    printArray(nums);
  }

  public static int[] leftShift(int[] nums, int shift) {
    // Fun impl 
    // return new BigInteger(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining("")), 2)
    //     .shiftLeft(shift).toString(2).chars().map(x -> Integer.parseInt(String.valueOf((char) x))).toArray();

    // Boring impl
    int[] newNums = new int[nums.length + shift];
    for (int i = 0; i < nums.length; i++)
      newNums[i] = nums[i];
    return newNums;

  }

  private static void printArray(int[] nums) {
    System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
