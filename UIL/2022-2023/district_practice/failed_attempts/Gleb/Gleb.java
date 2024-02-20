import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class Gleb
 *
 * <pre>
 * Author1: Aaron Dill
 * Date:	March 24, 2023
 * </pre>
 *
 * Summary of file:
 * Output the music notes for a song with the specified syntax
 * 
 * @deprecated: <b>THIS DOESN'T WORK! I MISREAD THE INSTRUCTIONS.</b>
 */
public class Gleb {
    final static ArrayList<String> noteIndex = new ArrayList<>(Arrays.asList("C", "D", "E", "F", "G", "A", "B"));

    private static int getIndex(int i) {
        int SIZE = noteIndex.size();
        if (i > 0) {
            return i % SIZE;
        } else {
            return (SIZE - (Math.abs(i) % SIZE)) % SIZE;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(Gleb.class.getResourceAsStream("./gleb.dat"));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            int currNoteIndex = noteIndex.indexOf(line.substring(0, 1));
            while (lineScan.hasNextInt()) {
                System.out.println(noteIndex.get(currNoteIndex));
                int i = lineScan.nextInt();
                currNoteIndex = getIndex(currNoteIndex + i);
            }
            lineScan.close();
        }
        input.close();
    }
}
