/**
 * class LabTestLesson02C
 *  
 * Author1:  Aaron Dill
 * Date:     3/7/2023
 * Course:   Computer Science I Honors
 * Period:   4th
 *  
 * Summary of file: <pre>
 * Write a program to initialize two String variables with the values "100" and "5.6" 
 * and output the concatenation of the two values. Create an integer variable and a 
 * double variable and assign it the value of the String variable that contains "100" 
 * to the integer variable using the parsing process.  Repeat the process for the decimal
 * variable and the String variable assigned "5.6". Then output the square root of the
 * integer and the square of the decimal value, formatted to two decimal places.
 * Finally, use shortcut operators to halve the integer and double the decimal, 
 * and output the sum of the two values. 
 * </pre>
 */
public class LabTestLesson02C{
   public static void main(String[] args){
      String str1 = "100", str2 = "5.6";
      System.out.println(str1+str2);
      int int1 = Integer.parseInt(str1);
      double double2 = Double.parseDouble(str2);
      System.out.printf("%.2f\n", Math.sqrt(int1));
      System.out.printf("%.2f\n", Math.pow(double2, 2));
      int1 /= 2;
      double2 *= 2;
      System.out.println(int1 + double2);
   }
}