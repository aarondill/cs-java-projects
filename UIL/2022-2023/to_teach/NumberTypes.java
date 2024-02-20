import java.io.Console;

class NumberTypes {
    private static boolean isWaiting = false;
    // This outputs a new line when interrupted during waiting
    private static Thread shutdownHook = new Thread() {
        public void run() {
            if (isWaiting)
                System.out.println();
        }
    };

    public static void clearTTY() {
        if (System.console() != null) {
            System.console().printf((char) 27 + "c");
        }
    }

    public static void waitForEnter() {
        Console c = System.console();
        if (c != null) {
            System.out.print("\nPress enter to continue. ");
            isWaiting = true;
            System.console().readPassword();
            isWaiting = false;
            System.out.println();
        }
    }

    // > Integers
    private static void byteDemo() {
        System.out.printf("%s - %s bits\n", "Byte", Byte.SIZE);
        System.out.printf("%s: %s\n", "Max Value", Byte.MAX_VALUE);
        System.out.printf("%s: %s\n", "Min Value", Byte.MIN_VALUE);
    }

    private static void intDemo() {
        System.out.printf("%s - %s bits\n", "Integer", Integer.SIZE);
        System.out.printf("%s: %s\n", "Max Value", Integer.MAX_VALUE);
        System.out.printf("%s: %s\n", "Min Value", Integer.MIN_VALUE);
    }

    private static void longDemo() {
        System.out.printf("%s - %s bits\n", "Long", Long.SIZE);
        System.out.printf("%s: %s\n", "Max Value", Long.MAX_VALUE);
        System.out.printf("%s: %s\n", "Min Value", Long.MIN_VALUE);
    }

    private static void shortDemo() {
        System.out.printf("%s - %s bits\n", "Short", Short.SIZE);
        System.out.printf("%s: %s\n", "Max Value", Short.MAX_VALUE);
        System.out.printf("%s: %s\n", "Min Value", Short.MIN_VALUE);
    }

    // > DECIMALS
    private static void doubleDemo() {
        System.out.printf("%s - %s bits\n", "Double", Double.SIZE);
        System.out.printf("%s: %s\n", "Max Value", Double.MAX_VALUE);
        System.out.printf("%s: %s\n", "Least Value", -Double.MAX_VALUE);
        System.out.printf("%s: %s\n", "Min Value", Double.MIN_VALUE);
    }

    private static void floatDemo() {
        System.out.printf("%s - %s bits\n", "Float", Float.SIZE);
        System.out.printf("%s: %s\n", "Max Value", Float.MAX_VALUE);
        System.out.printf("%s: %s\n", "Least Value", -Float.MAX_VALUE);
        System.out.printf("%s: %s\n", "Min Value", Float.MIN_VALUE);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Runtime.getRuntime().addShutdownHook(shutdownHook);
        clearTTY();
        byteDemo();
        waitForEnter();
        shortDemo();
        waitForEnter();
        intDemo();
        waitForEnter();
        longDemo();
        waitForEnter();
        floatDemo();
        waitForEnter();
        doubleDemo();
    }
}
