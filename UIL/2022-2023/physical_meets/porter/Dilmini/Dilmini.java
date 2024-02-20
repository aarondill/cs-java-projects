/**
 * Class Dilmini
 *
 * <pre>
 * Author1: Aaron Dill
 * Author2: Dylan Lafferty
 * Author3: Evan Sao
 * Date:	February 11, 2023
 * </pre>
 *
 * Summary of file: output image of phone as shone
 *
 */
class Dilmini {
    public static void main(String[] args) {
        String r = "_".repeat(10) + "$".repeat(10) + "\n";
        r += "_".repeat(9) + "$" + "_".repeat(9) + "$$" + "\n";
        r += "_".repeat(9) + "$_" + "$".repeat(7) + "_$$" + "\n";// s
        r += "_".repeat(9) + "$_$" + "_".repeat(5) + "$_$$" + "\n";
        r += "_".repeat(9) + "$_$" + "_".repeat(5) + "$_$$" + "\n";
        r += "_".repeat(9) + "$_$" + "_".repeat(5) + "$_$$" + "\n";
        r += "_".repeat(9) + "$_$" + "_".repeat(5) + "$_$$" + "\n";
        r += "_".repeat(9) + "$_" + "$".repeat(7) + "_$$" + "\n";
        r += "_".repeat(9) + "$_" + "_".repeat(7) + "_$$" + "\n";
        r += "_".repeat(10) + "$".repeat(10) + "\n";
        r += "_".repeat(9) + "$" + "_".repeat(9) + "$$" + "\n";// s
        r += "_".repeat(9 - 1) + "$" + "_1__2__3_" + "$".repeat(3) + "\n";
        r += "_".repeat(9 - 2) + "$" + "_4__5__6_" + "$".repeat(3) + "\n";
        r += "_".repeat(9 - 3) + "$" + "_7__8__9_" + "$".repeat(3) + "\n";
        r += "_".repeat(9 - 4) + "$" + "_*__0__#_" + "$".repeat(3) + "\n";
        r += "_".repeat(9 - 5) + "$" + "_".repeat(9) + "$$$" + "\n";// s
        r += "_".repeat(9 - 4) + "$".repeat(11) + "\n";// s
        r += "_".repeat(9 - 3) + "$".repeat(9) + "\n";// s

        System.out.println(r);
    }
}
