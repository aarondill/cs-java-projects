import java.util.Scanner;

/**
 * Class Lab4B1
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   May 04, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file: Lab name: Salutations
 * 
 * Expand the String switch example given in the lesson to include the language
 * selections given, plus three more of your own choosing. Use Google Translate,
 * or any other suitable source to find three other languages to use as selector
 * values.
 * 
 * Use data file input instead of keyboard, with “lab4b5.in” as the data file.
 * Put enough data, in random order, so that all possible outputs will be shown,
 * including the default English greeting.
 */
public class Lab4B5 {
  public static void main(String[] args) {
    // This closes the scanner
    try (Scanner f =
        new Scanner(Lab4B5.class.getResourceAsStream("./lab4b5.in"))) {
      while (f.hasNextLine()) {
        String line = f.nextLine();
        switch (line) {
          case "Spanish":
            System.out.println("¡Hola Mundo!");
            break;
          case "Italian":
            System.out.println("Ciao mondo!");
            break;
          case "Swahili":
            System.out.println("Salamu, Dunia!");
            break;
          case "Esperanto":
            System.out.println("Saluton Mondo!");
            break;
          case "German":
            System.out.println("Hallo Welt!");
            break;
          case "French":
            System.out.println("Bonjour le monde!");
            break;
          case "Portuguese":
            System.out.println("Olá Mundo!");
            break;
          case "Russian":
            System.out.println("Привет, мир!");
            break;
          case "Chinese":
            System.out.println("你好世界！");
            break;
          default:
            System.out.println("Hello World!");
            break;
        }

      }
    }
  }
}
