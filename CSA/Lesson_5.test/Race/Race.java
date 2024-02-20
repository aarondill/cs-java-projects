/**
 * Race
 *  
 * Author1:  Aaron Dill
 * Date:     1/22/20204
 * Course:   CSA 
 * Period:   3rd
 *
 * Summary of file:
 *   A DotRacer Race.
 *   
 *
 */
import java.util.Scanner;
public class Race 
{
	private static Scanner kb = new Scanner(System.in);
	private static DotRacer racer1, racer2, racer3;
	
	public static void main(String... args) {
		System.out.println("Let's see who has the fastest DotRacer!\n");
		racer1 = makeRacer();
		racer2 = makeRacer();
		racer3 = makeRacer();
		System.out.println("\nHow many moves in today's race?");
		int moves = kb.nextInt();
		race(moves);
		printRaceResults();
	}
	
	public static DotRacer makeRacer() {
		System.out.print("Racer name? ");
      String name = kb.nextLine();
      return new DotRacer(name);
	}
	
	public static void race(int moves) {
		DotRacer[] racers = new DotRacer[]{ racer1, racer2, racer3 }; // This should really replace the variables
      for (int i = 0; i < moves; i++){
        for (DotRacer r : racers) r.move();
      }
	}
	
	public static void printRaceResults() {
     DotRacer[] racers = new DotRacer[]{ racer1, racer2, racer3 }; // This should really replace the variables
     String winName=null;
     int winDist = 0;
     for (DotRacer r : racers) {
       int p = r.getPosition();
       System.out.println(r);
       if (p <= winDist) continue;
       winDist = p; winName = r.getName();
     }
     System.out.println();
     System.out.println("The winner is "+winName+"!");
	}
}
