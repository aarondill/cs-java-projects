/**
 * public class Formulas
 *  
 * Author:  Aaron Dill
 * Date:    09/05/2006
 * Course:  CSA
 * Period:  3rd
 *  
 * Using your textbooks from science or math class or using the Internet, find formulas to convert 10 values from one unit to another. For example, convert Fahrenheit temperature to Celsius or convert pounds to kilograms.
 * 
 * For each of the conversions that you choose write down the formula used to make the conversion and show the calculations for one example. If you choose temperature then you should write down C=5/9(F-32) and then choose a temperature for F and show the calculations.
 * 
 * C=5/9(100-32)
 * C=5/9*68
 * C=0.555*68
 * C=37.78
 * After you have found your conversion formulas and done the calculations, write a program, called Formulas.java, that will
 * 
 * print what the conversion will be,
 * prompt the user for the original value,
 * and then print the converted value using labels for each value...
 * All of the converted values should be rounded to two decimal places. There should be one blank line between each conversion. You must use expressions and declare variables to complete the project. Test your program using the calculations that you have written down. Here is an example that shows two possible conversions.
 * 
 *
 */
import java.util.Scanner;
import java.util.function.Function;
public class Formulas {
    static Scanner scan = null;
    private static double roundHundreths(double num){
      if(num == 0) return 0;
      else if (num > 0) return ( (int)( num*100 + 0.5 ) )/100.0;
      else return ( (int)( num*100 - 0.5 ) )/100.0;
    }
    private static String twoDecimals(double num){
       double roundedNum = roundHundreths(num);
       String strNum = ""+ (int)roundedNum; // int part
       int numDecimal = Math.abs((int)( (roundedNum*100) % 100 ));
       String decimalString = ""+numDecimal;
       while (decimalString.length() < 2) decimalString += "0";
       strNum += "."+decimalString;
       return strNum;
    }
    private static double getInput(String prompt){
      if (scan == null) throw new RuntimeException("instantiate this.scan before calling getInput");
      System.out.print(prompt+": ");
      if (!scan.hasNextDouble()) throw new RuntimeException("You must input a valid double.");
      return scan.nextDouble();
    }
    private static String titleCase(String str){
      return str.substring(0, 1).toUpperCase()+str.substring(1).toLowerCase();
    }
    private static void doFunc(Function<Double, Double> f, String inputUnit, String outputUnit){
      System.out.println(titleCase(inputUnit) + " to " + titleCase(outputUnit));
      double input = getInput("Enter the "+inputUnit.toLowerCase());
      double x = f.apply(input);
      // Note: rounding is done with roundHundreths! All formats are %s, so no rounding can possible occur here.
      System.out.printf("%s %s = %s %s\n", input, inputUnit.toLowerCase(), twoDecimals(x), outputUnit.toLowerCase());
      System.out.println(); // Blank line in between
    }
    public static void main(String[] args){
      try(Scanner scan = new Scanner(System.in)){
        Formulas.scan = scan;
        doFunc(F->(F-32)*5.0/9.0, "fahrenheit", "celsius"); //1
        doFunc(K->K/1.609, "Kilometers", "Miles"); //2
        doFunc(M->M*1.609, "Miles", "Kilometers"); //3 - 1 Reversed
        doFunc(G->G*128, "Gallons", "Ounces"); //4
        doFunc(O->O/128, "Ounces", "Gallons"); //5 - 2 Reversed
        doFunc(M->M*5280, "Miles", "Feet"); //6
        doFunc(F->F/5280, "Feet", "Miles"); //7 - 3 Reversed. Up to 3 allowed.
        doFunc(F->F/3, "Feet", "Yards"); //8
        doFunc(K->K-273.15, "Kelvin", "celsius"); //9
        doFunc(H->H*60, "Hour", "minutes"); //10

      } 
      scan = null;
    }
}