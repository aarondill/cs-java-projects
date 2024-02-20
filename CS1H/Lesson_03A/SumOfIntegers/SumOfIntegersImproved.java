package SumOfIntegers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class SumOfIntegers
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	April 6, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file: take user input of three integers using a
 * {@link java.util.Scanner} and output the sum of them all
 */
public class SumOfIntegersImproved {
    public static List<Integer> getNumbers(Scanner kb) {
        List<Integer> numbers = new ArrayList<>();
        while (true) {
            System.out.print("Enter a number (type '-' when you are done): ");
            String input = kb.next();
            if (input.equals("-")) {
                break;
            } else if (input.matches("-?\\d+")) {
                numbers.add(Integer.parseInt(input));
            } else {
                System.out.println("Input must be a number");
            }
        }
        return numbers;
    }

    public static Integer getSum(List<Integer> numbers) {
        var optSum = numbers.stream().reduce((a, b) -> a + b);
        // Return 0 if the list of numbers is empty
        return optSum.isEmpty() ? 0 : optSum.get();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        // Input section
        List<Integer> numbers = getNumbers(kb);
        // Process section
        int sum = getSum(numbers);
        // Output section
        System.out.println();
        System.out.println("****.****.****.**");
        System.out.printf("%d\t".repeat(numbers.size()), numbers.toArray());
        System.out.println();
        System.out.println("Sum = " + sum);
        kb.close();
    }
}
