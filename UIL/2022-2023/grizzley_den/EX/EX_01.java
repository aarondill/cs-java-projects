/**
 * Class EX_01
 * Alt. name: Stewie
 *
 * Team Name: Data Pirates
 * Date: November 28, 2022
 * Course: N/A
 *
 *
 * Summary of file:
 * Outputs the message 'Victory is mine!' in a box made of slashes
 *
 *
 */

class EX_01 {
    // Returns a string of count foward slashes
    private static final String fSlash(int count) {
        String r = "";
        for (int i = 0; i < count; i++) {
            r += "/";
        }
        return r;
    }

    // Returns a string of count back slashes
    private static final String bSlash(int count) {
        String r = "";
        for (int i = 0; i < count; i++) {
            r += "\\";
        }
        return r;
    }

    // returns a string consisting of msg surrounded by pipes
    private static final String message(String msg) {
        return "|| " + msg + " ||";
    }

    public static void main(String[] args) {
        System.out.println(fSlash(22));
        System.out.println(message("Victory is mine!"));
        System.out.println(bSlash(22));

    }

}
