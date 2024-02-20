/**
 * Primary java class: MyString
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/11/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: A string
 *
 */
public class MyString {
  private String s;

  public MyString(String s) {
    this.s = s;
    printMyString(this);
  }

  public String getS() {
    return s;
  }

  public void printMyString(MyString ms) {
    System.out.println(ms.getS());
  }

  public String reverse() {
    String s = "";
    for (int i = this.s.length() - 1; i >= 0; i--)
      s += this.s.substring(i, i + 1);
    return s;
  }

  public static void main(String[] args) {
    MyString s = new MyString("computer");
    System.out.println(s.reverse());
  }
}
