import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class ScannerUseDelimiter {
    private static void clearTTY() {
        if (System.console() != null) {
            char ESC = 27;
            System.console().printf(ESC + "c");
        }
    }

    /**
     * Finds all next() and closes the scanner!
     */
    private static String[] getAllNext(Scanner scan) {
        ArrayList<String> words = new ArrayList<>();
        while (scan.hasNext())
            words.add(scan.next());

        scan.close();
        return words.toArray(new String[words.size()]);
    }

    public static void main(String[] args) {
        clearTTY();
        final String inputString = "Input/String With Spaces!And!Words";
        System.out.printf("%-20s: %s\n\n", "Input", inputString);

        Scanner scan = new Scanner(inputString);
        System.out.printf("%-20s: %s\n", "Default Delimiter", scan.delimiter());
        System.out.printf("%-20s: %s\n\n", "Results", Arrays.toString(getAllNext(scan)));

        Scanner newScan = new Scanner(inputString).useDelimiter("[!/]");
        System.out.printf("%-20s: %s\n", "useDelimiter", "[/!]");
        System.out.printf("%-20s: %s\n", "Results", Arrays.toString(getAllNext(newScan)));
    }
}
