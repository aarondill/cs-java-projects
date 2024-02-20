import java.util.Scanner;

/**
 * Class Lab4B3
 *
 * <pre>
 * Author: Aaron Dill
 * Date:   May 04, 2023
 * Course: Computer Science I Honors
 * Period: 4th
 * </pre>
 *
 * Summary of file:
 * 
 * WAP to convert each input hex character into its base ten and binary
 * equivalent. Each input will be one of the 16 HEX
 * characters, 0..F. The switch statement will contain 16 cases, one for each
 * value. Each case action should output three
 * values...the original HEX character, the binary value (a string) and the base
 * ten value (an integer). A default case should
 * also be provided for invalid input.
 * '0' = "0000" = 0
 * '1' = "0001" = 1
 * .
 * '9' = "1001" = 9
 * 'A' = "1010" = 10
 * 'B' = "1011" = 11
 * 'C' = "1100" = 12
 * 'D' = "1101" = 13
 * 'E' = "1110" = 14
 * 'F' = "1111" = 15
 * DATA FILE ("lab4B3.in")
 * A
 * 5
 * 4
 * C
 * G
 * F
 * 9
 * EXPECTED OUTPUT
 * 'A' in hex is 1010 in binary and 10 in base ten.
 * '5' in hex is 0101 in binary and 5 in base ten.
 * '4' in hex is 0100 in binary and 4 in base ten.
 * 'C' in hex is 1100 in binary and 12 in base ten.
 * 'G' is not a valid hex digit.
 * 'F' in hex is 1111 in binary and 15 in base ten.
 * '9' in hex is 1001 in binary and 9 in base ten.
 *
 * 
 */
public class Lab4B3 {
  public static void main(String[] args) {
    // This closes the scanner
    try (Scanner f = new Scanner(Lab4B3.class.getResourceAsStream("./lab4b3.in"))) {
      // Processing loop, contains input, process and output
      while (f.hasNext()) {
        char hex = f.next().charAt(0);
        String bin = "";
        int dec = 0;
        switch (hex) {
          // @formatter:off
          case'0': bin="0000";dec=0;break;
          case'1': bin="0001";dec=1;break;
          case'2': bin="0010";dec=2;break;
          case'3': bin="0011";dec=3;break;
          case'4': bin="0100";dec=4;break;
          case'5': bin="0101";dec=5;break;
          case'6': bin="0110";dec=6;break;
          case'7': bin="0111";dec=7;break;
          case'8': bin="1000";dec=8;break;
          case'9': bin="1001";dec=9;break;
          case'A': bin="1010";dec=10;break;
          case'B': bin="1011";dec=11;break;
          case'C': bin="1100";dec=12;break;
          case'D': bin="1101";dec=13;break;
          case'E': bin="1110";dec=14;break;
          case'F': bin="1111";dec=15;break;
          default: dec = -1;
          // @formatter:on
        }
        if (dec == -1)
          System.out.printf("'%c' is not a valid hex digit.\n", hex);
        else
          System.out.printf("'%c' in hex is %s in binary and %d in base ten.\n", hex, bin, dec);
      }
    }
  }
}
