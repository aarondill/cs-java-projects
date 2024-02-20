/**
 * Class EX_06
 * Alt. name: Lanterns
 *
 * Team Name: Data Pirates
 * Date: November 28, 2022
 * Course: N/A
 *
 *
 * Summary of file:
 * Output a pattern appearing similar to a lantern
 *
 */
class EX_06 {
    private static final int MAXWIDTH = 13;

    // prints a static width pyramid
    private static void print_pyr() {
        System.out.println("    *****");
        System.out.println("  *********");
        System.out.println("*************");
    }

    // prints a star followed by 5 pipes and spaces and a final star
    private static void print_bar_row() {
        System.out.println("* | | | | | *");
    }

    // prints a row consisting of count stars, centered using MAXWIDTH
    private static void print_star_row(int count) {
        int spacing = (MAXWIDTH - count) / 2;
        for (int i = 0; i < spacing; i++)
            System.out.print(" ");
        for (int i = 0; i < count; i++)
            System.out.print("*");
        System.out.println();
    }

    public static void main(String[] args) {
        print_pyr();
        System.out.println();
        print_pyr();
        print_bar_row();
        print_star_row(13);
        print_pyr();
        System.out.println();
        print_pyr();
        print_star_row(5);
        print_bar_row();
        print_bar_row();
        print_star_row(5);
        print_star_row(5);
    }
}
