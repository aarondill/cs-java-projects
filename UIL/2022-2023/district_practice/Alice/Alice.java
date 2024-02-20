/**
 * Class Alice
 *
 * <pre>
 * Author1: Aaron Dill
 * Date:	March 24, 2023
 * </pre>
 *
 * Summary of file:
 * output the pattern requested
 *
 */

public class Alice {
    public static void main(String[] args) {
        String INDENT = " ".repeat(11);
        System.out.println(INDENT + "&".repeat(1));
        System.out.println(INDENT + "&".repeat(2));
        System.out.println(INDENT + "&".repeat(3));
        System.out.println(INDENT + "&".repeat(2) + "-".repeat(1) + "&");
        System.out.println(INDENT + "&".repeat(2) + "-".repeat(2) + "&");
        System.out.println(INDENT + "&".repeat(2) + "-".repeat(3) + "&");
        System.out.println(INDENT + "&".repeat(2) + "-".repeat(4) + "&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(1) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(2) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(3) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(4) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(5) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(6) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(7) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(8) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(9) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(10) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(11) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(12) + "--&");
        System.out.println(INDENT + "&".repeat(2) + "--" + ".".repeat(13) + "--&");
        System.out.println(INDENT + " || " + " ".repeat(13 + 5) + "\\o/ ");
        System.out.println(INDENT + " || " + " ".repeat(13 + 5) + " | ");
        System.out.println(" " + "=".repeat(38));
        System.out.println(" ".repeat(3) + "=".repeat(38 - (2 * 2)));
        System.out.println("^".repeat(40));
    }
}
