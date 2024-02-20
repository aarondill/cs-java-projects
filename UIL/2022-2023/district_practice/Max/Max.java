import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class Max
 *
 * <pre>
 * Author1: Aaron Dill
 * Date:	March 25, 2023
 * </pre>
 *
 * Summary of file:
 * Output a string representation of the input based on the NATO phonetic
 * alphabet
 */
public class Max {
    static Map<String, String> alphabet = new HashMap<String, String>();
    static {
        alphabet.put("A", "Alpha");
        alphabet.put("B", "Bravo");
        alphabet.put("C", "Charlie");
        alphabet.put("D", "Delta");
        alphabet.put("E", "Echo");
        alphabet.put("F", "Foxtrot");
        alphabet.put("G", "Golf");
        alphabet.put("H", "Hotel");
        alphabet.put("I", "India");
        alphabet.put("J", "Juliet");
        alphabet.put("K", "Kilo");
        alphabet.put("L", "Lima");
        alphabet.put("M", "Mike");
        alphabet.put("N", "November");
        alphabet.put("O", "Oscar");
        alphabet.put("P", "Papa");
        alphabet.put("Q", "Quebec");
        alphabet.put("R", "Romeo");
        alphabet.put("S", "Sierra");
        alphabet.put("T", "Tango");
        alphabet.put("U", "Uniform");
        alphabet.put("V", "Victor");
        alphabet.put("W", "Whiskey");
        alphabet.put("X", "Xray");
        alphabet.put("Y", "Yankee");
        alphabet.put("Z", "Zulu");
        alphabet.put("0", "Zero");
        alphabet.put("1", "Wun");
        alphabet.put("2", "Too");
        alphabet.put("3", "Tree");
        alphabet.put("4", "Fower");
        alphabet.put("5", "Fife");
        alphabet.put("6", "Six");
        alphabet.put("7", "Seven");
        alphabet.put("8", "Ait");
        alphabet.put("9", "Niner");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(Max.class.getResourceAsStream("./max.dat"));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String r = String.join(" ", (Arrays.stream(line.split("")).map(s -> alphabet.get(s)).toList()));
            System.out.println(r);
        }
    }
}
