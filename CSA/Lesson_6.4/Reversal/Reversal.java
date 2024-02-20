import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Primary java class: Reversal
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/01/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: In this lab take the contents of an array and reverse them
 * within the same array. DO NOT create a separate array and just copy them from
 * one to another in reverse order, or just output the current array in reverse
 * order. ACTUALLY MOVE the values from front to back or back to front.
 * 
 * See the diagram below for a better idea of what needs to happen. The value in
 * position [10] needs to be swapped with the value in position [0], [9] with
 * [1], [8] with [2], and so on.
 * 
 * Write a method called reverseList, using the program shell shown below. Think
 * carefully about how to accomplish this and do your best!
 *
 * 
 */
public class Reversal {
  public static void main(String... args) {
    int[] nums = {5, 7, 4, 9, 8, 1, 4, 3, 0, 5, 2};
    printArray(nums);
    reverseList(nums);
    printArray(nums);
  }

  // reverse a list *in place*
  private static void reverseList(int[] nums) {
    if (nums.length <= 1) return; // do nothing
    for (int i = 0; i < nums.length / 2; i++) {
      int j = nums.length - 1 - i;
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }

  private static void printArray(int[] nums) {
    System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
