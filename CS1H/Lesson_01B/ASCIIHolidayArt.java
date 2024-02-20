import java.util.Scanner;

/**
 * class ASCIIHolidayArt
 * 
 * Author1: Aaron Dill
 * Author2:
 * Date: 11/28/22
 * Course: Computer Science I Honors
 * 
 * Summary of file:
 * Output an ASCII christmas tree according to use input
 * 
 *
 */

public class ASCIIHolidayArt {
        private static String[] generateOptions() {
                String str1 = String.join("\n",
                                "         |", "        -+-", "         A",
                                "        /=\\               /\\  /\\    ___  _ __  _ __ __    __",
                                "      i/ O \\i            /  \\/  \\  / _ \\| '__|| '__|\\ \\  / /",
                                "      /=====\\           / /\\  /\\ \\|  __/| |   | |    \\ \\/ /",
                                "      /  i  \\           \\ \\ \\/ / / \\___/|_|   |_|     \\  /",
                                "    i/ O * O \\i                                       / /",
                                "    /=========\\        __  __                        /_/    _",
                                "    /  *   *  \\        \\ \\/ /        /\\  /\\    __ _  ____  | |",
                                "  i/ O   i   O \\i       \\  /   __   /  \\/  \\  / _` |/ ___\\ |_|",
                                "  /=============\\       /  \\  |__| / /\\  /\\ \\| (_| |\\___ \\  _",
                                "  /  O   i   O  \\      /_/\\_\\      \\ \\ \\/ / / \\__,_|\\____/ |_|",
                                "i/ *   O   O   * \\i", "/=================\\", "       |___| ");
                String str2 = String.join("\n",
                                "      /\\      ",
                                "     /\\*\\     ",
                                "    /\\O\\*\\    ",
                                "   /*/\\/\\/\\   ",
                                "  /\\O\\/\\*\\/\\  ",
                                " /\\*\\/\\*\\/\\/\\ ",
                                "/\\O\\/\\/*/\\/O/\\",
                                "      ||      ",
                                "      ||      ",
                                "      ||      ",
                                "");
                String str3 = String.join("\n",
                                "         * ",
                                "        /|\\                  ",
                                "       /*|O\\",
                                "      /*/|\\*\\",
                                "     /X/O|*\\X\\",
                                "    /*/X/|\\X\\*\\",
                                "   /O/*/X|*\\O\\X\\             ",
                                "  /*/O/X/|\\X\\O\\*\\",
                                " /X/O/*/X|O\\X\\*\\O\\",
                                "/O/X/*/O/|\\X\\*\\O\\X\\",
                                "        |X|      ",
                                "        |X|    ");
                String str4 = String.join("\n",
                                "   *    *  ()   *   *",
                                "*        * /\\         *",
                                "      *   /i\\\\    *  *",
                                "    *     o/\\\\  *      *",
                                " *       ///\\i\\    *",
                                "     *   /*/o\\\\  *    *",
                                "   *    /i//\\*\\      *",
                                "        /o/*\\\\i\\   *",
                                "  *    //i//o\\\\\\\\     *",
                                "    * /*////\\\\\\\\i\\*",
                                " *    //o//i\\\\*\\\\\\   *",
                                "   * /i///*/\\\\\\\\\\o\\   *",
                                "  *    *   ||     *     ");
                String str5 = String.join("\n",
                                "          .     .  .      +     .      .          .",
                                "     .       .      .     #       .           .",
                                "        .      .         ###            .      .      .",
                                "      .      .   \"#:. .:##\"##:. .:#\"  .      .",
                                "          .      . \"####\"###\"####\"  .",
                                "       .     \"#:.    .:#\"###\"#:.    .:#\"  .        .       .",
                                "  .             \"#########\"#########\"        .        .",
                                "        .    \"#:.  \"####\"###\"####\"  .:#\"   .       .",
                                "     .     .  \"#######\"\"##\"##\"\"#######\"                  .",
                                "                .\"##\"#####\"#####\"##\"           .      .",
                                "    .   \"#:. ...  .:##\"###\"###\"##:.  ... .:#\"     .",
                                "      .     \"#######\"##\"#####\"##\"#######\"      .     .",
                                "    .    .     \"#####\"\"#######\"\"#####\"    .      .",
                                "            .     \"      000      \"    .     .",
                                "       .         .   .   000     .        .       .",
                                ".. .. ..................O000O........................ ...... ...");
                String str6 = String.join("\n",
                                "             /\\",
                                "            <  >",
                                "             \\/",
                                "             /\\",
                                "            /  \\",
                                "           /++++\\",
                                "          /  ()  \\",
                                "          /      \\",
                                "         /~\\`~\\`~\\`~\\`\\",
                                "        /  ()  ()  \\",
                                "        /          \\",
                                "       /*&*&*&*&*&*&\\",
                                "      /  ()  ()  ()  \\",
                                "      /              \\",
                                "     /++++++++++++++++\\",
                                "    /  ()  ()  ()  ()  \\",
                                "    /                  \\",
                                "   /~\\`~\\`~\\`~\\`~\\`~\\`~\\`~\\`~\\`~\\`\\",
                                "  /  ()  ()  ()  ()  ()  \\",
                                "  /*&*&*&*&*&*&*&*&*&*&*&\\",
                                " /                        \\",
                                "/,.,.,.,.,.,.,.,.,.,.,.,.,.\\",
                                "           |   |",
                                "          |\\`\\`\\`\\`\\`|",
                                "          \\_____/ ");
                return new String[] { str1, str2, str3, str4, str5, str6 };
        }

        private static int getUserOpt(int min, int max) {
                Scanner sn = new Scanner(System.in);
                int opt = min - 1;
                while (true) {
                        System.out.print("Pick an option between 1 and 6: ");
                        if (sn.hasNextInt())
                                opt = sn.nextInt();
                        if (opt >= min && opt <= max)
                                break;

                        System.out.println("Please pick a valid option");
                        sn.nextLine();
                }
                sn.close();
                return opt;
        }

        public static void main(String[] args) {
                // store user choice in variable
                int opt = getUserOpt(1, 6);
                String[] options = generateOptions();
                // get option to print by subtracting one from opt
                String print = options[opt - 1];
                // make tree and message stand out further
                System.out.println("\n\n\n\n");

                // remind the user of the option chosen
                System.out.println("Christmas tree number " + opt + ":");
                // print the tree
                System.out.println(print);
        }
}
