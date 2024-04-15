/**
 * class Lab1C3
 *  
 * Author1:  Aaron Dill
 * Author2:  
 * Date:     12/2/22
 * Course:   Computer Science I Honors
 *  
 * Summary of file:
 *    Write a program to demonstrate the use of
 *    the %e, %f, and %g formats for decimal values. 
 *    Create a double variable and assign to it a very large decimal value. 
 *    Output that value in all three formats using printf.
 *    reassign to the variable a very small decimal value,
 *    and then output in all three formats,
 *    this time using the String.format process. 
 *
 */ 
class Lab1C3{
        public static void main(String[] args){
                double num = Math.random()*1000000;
                System.out.printf("%e\n%f\n%g\n\n", num, num, num);
                num = Math.random()*0.00001;
                String str = String.format("%e\n%f\n%g", num, num, num);
                System.out.println(str);
        }
}
