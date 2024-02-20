/**
 * Class Lab2A1
 *
 *
 * Author1: Aaron Dill
 * Author2: None
 * Date: January 20, 2023
 * Course: Computer Science I Honors
 *
 *
 * Summary of file:
 * Create the given output using a constant for YOUR full name and a variable
 * for YOUR age. Indent output 10 spaces from left margin (first character in
 * column 11).
 *
 *
 */
class Lab2A1 {
    public static void main(String[] args) {
        final String NAME = "Aaron Dill";
        final int AGE = 16;
        System.out.println("****.****.****.");
        System.out.printf("%9s My name is %s.\n", "", NAME);
        System.out.printf("%9s My age is %d.\n", "", AGE);
    }
}
