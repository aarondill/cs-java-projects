public class OrderOperations {
    private static void clearTTY() {
        if (System.console() != null) {
            char ESC = 27;
            System.console().printf(ESC + "c");
        }
    }

    private static void technically() {
        final String INDENT = "";
        final String FORMAT_STRING = "%s:\n%10s%s\n";
        System.out.printf(FORMAT_STRING, "parentheses, array access, member access", INDENT, "() [] .");
        System.out.printf(FORMAT_STRING, "post-increment, post-decrement", INDENT, "++ --");
        System.out.printf(FORMAT_STRING,
                "plus, minus, NOT, pre-increment, pre-decrement", INDENT, "! ~ + - ++ --");
        System.out.printf(FORMAT_STRING, "cast, instantiation", INDENT, "() new");
        System.out.printf(FORMAT_STRING, "multiplicative", INDENT, "* / %");
        System.out.printf(FORMAT_STRING, "additive", INDENT, "+ -");
        System.out.printf(FORMAT_STRING, "shift", INDENT, "<< >> >>>");
        System.out.printf(FORMAT_STRING, "relational", INDENT, "< <= > >= instanceof");
        System.out.printf(FORMAT_STRING, "equality", INDENT, "== !=");
        System.out.printf(FORMAT_STRING, "bitwise AND", INDENT, "&");
        System.out.printf(FORMAT_STRING, "bitwise XOR", INDENT, "^");
        System.out.printf(FORMAT_STRING, "bitwise OR", INDENT, "|");
        System.out.printf(FORMAT_STRING, "logical AND", INDENT, "&&");
        System.out.printf(FORMAT_STRING, "logical OR", INDENT, "||");
        System.out.printf(FORMAT_STRING, "ternary", INDENT, "?:");
        System.out.printf(FORMAT_STRING, "assignment", INDENT, "= += -= *= /= %= &= ^= |= <<= >>= >>>=");
        System.out.printf(FORMAT_STRING, "lambda arrow", INDENT, "->");
    }

    private static void mnemonic() {
        System.out.println("UMBREBLA");
        System.out.println("Unary (post, then pre)");
        System.out.println("Math (PEMDAS)");
        System.out.println("Bit-shift");
        System.out.println("Relational");
        System.out.println("Equality");
        System.out.println("Bitwise (AND XOR OR)");
        System.out.println("Logical (AND OR)");
        System.out.println("Assignment");
    }

    public static void main(String[] args) {
        clearTTY();
        technically();
        System.out.println();
        mnemonic();
    }
}
