/**
 * Class Lab2B2
 *
 * <pre>
 * Author1:	Aaron Dill
 * Date:	January 30, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 * 
 * Summary of file: Write a program to output the following, using character variables, equivalent
 * integer values, with printf formatting techniques.
 * 
 * <pre>
 * ****.***
 *        A  A  R  O  N
 *        65 65 82 79 78
 *        369
 * </pre>
 */
class Lab2B2 {
    public static void main(String[] args) {
        final char char1 = 'A', char2 = 'A', char3 = 'R', char4 = 'O', char5 = 'N';
        int result = char1 + char2 + char3 + char4 + char5;
        System.out.println("****.***");
        System.out.printf("%7s%c  %c  %c  %c  %c\n", "", char1, char2, char3, char4, char5);
        System.out.printf("%7s%d %d %d %d %d\n", "", (int) char1, (int) char2, (int) char3,
                (int) char4, (int) char5);
        System.out.printf("%7s%d\n", "", result);
    }
}
