/**
 * Primary java class: DotRacer
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/09/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Testing class for DotRacer guided lab
 *
 */
public class DotRacerTestClass {
  public static void main(String[] args) {
    DotRacer racer1 = new DotRacer();
    DotRacer racer2 = new DotRacer(-5, 2);
    DotRacer racer3 = new DotRacer();
    racer1.move();
    racer2.move();
    racer3.move();
    System.out.println(racer1);
    System.out.println(racer2);
    System.out.println(racer3);
  }
}
