/**
 * class LabTestLesson02A
 *  
 * Author1:  Aaron Dill
 * Date:     2/3/2023
 * Course:   Computer Science I Honors
 * Period:   4th
 *  
 * Summary of file: Program that demonstrates knowledge of using printf command with variables and CONSTANTS.
 *   
 */
class LabTestLesson02A {
   public static void main(String[] args){
   final String MY_NAME = "Aaron Dill";
   int myAge = 16;
   double myGPA = 5.6; //I don't recall exactly the decimal
   System.out.printf("%5s%s\n", "", MY_NAME);
   System.out.printf("%9s%d\n", "", myAge);
   System.out.printf("%2s%.2f\n", "", myGPA);
   }
}
