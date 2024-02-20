/**
 * Class EX_05
 * Alt. name: Stewie2
 *
 * Team Name: Data Pirates
 * Date: November 28, 2022
 * Course: N/A
 *
 *
 * Summary of file:
 * Outputs a message stating 'Victory is mine!' repeatedly, seperated by
 * backslashes
 *
 */

class EX_05 {
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
        for (int i = 0; i < 5; i++) {
            System.out.println(message("Victory is mine!"));
            System.out.println(bSlash(22));
        }
    }
}
