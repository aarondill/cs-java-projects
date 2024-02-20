import java.time.LocalDate;

public class file {
  public static void main(String[] args) {
    System.out.println(LocalDate.parse("2011-09-11").getDayOfWeek().toString());
  }
}
