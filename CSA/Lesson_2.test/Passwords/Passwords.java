/**
 * Primary java class: Passwords
 *  
 * Author:  Aaron Dill
 * Date:    09/29/2023
 * Course:  CSA
 * Period:  3rd
 *  
 * Summary of file:
 * For this project you are to write a program that will generate random default passwords.
 * Each password must meet the following criteria:
 * 
 * Exactly eight (8) random characters or digits.
 * Two characters must be lowercase.
 * Two characters must be uppercase.
 * Two of the characters must be random digits (0 – 9).
 * The last two characters are your choice.
 * There is no input for this program. 
 * The program will simply print out a different random password each time that it is run.
 * 
 */
public class Passwords {
  // Set these constants to personalize your password. Length *must* be >= LOWER_COUNT+UPPER+COUNT+NUM_COUNT. Obviously.
  private static final int LENGTH = 8;
  private static final int LOWER_COUNT = 2;
  private static final int UPPER_COUNT = 2;
  private static final int NUM_COUNT = 2;
  // Note: exclusive max!
  private static int random(int min, int max){
    return (int) (Math.random() * (max-min) + min);
  }
  // Constants to use at runtime. Generated using char addition.
  static String alphaNum = "", upper = "", lower = "", num = "";
  static {
    for(char i='a'; i <= 'z'; i++) lower+=i;
    for(char i='A'; i <= 'Z'; i++) upper+=i;
    for(char i='0'; i <= '9'; i++) num+=i;
    alphaNum = upper + lower + num;
  }
  // Ensure the password matches the parameters (LENGTH, LOWER_COUNT, UPPER_COUNT, NUM_COUNT)
  private static boolean validate(String password){
    if (password.length() != LENGTH) return false; // length check!
    int lowerC=0, upperC=0, numC=0;
    for(char c : password.toCharArray()){
      if(upper.indexOf(c) >= 0) upperC += 1;
      else if(lower.indexOf(c) >= 0) lowerC += 1;
      else if(num.indexOf(c) >= 0) numC += 1;
    }
    return lowerC >= LOWER_COUNT && upperC >= UPPER_COUNT && numC >= NUM_COUNT; // All counts are correct
  }
  // Make a new string of length chars from old string s
  private static String randString(String s, int length){
    String res = "";
    for(int i = 0; i<length; i++){
      int index=random(0, s.length()); // Can't equal s.length()!
      res += s.substring(index, index+1); // random letter
    }
    return res;
  }
  private static String generate(){    
    String res = ""; // Get the chars for the string
    res += randString(lower, LOWER_COUNT);
    res += randString(upper, UPPER_COUNT);
    res += randString(num, NUM_COUNT);
    res += randString(alphaNum, LENGTH - res.length());
    
    String password = "";
    while (res.length() > 0){ // shuffle the string
      int index = random(0, res.length());
      password += res.substring(index, index+1); // poor man's .charAt(int);
      res = res.substring(0, index) + res.substring(index + 1); // remove the letter from res;
    }    

    return password;  
  }
  public static void main(String[] args){
    if (LOWER_COUNT+UPPER_COUNT+NUM_COUNT > LENGTH)
      throw new RuntimeException("It is impossible to create a string with more chars than the total length!");
    String password = generate(); // Create a new password
    if (!validate(password))
      throw new RuntimeException("Generated password '" + password + "' is not valid according to the parameters! This is a bug!");
    System.out.println(password); // output the password
  }
}