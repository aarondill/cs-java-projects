
import java.util.Scanner;
public class GCD {
   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);
      System.out.print("Enter two numbers: ");
      int a = kb.nextInt();
      int b = kb.nextInt();
      if(b > a) {
         int t = a;
         a = b;
         b = t;
      }
     /*
      * Use Euclid's algorithm to write the
      * remaining code needed to find and
      * print the greatest common divisor
      * of both a and b.
      */
      if (a <= 0 || b <= 0) {
        return; // This is defined as not allowed
      }
      /* 
       * To calculate the gcd of a and b using Euclid's algorithm 
       * 1. divide a by b to get a remainder of r1. 
       * 2. divide b by r1 to get a remainder of r2. 
       * 3. divide r1 by r2 to get a remainder of r3. 
       * 4. repeat 2 and 3 until replacing r1 with r(n-2), r2 with r(n-1), and r3 with r(n) until r(n) is 0
       * 5. Since the remainder r3 (rn) is 0, the gcd of a and b is r2 (r(n-1)).
       */
    int r=-1; // curr
    while (r != 0){
       r = a % b; // Calculate new r;
       if (r <= 0) break; // Don't move the remainders (so we can use it in the answer)
       a = b; b = r; // Move each remainder back one.
    }
    // Result is b -- the rubric states it has to be called 'b'.
    System.out.println(b);
   }
}