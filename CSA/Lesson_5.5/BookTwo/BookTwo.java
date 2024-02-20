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
 * Summary of file: a book
 *
 */
class Book {
  String author;
  String title;
  int yearPub;

  public Book(String t, String a, int y) {
    title = t;
    author = a;
    yearPub = y;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public int getYearPub() {
    return yearPub;
  }

  @Override
  public String toString() {
    return String.format("%s, by %s, published in %d", title, author, yearPub);
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setYearPub(int yearPub) {
    this.yearPub = yearPub;
  }

  public Book() {
    author = null;
    title = null;
    yearPub = 0;
  }

}

class Main {
  public static void main(String[] args) {
    Book one = new Book("Little Women", "Louisa May Alcott", 1868);
    System.out.println(one);
    Book two = new Book();
    two.setAuthor("L.M. Montgomery");
    two.setTitle("Anne of Green Gables");
    two.setYearPub(1908);
    System.out.println(two);
  }
}
