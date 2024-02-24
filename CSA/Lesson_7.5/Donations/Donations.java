import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Primary java class: Donations
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/23/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 * This program should print a list of donors names and the dollar amount each
 * has donated sorted in descending (most to least) order based on the amount.
 * The names and amounts will be stored in a file named donors.dat Download
 * donors.datwhere each donor's name and amount is on a separate line and
 * separated by a space. Your program must include a class name Donor that has
 * two instance fields, name and amount. Include an appropriate constructor and
 * the necessary accessor and mutator methods for the fields and a toString
 * method. The main method within the Donations class should read each line of
 * the data and construct a Donor object and place each Donor object into an
 * ArrayList whose type is Donor. Modify either a selection or insertion sort
 * from this lesson so that it will sort a list of donors in descending (largest
 * to smallest) order based on the amount. There is no starter file for this
 * programming problem. Here is a sample run:
 * 
 * 
 */
class Donor implements Comparable<Donor> {
  double amount;
  String name;

  public Donor(String name, double amount) {
    this.name = name;
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Donor o) {
    return Double.compare(o.amount, this.amount);
  }

  @Override
  public String toString() {
    return name + " " + amount;
  }
}

public class Donations {
  public static void main(String... args) throws IOException {
    List<Donor> donors = new ArrayList<>();
    try (Stream<String> lines = Files.lines(Path.of("./donors.dat"))) {
      lines.map(x -> x.split(" ")).map(l -> {
        double amount = Double.parseDouble(l[1]);
        String name = l[0];
        return new Donor(name, amount);
      }).forEach(donors::add);
    }
    selectionSortDescending(donors).forEach(System.out::println);
  }

  private static <T extends Comparable<T>> List<T> selectionSortDescending(List<T> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      int largest = i;
      for (int j = i + 1; j < list.size(); j++)
        if (list.get(i).compareTo(list.get(j)) > 0) largest = j;
      // Using Collections.swap just eliminates the need for the temp variable
      Collections.swap(list, i, largest);
    }
    return list;
  }
}
