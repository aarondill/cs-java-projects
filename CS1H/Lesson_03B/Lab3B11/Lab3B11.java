import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Lab3B11
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   April 14, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file: WAP to implement Advanced Technique #3 as demonstrated in
 * the lesson. This program introduces counting and accumulating inside a loop.
 * Using two utility variables, sum and count, as each value is output, its
 * value is accumulated into a total amount, and counted, so that the average of
 * all the number can be calculated and output at the end. It is necessary to
 * double cast the sum variable so that decimal division takes place, otherwise
 * any fractional part would be discarded since both sum and count are integer
 * values.
 */
public class Lab3B11 {
    public static void main(String[] args) throws IOException {
        //Input section
        Scanner file = new Scanner(new File("./lab3B11.in"));
        ArrayList<Integer> numbers = new ArrayList<>();
        while (file.hasNextInt()) {
            numbers.add(file.nextInt());
        }
        //Process section
        int sum = 0;
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
            count++;
        }
        double average = (double) sum / count;
        numbers.sort(null);
        //Output section
        for (Integer n : numbers)
            System.out.println(n);
        System.out.printf("Average = %.1f\n", average);
    }
}
