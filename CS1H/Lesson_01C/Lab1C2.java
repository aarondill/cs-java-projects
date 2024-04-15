/**
 * class Lab1C1
 *  
 * Author1:  Aaron Dill
 * Author2:  
 * Date:     12/2/22
 * Course:   Computer Science I Honors
 *  
 * Summary of file:
 *    Assign a name to a String variable, create a Calendar object,
 *    and output a name with the current date and time
 */ 
 public class Lab1C2{
        public static void main(String[] args){
        String name = "Aaron Dill";
        java.util.Calendar cal = java.util.Calendar.getInstance(); 
        System.out.printf("My name is: %s\nThe current date is: %tc", name, cal);
        }
}
