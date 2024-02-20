/**
 * Primary java class: WeekDays
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/30/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program to instantiate a two String arrays. The
 * first String array named days will contain all seven days of the week in
 * English. The Second string array will containg all seven days of the week, in
 * whatever language you like (Spanish, French, German, etc.). Add a comment
 * before the second array that indicated the chosen language.
 * 
 * Output all the array elements for each array in forwards order using a for
 * loop, with a space between each pair of days. See below for an example of
 * English and German.
 *
 */
public class WeekDays {
  public static void main(String... args) {
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    // In case you couldn't tell, this is the days of the week in *Spanish*.
    String[] daysInSpanish = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    //TODO: Replace loop with: System.out.println(String.join(" ", days));
    for (int i = 0; i < days.length; i++) {
      System.out.print(days[i]);
      if (i < days.length - 1) System.out.print(" "); // Don't print a trailing space.
    }
    System.out.println();
    //TODO: Replace loop with: System.out.println(String.join(" ", daysInSpanish));
    for (int i = 0; i < daysInSpanish.length; i++) {
      System.out.print(daysInSpanish[i]);
      if (i < days.length - 1) System.out.print(" "); // Don't print a trailing space.
    }
    System.out.println();
  }
}
