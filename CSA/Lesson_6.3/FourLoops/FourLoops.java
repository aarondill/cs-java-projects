/**
 * Primary java class: FourLoops
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    02/01/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file: Write a program to instantiate three arrays with at least
 * five elements of your own choosing in each array:
 * 
 * an integer array a String array a double array Do an output traversal of each
 * array twice, once using a traditional loop (for loop, while loop, and do
 * while loop) and then using the enhanced for loop structure.
 * 
 * For the integer array use the traditional for loop for the first traversal
 * and use the enhanced for loop for the second traversal For the String array
 * use the traditional while loop for the first traversal and use the enhanced
 * for loop for the second traversal For the double array use the do while loop
 * for the first traversal and the enhanced for loop for the second traversal
 * Add a comment before each loop that states what the loop is doing. For
 * example the comment for outputting the double array with the do while loop
 * would be
 * 
 * // output double array using a do while loop The outputs for each array must
 * match! Include exactly one space between each array element, and start each
 * output sequence on a new line.
 *
 * 
 */
public class FourLoops {
  // returns a random integer between min (inclusive) and max (inclusive)
  private static int randomInt(int min, int max) {
    return (int) (Math.random() * (max - min) + min);
  }

  private static String randString(int minlen, int maxlen) {
    int len = (int) (Math.random() * (maxlen - minlen + 1) + minlen);
    StringBuilder sb = new StringBuilder(len);
    // Get random char between 'a' and 'z'
    for (int i = 0; i < len; i++)
      sb.append((char) randomInt('a', 'z'));
    return sb.toString();
  }

  public static void main(String... args) {
    int[] a = new int[randomInt(5, 10)];
    String[] b = new String[randomInt(5, 10)];
    double[] c = new double[randomInt(5, 10)];

    for (int i = 0; i < a.length; i++)
      a[i] = (int) (Math.random() * Math.random() * 10000);
    for (int i = 0; i < b.length; i++)
      b[i] = randString(5, 10);
    for (int i = 0; i < c.length; i++)
      c[i] = Math.random() * 100000;

    // This does the same thing
    // System.out.println(String.join(" ", java.util.Arrays.stream(a).mapToObj(String::valueOf).toArray(String[]::new)));
    // System.out.println(String.join(" ", b));
    // System.out.println(String.join(" ", java.util.Arrays.stream(c).mapToObj(String::valueOf).toArray(String[]::new)));

    // output integer array using a for loop
    for (int i = 0; i < a.length; i++)
      System.out.print(a[i] + " ");
    System.out.println();
    // output integer array using the enhanced for loop
    for (int num : a)
      System.out.print(num + " ");
    System.out.println();

    // output String array using a while loop
    {
      int i = 0;
      while (i < b.length)
        System.out.print(b[i++] + " ");
      System.out.println();
    }
    // output String array using the enhanced for loop
    for (String s : b)
      System.out.print(s + " ");
    System.out.println();

    // output double array using a do while loop
    {
      int i = 0;
      do {
        System.out.print(c[i++] + " ");
      } while (i < c.length);
      System.out.println();
    }
    // output double array using the enhanced for loop
    for (double d : c)
      System.out.print(d + " ");
    System.out.println();

  }
}
