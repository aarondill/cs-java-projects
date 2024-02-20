/**
 * Primary java class: ReferenceTester
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/11/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * String equality goes brr
 *
 */
public class ReferenceTester {
  public static void main(String... args) {
    String name1 = "pat";
    String name2 = "pat";
    String name3 = new String("pat");
    String name4 = name1;

    System.out.println(name1 == name2); // True because name1 and name2 are interned by the compiler.
    System.out.println(name1 == name3); // False because name3 is allocated on the heap by the String constructor.
    System.out.println(name1 == name4); // True because name4 is assigned name1 (referencial assignment).
  }
}
