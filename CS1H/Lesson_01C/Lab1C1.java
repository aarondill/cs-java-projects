/**
 * class Lab1C1
 *  
 * Author1:  Aaron Dill
 * Author2:  
 * Date:     12/2/22
 * Course:   Computer Science I Honors
 *  
 * Summary of file:
 *   Write a program that uses the printf and String.format commands to output twice a sentence 
 *   of your own creation, similar to the �cherry tree� sentence you saw earlier in the lesson, 
 *   once using String.format, and then again using printf.
 * 
 */ 
 public class Lab1C1{
        public static void main(String[] args){
        String s = "some string";
        int d = -1;
        boolean bool = false;
        System.out.printf("An example value many programmers use for a string is '%s'.\nFurthermore,"
        + " many programmers use %d for a int,\nas well as either of the possible values,"
        + "%b or %b, for a boolean value.\n\n", s, d, bool, !bool);
        s="default strings"; d=999999; bool=true;
        String formatted = String.format("Allowing a program to work on examples such as %s, %d, and %b hard-coded in a"
        + " finished product\noften shows badly planned or badly designed programs.", s, d, bool);
        System.out.println(formatted);
        }
}
