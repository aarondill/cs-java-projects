/**
 * Primary java class: WrappersDelight
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    09/25/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program that will demonstrate using the Integer and
 * Double classes and the concept of autoboxing. Your program should declare
 * four different variables. Name the variables num1, num2, num3 and num4. In
 * one statement declare num1 as an int and assign the value 14. Instantiate
 * num2 as an Integer object using the Integer class constructor with 8 as the
 * actual parameter. Declare num3 as double and assign 2.5. Use autoboxing to
 * declare a Double type variable named num4 and assign the sum of num2 and num3
 * to num4. Use autoboxing to change the value in num2 to 5. Assign the sum of
 * num1, num2 and num4 to num3. Use unboxing and casting to assign the sum of
 * num2 and num4 to num1. Finally, print the value in each variable each on a
 * separate line. Your output should look exactly like the sample output shown
 * below.
 *
 * 
 */
public class WrappersDelight {
  public static void main(String... args) {
    int num1 = 14;
    Integer num2 = new Integer(8); 
    double num3 = 2.5;
    Double num4 = num2 + num3;
    num2 = 5;
    num3 = num1+num2+num4;
    num1 = (int)(num2 + num4);
    System.out.println(num1);
    System.out.println(num2);
    System.out.println(num3);
    System.out.println(num4);
  }
}
