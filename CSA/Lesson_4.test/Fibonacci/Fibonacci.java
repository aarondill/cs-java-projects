/**
 * Primary java class: Fibanacci
 *  
 * Author:  Aaron Dill
 * Date:    11/28/20223
 * Course:  CSA
 * Period:  3rd Period
 *  
 * Summary of file:
 *      Calculate the fibanacci sequence between two user provided integers x and y (inclusive).
 */

import java.util.Scanner;
import java.util.ArrayList;
public class Fibonacci {
    private static ArrayList<Integer> getFib(int start, int end){
        ArrayList<Integer> res = new ArrayList<>();
        int prev2 = 0, prev = 1;
        // The initial prev and prev2 values don't get checked in the loop. Add a special check for them.
        if(start <= prev2 && end >= prev2) res.add(prev2);
        if(start <= prev && end >= prev) res.add(prev);
                
        while(true) {
            int current = prev2 + prev;
            if (current > end) break; // Stop! They don't want any more answers than this.
            // Already checked that current is <= end
            if (current >= start) res.add(current); // add to the return list
            prev2 = prev; prev = current; // Shift back our previous answers
        }
        return res; // Return the list.
    }
    public static void main(String[] args) {
        int start, end;
        try(Scanner kb = new Scanner(System.in)){
            System.out.print("Enter the starting value: ");
            start = kb.nextInt();
            System.out.print("Enter the ending value: ");
            end = kb.nextInt();
        } 
        if (end < start) throw new RuntimeException("Ending value must be >= the starting value");
        ArrayList<Integer> fib = getFib(start, end); // Get the list of fibanacci numbers between start and end as an ArrayList;
        if(fib.size() == 0){
            System.out.println("None found.");
            return; // Don't output an empty line!
        }
        // Turn the ArrayList<Integer> fib into a String[] to pass to String.join for nice output.
        String[] fibArr = new String[fib.size()];
        for (int i = 0; i < fibArr.length; i++) fibArr[i] = ""+fib.get(i);
        // Output the String[] with ", " delimiting results.
        System.out.println(String.join(", ", fibArr));
    }
}
