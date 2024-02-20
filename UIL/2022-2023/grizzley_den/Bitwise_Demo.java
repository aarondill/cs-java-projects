import java.io.Console;
import java.util.Arrays;

/**
 * Class Bitwise_Demo
 *
 * <pre>
 * Author1: Aaron Dill
 * Date:	February 22, 2023
 * </pre>
 *
 * Summary of file:
 * 
 * Demonstrates the bitwise operators by converting a number to binary and doing bit operators on
 * them
 *
 */

class Bitwise_Demo {
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

    public static String padLeftZeros(String inputString) {
        return padLeftZeros(inputString, 32);
    }

    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

    public static void rightShiftDemo(int num) {
        clearTTY();
        System.out.println("Right shift (signed and unsigned): \n");
        // Convert the number to binary
        String binNum = padLeftZeros(Integer.toBinaryString(num));

        // Shift right using both shifts, and pad with zeros
        String numShift1Bin = padLeftZeros(Integer.toBinaryString(num >> 1));
        String numUnsignedShift1Bin = padLeftZeros(Integer.toBinaryString(num >>> 1));

        // Shift right twice using both shifts, and pad with zeros
        String numShift2Bin = padLeftZeros(Integer.toBinaryString(num >> 2));
        String numUnsignedShift2Bin = padLeftZeros(Integer.toBinaryString(num >>> 2));

        // Find the longest string to make the formatting nice
        int longest = (num + " >>> 2").length();
        String formatString = "%-" + longest + "s : %32s = %d\n";

        // Output the number, the number shifted once, and shifted twice, using both shifts.
        System.out.printf(formatString, num, binNum, num);
        System.out.printf(formatString, num + " >> 1", numShift1Bin, num >> 1);
        System.out.printf(formatString, num + " >>> 1", numUnsignedShift1Bin, num >>> 1);
        System.out.printf(formatString, num + " >> 2", numShift2Bin, num >> 2);
        System.out.printf(formatString, num + " >>> 2", numUnsignedShift2Bin, num >>> 2);
        System.out.println();
        waitForEnter();
    }

    public static void leftShiftDemo(int num) {
        clearTTY();
        System.out.println("Left shift: \n");
        // Convert the number to binary
        String binNum = padLeftZeros(Integer.toBinaryString(num));

        // Shift right and pad with zeros
        String numShift1Bin = padLeftZeros(Integer.toBinaryString(num << 1));

        // Shift right twice and pad with zeros
        String numShift2Bin = padLeftZeros(Integer.toBinaryString(num << 2));

        // Find the longest string to make the formatting nice
        int longest = (num + " << 2").length();
        String formatString = "%-" + longest + "s : %32s = %d\n";

        // Output the number, the number shifted once, and shifted twice
        System.out.printf(formatString, num, binNum, num);
        System.out.printf(formatString, num + " << 1", numShift1Bin, num << 1);
        System.out.printf(formatString, num + " << 2", numShift2Bin, num << 2);
        System.out.println();
        waitForEnter();
    }

    public static void bitOrDemo(int num, int orNum) {
        clearTTY();
        System.out.println("Bitwise OR: \n");
        // Convert the number to binary
        String binNum = padLeftZeros(Integer.toBinaryString(num));
        String binOrNum = padLeftZeros(Integer.toBinaryString(orNum));
        String binORResult = padLeftZeros(Integer.toBinaryString(num | orNum));
        // Find the longest string to make the formatting nice
        int longest = (num + " | " + orNum).length();
        String formatString = "%s | %s : %32s = %d\n";

        // Output the number and the two numbers ORed
        System.out.printf("%-" + longest + "d : %32s\n", num, binNum);
        System.out.printf("%-" + longest + "d : %32s\n", orNum, binOrNum);
        System.out.printf(formatString, num, orNum, binORResult, num | orNum);

        System.out.println();
        waitForEnter();
    }

    public static void bitXorDemo(int num, int orNum) {
        clearTTY();
        System.out.println("Bitwise XOR: \n");
        // Convert the number to binary
        String binNum = padLeftZeros(Integer.toBinaryString(num));
        String binOrNum = padLeftZeros(Integer.toBinaryString(orNum));
        String binORResult = padLeftZeros(Integer.toBinaryString(num ^ orNum));
        // Find the longest string to make the formatting nice
        int longest = (num + " ^ " + orNum).length();
        String formatString = "%s ^ %s : %32s = %d\n";

        // Output the number and the two numbers ORed
        System.out.printf("%-" + longest + "d : %32s\n", num, binNum);
        System.out.printf("%-" + longest + "d : %32s\n", orNum, binOrNum);
        System.out.printf(formatString, num, orNum, binORResult, num ^ orNum);

        System.out.println();
        waitForEnter();
    }

    public static void bitAndDemo(int num, int andNum) {
        clearTTY();
        System.out.println("Bitwise AND: \n");
        // Convert the number to binary
        // Convert the number to binary
        String binNum = padLeftZeros(Integer.toBinaryString(num));
        String binAndNum = padLeftZeros(Integer.toBinaryString(andNum));
        String binORResult = padLeftZeros(Integer.toBinaryString(num & andNum));
        // Find the longest string to make the formatting nice
        int longest = (num + " & " + andNum).length();
        String formatString = "%s & %s : %32s = %d\n";

        // Output the number and the two numbers ORed
        System.out.printf("%-" + longest + "d : %32s\n", num, binNum);
        System.out.printf("%-" + longest + "d : %32s\n", andNum, binAndNum);
        System.out.printf(formatString, num, andNum, binORResult, num & andNum);

        System.out.println();
        waitForEnter();
    }

    public static void bitNotDemo(int num) {
        clearTTY();
        System.out.println("Bitwise NOT: \n");
        // Convert the number to binary
        String binNum = padLeftZeros(Integer.toBinaryString(num));

        // NOT and pad with zeros
        String numNOT = padLeftZeros(Integer.toBinaryString(~num));

        // Find the longest string to make the formatting nice
        int longest = ("~" + num).length();
        String formatString = "%-" + longest + "s : %32s = %d\n";

        // Output the number, the number shifted once, and shifted twice
        System.out.printf(formatString, num, binNum, num);
        System.out.printf(formatString, "~" + num, numNOT, ~num);
        System.out.println();
        waitForEnter();
    }


    public static String invertDigits(String binaryInt) {
        // Make sure every digit is a 1 or a 0.
        if (binaryInt.matches("^[01]+$")) {
            // Change each digit to inverse through (num+1)%2
            return String.join("", Arrays.asList(binaryInt.split("")).stream()
                    .map(s -> "" + (Integer.parseInt(s) + 1) % 2).toList());
        } else {
            return "";
        }
    }

    public static void convertToTwosComplimentDemo(int num) {
        clearTTY();
        System.out.println("Converting to Two's Compliment\n");
        String result;
        boolean isNeg = num < 0;
        System.out.println("Starting with: " + num);
        // Convert abs value to binary
        String stepOne = padLeftZeros(Integer.toBinaryString(Math.abs(num)));
        System.out.println("Find the absolute value in binary");
        System.out.printf("%5s%s\n", "", stepOne);
        System.out.println("If the number is negative, find the inverse and add one.");
        if (isNeg) {
            // Invert every digit
            String stepTwo = invertDigits(stepOne);
            System.out.println("The inverse");
            System.out.printf("%5s%s\n", "", stepTwo);
            // Add one
            result = Long.toBinaryString(Long.parseLong(stepTwo, 2) + 1);
            System.out.println("and add one");
            System.out.printf("%5s%s\n", "", result);
        } else {
            System.out.println("\nThis number is positive, so you don't do anything else.");
            result = stepOne;
        }

        System.out.println("The result:");
        System.out.printf("%s: %32s", num, result);
        System.out.println();
        waitForEnter();
    }

    public static void convertFromTwosComplimentDemo(String binString) {
        clearTTY();
        System.out.println("Converting from Twos Compliment\n");
        binString = padLeftZeros(binString);
        int result;
        System.out.println("Starting with: ");
        System.out.printf("%5s%s\n", "", binString);
        System.out.println("Step 1: Check if num is negative");
        // Check if the number is negative.
        if (binString.charAt(0) == '1') {
            System.out.println("If it's negative, invert the bits");
            String invertedInt = invertDigits(binString);
            System.out.printf("%5s%s\n", "", invertedInt);

            System.out.println("then add one");
            String minusOne = padLeftZeros(Long.toBinaryString(Long.parseLong(invertedInt, 2) + 1));
            System.out.printf("%5s%s\n", "", minusOne);

            result = -((int) Long.parseLong(minusOne, 2));
        } else {
            System.out.println("This number is positive, so just convert back");
            result = (int) Long.parseLong(binString, 2);
        }

        System.out.println("The result");
        System.out.printf("%32s: %d", binString, result);
        waitForEnter();
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(shutdownHook);
        int num = 90;
        int num2 = 10;
        convertToTwosComplimentDemo(num);
        convertToTwosComplimentDemo(-num);

        convertFromTwosComplimentDemo(Integer.toBinaryString(num));
        convertFromTwosComplimentDemo(Integer.toBinaryString(-num));

        rightShiftDemo(num);
        rightShiftDemo(-num);

        leftShiftDemo(num);
        leftShiftDemo(-num);

        // left shift with special number
        leftShiftDemo(0b01000000000000000000000000000000);

        bitNotDemo(num);
        bitNotDemo(-num);

        bitOrDemo(num, num2);
        bitOrDemo(-num, num2);

        bitXorDemo(num, num2);
        bitXorDemo(-num, num2);

        bitAndDemo(num, num2);
        bitAndDemo(-num, num2);

    }
}
