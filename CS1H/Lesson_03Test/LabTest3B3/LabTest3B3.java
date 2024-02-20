/**
 * public class LabTest3B3
 *  
 * Author:  Aaron Dill
 * Date:    04/24/2023
 * Course:  H Computer Science I
 * Period:  4th period
 *  
 * Summary of file:
 *     Write a program to input from a data file several integer values into an ArrayList called nums, and then output
 *     the numbers in numerical order, followed by their average (similar to Advanced Technique #3).
 *     The data file will be named “labTest3B3.in” and will contain several integers. Using the same technique you
 *     learned in Advanced Technique #3:
 *     • read the integers from a data file into an ArrayList,
 *     • sort them,
 *     • add them up,
 *     • count them,
 *     • calculate the average,
 *     • output them in numerical order, and
 *     • output the average to one decimal place of precision.
 *     Here is a sample data file, and the resulting output. The data file used to test your program will NOT be the same
 *     one as listed here, but if you write the code correctly, it should work just the same.
 *     Sample data file ("labTest3B3.in"):
 *     143
 *     56
 *     14
 *     999
 *     364
 *     3
 *     -45
 *     Resulting output:
 *     -45
 *     3
 *     14
 *     56
 *     143
 *     364
 *     999
 *     Average = 219.1
 *     
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
public class LabTest3B3{
  private static void log(Object... strArr){ for(Object s : strArr) System.out.println(s); }
  private static void logf(String format, Object... objArr){ 
     ArrayList<Object> args = new ArrayList<>();
     args.add(format);
     for(Object o : objArr) args.add(o);
     System.out.printf(format+"\n", objArr); 
  }
  private static void err(Object... strArr){ for(Object s : strArr) System.err.println(s); }

  public static void main(String... args){
     String inputFileName = "labTest3B3.in";
     ArrayList<Integer> nums = new ArrayList<>();
     // This try-with-resources closes the scanner at the end of the block
     try(Scanner input = new Scanner(new File(inputFileName))){
        // Add every int to the nums array.
        // No handling is done if the file is not completely integers. 
        // In this case, all integers up to the non-integer value will be added and future values will be missed.
        // If multiple integers are on the same line, they will all be added.
        // No handling is done if the array is empty, as it causes no issues, but this is likely a mistake by the user.
        while(input.hasNextInt()) nums.add(input.nextInt());
        // If file couldn't be found (thrown by scanner)
     } catch(FileNotFoundException e){
        err(e);
        err("Something went wrong finding your file. Please ensure it's named "+inputFileName);
        System.exit(1);
        return;
        // If something wasn't there 
     } catch (NoSuchElementException e){
        err(e);
        err("Something went wrong finding all the data from the input file. Please ensure it's in the correct order and matches the program specifications.");
        System.exit(1);
        return;
     }      
     // Exactly identical to nums.sort(null). In fact, that's what this method does, is call list.sort(null);
     // Additionally, this requires an additional import from java.util.Collections, while nums.sort(null) would require no such import.
     // This call will sort by "natural ordering", which is determined by num1.compareTo(num2), and is equivelent to least to greatest ordering.
     Collections.sort(nums); 
     // fruits.size() returns the current number of elements in the array (the number of ints read)   
     int count = nums.size();
     // Int is safe because two integers should never add to a double.
     int sum = 0;
     // This could be consolidated into the above loop (collection), but this progam's efficiency doesn't matter, so I can run as for loops as I want.
     for(Integer n : nums) sum+=n;
     // cast sum to double before division to force decimal division.
     double average = ( (double)sum ) /count;
     // Output each num in the list (now sorted)
     for(Integer n : nums) log(n);
     // printf will take care of rounding for me.
     logf("Average = %.1f", average);
  }
}
 
 
 