/**
 * Primary java class: LosJugadores
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/30/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program to instantiate an integer array containing
 * jersey numbers of your favorite players (for any sport, any team), no fewer
 * than 10 values. Write four loops, your choice of for, while, or do while, and
 * output the following, with single spaces between each value, and a new line
 * for each loop:
 * 
 * all the jersey numbers in forwards order all the jersey numbers in reverse
 * order all the jersey numbers in forwards order except the first element of
 * the array all the jersey numbers in reverse order except for the last element
 * of the array
 *
 */
public class LosJugadores {
  public static void main(String... args) {
    int[] jerseyNumbers = { // Sourced from https://www.mlb.com/astros/roster
        52, // Bryan Abreu
        64, // Brandon Bielak
        56, // Ronel Blanco
        58, // Hunter Brown
        75, // Dylan Coleman
        59, // Declan Cronin
        66, // Shawn Dubin
        68, // J.P. France
        77, // Luis Garcia
        31, // Kendall Graveman
        71, // Josh Hader
        53, // Cristian Javier
        61, // Seth Martinez
        43, // Lance McCullers Jr.
        47, // Rafael Montero
        67, // Parker Mushinski
        72, // Oliver Ortega
        55, // Ryan Pressly
        62, // Bennett Sousa
        65, // José Urquidy
        59, // Framber Valdez
        35, // Justin Verlander
        60, // Forrest Whitley
        7, // Victor Caratini
        21, // Yainer Diaz
        18, // César Salazar
        79, // José Abreu
        27, // Jose Altuve
        2, // Alex Bregman
        14, // Mauricio Dubón
        17, // David Hensley
        16, // Grae Kessinger
        3, // Jeremy Peña
        28, // Jon Singleton
        44, // Yordan Alvarez
        43, // Kenedy Corona
        9, // Corey Julks
        20, // Chas McCormick
        6, // Jake Meyers
        30, // Kyle Tucker
    };
    // all the jersey numbers in forwards order
    for (int i = 0; i < jerseyNumbers.length; i++)
      System.out.print(jerseyNumbers[i] + " ");
    System.out.println();
    // all the jersey numbers in reverse order
    for (int i = jerseyNumbers.length - 1; i >= 0; i--)
      System.out.print(jerseyNumbers[i] + " ");
    System.out.println();
    // all the jersey numbers in forwards order except the first element of the array
    for (int i = 1; i < jerseyNumbers.length; i++)
      System.out.print(jerseyNumbers[i] + " ");
    System.out.println();
    // all the jersey numbers in reverse order except for the last element of the array
    for (int i = jerseyNumbers.length - 2; i >= 0; i--)
      System.out.print(jerseyNumbers[i] + " ");
    System.out.println();

  }
}
