/**
 * Class OldLadySong
 *
 *
 * Team: Data Pirates
 * Date: November 29, 2022
 * Course: N/A
 *
 * Summary of file:
 * produces as output the lyrics to the repetitive song, "There Was an Old Lady
 * Who Swallowed a Fly," by Simms Taback.
 *
 */

class OldLady2 {
    private static String accum = "But I dunno why she swallowed that fly,\nPerhaps she'll die.";
    private static String lastEaten = "fly";

    private static void eatString(String eat) {
        System.out.println("There was an old lady who swallowed a " + eat + ".");
    }

    private static String toeat(String eat) {
        String r = "";
        if (eat.equals("spider"))
            r += "That wiggled and wiggled and tickled inside her.\n";
        r += "She swallowed the " + eat + " to catch the " + lastEaten
                + (eat.equals("spider") ? "." : lastEaten.equals("spider") ? "" : "...");
        lastEaten = eat;
        return r;
    }

    private static void print(String eat, String nextline) {
        eatString(eat);
        if (nextline != null)
            System.out.println(nextline);
        addAccum(toeat(eat));
        System.out.println(accum);
        System.out.println();
    }

    private static void addAccum(String str) {
        accum = str + "\n" + accum;
    }

    public static void main(String[] args) {
        eatString("fly");
        System.out.println(accum.substring(4));
        System.out.println();
        print("spider", null);
        print("bird", "How absurd, to swallow a bird!");
        print("cat", "Imagine that, she swallowed a cat.");
        print("dog", "What a hog! To swallow a dog!");
        print("goat", "Just opened her throat and swallowed a goat!");
        print("cow", "I don't know how she swallowed a cow!");
        System.out.println("There was an old lady who swallowed a horse -\nShe's dead, of course.");
    }
}
