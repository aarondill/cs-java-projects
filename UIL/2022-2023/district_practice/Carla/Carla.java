import java.util.Scanner;

/**
 * Class Carla
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Date:	March 23, 2023
 * </pre>
 *
 * Summary of file:
 * output the permissions of a unix filesystem based on the octal permission
 * values
 */
public class Carla {
    private static String getBin(String perm) {
        Integer b = Integer.parseInt(perm, 8);
        String binString = "000" + Integer.toBinaryString(b);
        return (binString).substring(binString.length() - 3);
    }

    private static String getPerm(String perm) {
        String bin = getBin(perm);
        String[] perms = { "r", "w", "x" };
        String[] res = new String[3];
        for (int i = 0; i < bin.length(); i++) {
            char p = bin.charAt(i);
            if (p == '0')
                res[i] = "-";
            else
                res[i] = perms[i];
        }
        return String.join("", res);
    }

    public static void main(String[] args) {
        String datPath = "carla.dat";
        Scanner scan = new Scanner(Carla.class.getResourceAsStream(datPath));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            char type = Character.toLowerCase(line.charAt(0));
            if (type == 'f')
                System.out.print("-");
            else
                System.out.print(type);
            for (String p : line.substring(1).split("")) {
                System.out.print(getPerm(p));
            }
            System.out.println();
        }
    }
}
