import java.util.Scanner;

public class Shivam {
  private static int[] parseme(String data) {
    data = data.substring(data.indexOf("=") + 1);
    int endSquare = (data.indexOf("x^2"));
    String x2str = data.substring(0, endSquare);
    if (x2str.length() == 0) x2str = "1";

    int x2 = Integer.parseInt(x2str);
    data = data.substring(endSquare + 3);

    String[] parts = data.split("x");
    int x, c;
    if (parts.length == 2) {
      x = Integer.parseInt(parts[0]);
      c = Integer.parseInt(parts[1]);
    } else if (data.length() == 0) {
      x = 0;
      c = 0;
    } else if (!data.contains("x")) {
      x = 0;
      c = Integer.parseInt(data);
    } else {
      c = 0;
      if (parts[0].length() == 0) parts[0] = "1";
      x = Integer.parseInt(parts[0]);
    }
    return new int[] {x2, x, c};
  }

  public static void main(String... args) {
    try (Scanner dataScanner = new Scanner(Shivam.class.getResourceAsStream("./shivam.dat"))) {
      int dataCount = dataScanner.nextInt();
      dataScanner.nextLine();
      for (int i = 0; i < dataCount; i++) {
        String data = dataScanner.nextLine();
        int[] parsed = parseme(data);
        int a = parsed[0];
        int b = parsed[1];
        int c = parsed[2];

        System.out.print("Function " + (i + 1) + ": There ");
        if (Math.pow(b, 2) - 4 * a * c < 0) System.out.print("are no real roots to the function");
        else if (Math.pow(b, 2) - 4 * a * c == 0) {
          double rootx = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
          String root = String.format("(%.2f,0.00)", rootx == -0 ? 0 : rootx);
          System.out.print("is one real root at " + root);
        } else {
          double rootx1 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
          double rootx2 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
          if (rootx1 > rootx2) {
            double temp = rootx1;
            rootx1 = rootx2;
            rootx2 = temp;
          }
          String root1 = String.format("(%.2f,0.00)", rootx1 == -0 ? 0 : rootx1);
          String root2 = String.format("(%.2f,0.00)", rootx2 == -0 ? 0 : rootx2);
          System.out.print("are two real roots at " + root1 + " and " + root2);
        }

        System.out.println(".");
      }
    }

  }
}
