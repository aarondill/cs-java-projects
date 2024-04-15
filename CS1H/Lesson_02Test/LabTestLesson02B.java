/**
 * class LabTestLesson02B
 *  
 * Author1:  Aaron Dill
 * Date:     2/2/2023
 * Course:   Computer Science I Honors
 * Period:   4th
 *  
 * Summary of file: Program that demonstrates knowledge of declaring cariables and CONSTANTS and using them in a calculation
 */
 
class LabTestLesson02B {
   public static void main(String[] args){
   final double PI = 3.14;
   int diameter = 15;
   double circum = diameter * PI;
   System.out.printf("A circle with diameter %d has a circumference of %.1f.\n", diameter, circum);
   }
}
