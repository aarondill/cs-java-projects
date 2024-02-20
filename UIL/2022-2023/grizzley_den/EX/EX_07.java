/**
 * Class EX_07
 * Alt. name: EggStop
 *
 * Team Name: Data Pirates
 * Date: November 28, 2022
 * Course: N/A
 *
 *
 * Summary of file:
 * Output a repeatative pattern including a stop sign
 *
 */
class EX_07 {
    // Prints the top three rows of the 'egg'
    private static void print_top() {
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("/         \\");
    }

    // prints the bottom two rows of the 'egg'
    private static void print_bottom() {
        System.out.println("\\         /");
        System.out.println(" \\_______/");
    }

    // Prints a pipe, followed by msg, and ending with another pipe, with msg
    // centered between the pipes. The total length of the output is totalWidth
    private static void print_message(String msg, int totalWidth) {
        System.out.print("|");
        int spacing = totalWidth - 2 - msg.length();
        int rightSpacing = spacing / 2;
        int leftSpacing = spacing - rightSpacing;
        for (int i = 0; i < leftSpacing; i++)
            System.out.print(" ");
        System.out.print(msg);
        for (int i = 0; i < rightSpacing; i++)
            System.out.print(" ");
        System.out.print("|");
        System.out.println();
    }

    // prints a seperator line made of a plus on either side of a row of dashes
    // beginning spacing distance from the left side and
    // continuing for total width charectors
    private static void print_seperator(int spacing, int totalWidth) {
        for (int i = 0; i < spacing; i++)
            System.out.print(" ");
        int dashes = totalWidth - 2;
        System.out.print("+");
        for (int i = 0; i < dashes; i++)
            System.out.print('-');
        System.out.println("+");
    }

    public static void main(String[] args) {
        print_top();
        print_bottom();
        print_bottom();
        print_seperator(1, 9);
        print_top();
        print_message("Stop", 11);
        print_bottom();
        print_top();
        print_seperator(0, 11);
    }
}
