/**
 * Primary java class: StringReferences
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    10/11/2023
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 * Lab 3.1.2 –StringReferences - Write a program that creates four String
 * variables and assigns them the following values:
 * 
 * String word = "Hello";
 * String word2 = "Hello";
 * String sentence = null;
 * String str = "hello";
 * 
 * Convert the English expressions to Java code and output the following
 * comparisons using the == and != operators:
 * 
 * Test if word and sentence contain the same address (reference the same String
 * object).
 * Test if sentence is null (does not reference a String object).
 * Test if word and word2 contain the same address (reference the same String
 * object).
 * Test if word and str contain the same address (reference the same String
 * object).
 * Test if word is not null (does reference a String object).
 *
 */
public class StringReferences {
  public static void main(String... args) {
    String word = "Hello";
    String word2 = "Hello";
    String sentence = null;
    String str = "hello";

    System.out.println(word == sentence); // false
    System.out.println(sentence == null); // true
    System.out.println(word == word2); // true
    System.out.println(word == str); // false
    System.out.println(word != null); // true
  }
}
