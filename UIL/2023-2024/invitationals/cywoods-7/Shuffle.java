import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Shuffle {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("shuffle.dat"));

        int numIn = in.nextInt();
        in.nextLine();
        for (int fun = 0; fun < numIn; fun++) {

            String[] words = in.nextLine().split(" ");
            int numShift = Integer.parseInt(words[words.length-1]);

            ArrayList<String> wordList = new ArrayList<>();
            for (int i = 0; i < words.length-1; i++) {
                wordList.add(words[i]);
            }

            if (numShift > 0) {
                for (int a = 0; a < numShift; a++) {
                    wordList.add(0, wordList.remove(wordList.size()-1));
                }
            } else {
                numShift = -numShift;
                for (int a = 0; a < numShift; a++) {
                    wordList.add(wordList.remove(0));
                }
            }

            for (String word : wordList) {
                System.out.print(word + " ");
            }
            System.out.println();
        }

    }

}
