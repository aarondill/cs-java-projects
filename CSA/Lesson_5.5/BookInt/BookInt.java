/**
 * Primary java class: Book
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    01/05/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: a Book and an Int
 *
 */
class Int {
  private int val;

  // We *should* have a `public Int(Int v)` constructor, but whatever

  public Int() {
    val = 0;
  }

  public Int(int v) {
    val = v;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int value) {
    this.val = value;
  }

  @Override
  public String toString() {
    return "" + val;
  }

}

class Book {
  String author;
  String title;
  Int yearPub;

  public Book(String t, String a, int y) {
    title = t;
    author = a;
    yearPub = new Int(y);
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public Int getYearPub() {
    return new Int(yearPub.getVal()); // this is painful
  }

  @Override
  public String toString() {
    return String.format("%s, by %s, published in %s", title, author, yearPub);
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setYearPub(Int yearPub) {
    this.yearPub = yearPub;
  }

  public Book() {
    author = null;
    title = null;
    yearPub = new Int(0);
  }

}

class Main {
  public static void main(String[] args) {
    Book one = new Book("Little Women", "Louisa May Alcott", 1868);
    System.out.println(one);

    Book two = new Book();
    two.setAuthor("L.M. Montgomery");
    two.setTitle("Anne of Green Gables");
    Int year = one.getYearPub();
    year.setVal(year.getVal() + 40);
    two.setYearPub(year);
    System.out.println(one);
    System.out.println(two);
  }
}
