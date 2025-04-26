import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

public class Veerasamy {
  @SuppressWarnings("unused")
  private static int caseNum = 1;
  private static final String INPUT_FILE = "veerasamy.dat";

  // The constructor is called on each case
  private Veerasamy(Scanner scan) {
    int numP = scan.nextInt();
    /* String conv = */ scan.next();
    scan.nextLine();
    double[] xPoint = new double[numP], yPoint = new double[numP];
    for (int i = 0; i < numP; i++) {
      xPoint[i] = scan.nextDouble();
      yPoint[i] = scan.nextDouble();
      scan.nextLine();
    }
    double xCheck = scan.nextDouble(), yCheck = scan.nextDouble();
    scan.nextLine();

    Path2D p = new Path2D.Double();
    p.moveTo(xPoint[0], yPoint[0]);
    for (int i = 1; i < numP; i++) {
      p.lineTo(xPoint[i], yPoint[i]);
    }
    p.closePath();

    Area a = new Area(p);
    boolean cont = a.contains(xCheck, yCheck);
    // Does this work? If the shape is on the top/right of the rectangle, these two check should make it work.
    if (!cont) cont = a.contains(xCheck - 0.00001, yCheck - 0.00001);

    if (cont) System.out.println("Safe and sound.");
    else System.out.println("Dreaded dimensional downgrade!");
  }

  public static void main(String... args) throws FileNotFoundException {
    try (Scanner scan = new Scanner(new File(INPUT_FILE))) {
      int dataCount = Integer.parseInt(scan.nextLine(), 10);
      for (int i = 0; i < dataCount; i++, caseNum++)
        new Veerasamy(scan);
    } catch (FileNotFoundException e) {
      System.err.println("Could not find file: " + INPUT_FILE);
      throw e;
    }
  }
}
