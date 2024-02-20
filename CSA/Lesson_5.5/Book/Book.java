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
}

class Main {
  public static void main(String[] args) {
    Book one = new Book();
    System.out.println(one);
  }
}
