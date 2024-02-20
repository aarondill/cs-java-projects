import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Priyanka
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Daniel Behringer
 * Author4: Christian Adusei
 * Date:	February 08, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * Move the vowels of a input word to the beginning of the word in reverse
 * alphabetical order, then
 * the consonants to the end in alphabetical order. If the new string equals the
 * old, output
 * "WOO-HOO " followed by the word, else just the word.
 *
 */
class Priyanka {
    private static String findMatches(String word, Pattern pattern) {
        Matcher vowelsMatcher = pattern.matcher(word);
        String vowels = "";
        while (vowelsMatcher.find()) {
            vowels += vowelsMatcher.group();
        }
        return vowels;
    }

    private static String sortWord(String originalWord) {
        Pattern vowelsRegexPattern = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);
        String vowels = findMatches(originalWord, vowelsRegexPattern);
        Pattern consonantRegexPattern = Pattern.compile("[^aeiou]", Pattern.CASE_INSENSITIVE);
        String consonants = findMatches(originalWord, consonantRegexPattern);

        List<String> sortedVowels = Arrays.asList(vowels.split(""));
        sortedVowels.sort(null);
        String reverseSortedVowels = "";
        for (int i = sortedVowels.size() - 1; i >= 0; i--) {
            reverseSortedVowels += sortedVowels.get(i);
        }

        List<String> sortedConsonantsList = Arrays.asList(consonants.split(""));
        sortedConsonantsList.sort(null);
        String sortedConsonants = "";
        for (String c : sortedConsonantsList)
            sortedConsonants += c;

        return reverseSortedVowels + sortedConsonants;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner dataScanner = new Scanner(new File("./priyanka.dat"));
        int dataCount = dataScanner.nextInt();
        dataScanner.nextLine();
        for (int i = 0; i < dataCount; i++) {
            String word = dataScanner.nextLine();
            String sortedWord = sortWord(word);
            System.out.println((sortedWord.equals(word) ? "WOO-HOO " : "") + sortedWord);
        }
    }
}
