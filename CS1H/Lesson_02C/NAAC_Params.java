/**
 * Class NAAC_Params
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
class NAAC_Params {
    public static void main(String[] args) {
        if (args[0].equals("--help")) {
            System.out.println("NAAC_Params [NAME] [AGE]. Only first three of name!");
        }

        String name = args[0]; // First 3
        String age = args[1];
        String[] chars = name.split("");
        int ageInt = Integer.parseInt(age);
        double total = ageInt;
        for (String c : chars) {
            total += c.charAt(0);
        }
        double average = total / name.length() + 1;
        char NAAC = (char) average;
        String charIntString = "";
        for (int i = 0; i < name.length(); i++) {
            charIntString += ((int) name.charAt(i)) + " + ";
        }


        System.out.printf("%s = %s\n", name, String.join(" + ", chars));
        System.out.println("Age = " + age);
        System.out.printf("%s+%s = %s%d\n", name, age, charIntString, ageInt);
        System.out.println("Total = " + total);
        System.out.printf("Average = %.1f\n", average);
        System.out.printf("\"%s\"s NAAC is \"%c\" the ASCII value %d\n", name, NAAC, (int) NAAC);
    }
}

/*
 * Output all the values in the format shown below in the complete output for “Neo”, age 17. Your
 * output will be different, of course, unless your name is Neo and your age is 17.
 */
