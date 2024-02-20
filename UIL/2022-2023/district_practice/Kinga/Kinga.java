import java.util.Scanner;

/**
 * Class Kinga
 *
 * <pre>
 * Author1: Aaron Dill
 * Date:	March 24, 2023
 * </pre>
 *
 * Summary of file:
 * output all permutations of a given set of {@link Boolean} values
 *
 */
public class Kinga {
    private static String getHeaderString(int count) {
        String header = "";
        for (char c = 'A'; c < (char) 'A' + count; c++)
            header += c;
        return "  " + insertEvery("|", header);

    }

    public static String padLeft(String toPad, String padWith, int length) {
        String padded = padWith.repeat(length) + toPad;
        return padded.substring(padded.length() - length);
    }

    public static String insertEvery(String separator, String insertInto) {
        return String.join(separator, insertInto.split(""));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(Kinga.class.getResourceAsStream("./kinga.dat"));
        while (input.hasNextInt()) {
            int count = input.nextInt();
            int endVal = Integer.parseInt("1".repeat(count), 2);
            System.out.println(getHeaderString(count));
            for (int i = 0; i <= endVal; i++) {
                String unsignedString = padLeft(Integer.toUnsignedString(i, 2), "0", count);
                System.out.printf("%d %s\n", i + 1, insertEvery("|", unsignedString));
            }
            System.out.println("=====");
            // .toUnsignedString
        }
    }
}
