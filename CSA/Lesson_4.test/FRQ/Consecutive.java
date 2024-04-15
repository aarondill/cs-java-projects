public class Consecutive
{
   public static void main(String[] args)
   {
      String str = "groom";
      String longest = "";
      int len = str.length()-1;
      boolean found = false;
     /*
      * Add code to print the longest
      * substring that contains
      * identical characters.
      */
      // note: `len` and `found` are unused, as they are not needed. They were in the template, so they're included here.
      for(int i = 0; i < str.length(); i++){
         String c1=str.substring(i, i+1);
         int thisLen=1; // c1.length()
         // start at i+1 (i is c1) and loop until end of string or we find a different c, incr thisLen one per char we find
         for (int j = i+1; j < str.length() && c1.equals(str.substring(j, j+1)); j++) thisLen++;
         // We've found a new longest (first time this is guarenteed to be true bc 1 > 0)
         if (thisLen > longest.length()) longest = str.substring(i, i+thisLen); // The new longest is from i to i+thisLen (exclusive!)
         i+=thisLen-1; // Optimization -- Don't loop the chars we already found -- Note: thisLen-1 because the for loop will increment by one
      }
      System.out.print(longest);
   }
}
