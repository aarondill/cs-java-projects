/**
 * Primary java class: Thing
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/03/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Do some things. Break my script to run it by including
 * multiple classes. Output some random strings. Use terrible, non-descriptive
 * variable names. Invoke confusion upon students as to whether they are
 * permitted to utilize the 'this' keyword.
 *
 */
public class Thing {
  private String one; // T6666666ame of thing.
  private int two; // Number? A seemingly arbitrary number.

  public Thing() { // Why no params? 😭
    one = "CAT";
    two = 5;
  }

  public String toString() {
    return String.format("<%s%d>", one, two);
  }

  public String getOne() {
    return one;
  }

  public void setOne(String o) {
    one = o;
  }

  public int getTwo() {
    return two;
  }

  public void setTwo(int t) {
    two = t;
  }

  public String someString(String hat) {
    return this + hat;
  }

}

class Main {
  public static void main(String[] args) {
    Thing three = new Thing();
    System.out.println(three);
    System.out.println(three.getOne());
    System.out.println(three.getTwo());
    three.setOne("DOG");
    three.setTwo(4);
    System.out.println(three.getOne());
    System.out.println(three.getTwo());
    System.out.println(three.someString(" IN THE HAT"));
  }
}
