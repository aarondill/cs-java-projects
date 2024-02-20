/**
 * Class BirthdayMagicNoVars
 *
 * <pre>
 * Author:	Aaron Dill
 * Date:	February 15, 2023
 * Course:	Computer Science I Honors
 * Period:	4th
 * </pre>
 *
 * Summary of file:
 * 
 * Write a program to do the classic “Birthday Magic” calculation, which correctly calculates your
 * birthday as a large integer value. The steps are listed below. Use the shortcut operations you
 * learned in this lesson to accomplish this task. Below is the first part of the program to help
 * get you started.
 * 
 */
class BirthdayMagicNoVars {
    public static void main(String[] args) {
        int magic = 4; // Birth month
        magic += 18;
        magic *= 25;
        magic -= 333;
        magic *= 8;
        magic -= 554;
        magic /= 2;
        magic += 14; // Birth date
        magic *= 5;
        magic += 692;
        magic *= 20;
        magic += 06; // Birth year
        magic -= 32940;

        System.out.println(magic);
        System.out.printf("%d/", magic / 10_000);
        magic %= 10_000;
        System.out.printf("%d/", magic / 100);
        magic %= 100;
        System.out.printf("%02d\n", magic);
    }
}
