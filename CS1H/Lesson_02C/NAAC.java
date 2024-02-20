/**
 * Class NAAC
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
 * WAP to calculate your NAAC, that is, your “name-age average character”, the ASCII character that
 * represents the value of the average of the ASCII values of the first three or four letters of
 * your first name, plus your age. Here are the steps you must use:
 */
class NAAC {
    public static void main(String[] args) {
        String name = "Aar"; // First 3
        String age = "17";
        char let0 = name.charAt(0);
        char let1 = name.charAt(1);
        char let2 = name.charAt(2);
        int ageInt = Integer.parseInt(age);
        int total = (int) let0 + (int) let1 + (int) let2 + ageInt;
        double average = total / 4.0;
        char NAAC = (char) average;
        System.out.printf("%s = %c + %c + %c\n", name, let0, let1, let2);
        System.out.println("Age = " + age);
        System.out.printf("%s+%s = %d + %d + %d + %d\n", name, age, (int) let0, (int) let1,
                (int) let2, ageInt);
        System.out.println("Total = " + total);
        System.out.printf("Average = %.1f\n", average);
        System.out.printf("\"%s\"s NAAC is \"%c\" the ASCII value %d\n", name, NAAC, (int) NAAC);
    }
}

/*
 * Output all the values in the format shown below in the complete output for “Neo”, age 17. Your
 * output will be different, of course, unless your name is Neo and your age is 17.
 */
