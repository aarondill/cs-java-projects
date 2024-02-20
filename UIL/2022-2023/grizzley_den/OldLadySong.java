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

class OldLadySong {
    private static String eaten = "";

    private static void print_refrain(String swallow, String secondLine) {
        swallowed(swallow);
        if (secondLine != null)
            System.out.println(secondLine);
        eaten += swallow + " ";
        String[] eatenArr = eaten.split(" ");
        for (int i = eatenArr.length - 1; i > 0; i--) {
            String eat = eatenArr[i];
            String toCatch = eatenArr[i - 1];
            System.out.println(
                    "She swallowed the " + eat + " to catch the " + toCatch +
                            (toCatch.equals("spider") ? "" : "..."));
            if (toCatch.equals("spider"))
                System.out.println(wiggled());

        }
        if (eatenArr.length > 0)
            System.out.print("But ");
        System.out.println("I dunno why she swallowed that fly,\nPerhaps she'll die.");
        System.out.println();
    }

    private static void swallowed(String swallow) {
        System.out.println("There was an old lady who swallowed a " + swallow + ".");
    }

    private static String wiggled() {
        return "That wiggled and wiggled and tickled inside her.";
    }

    public static void main(String[] args) {
        print_refrain("fly", null);
        print_refrain("spider", wiggled());
        print_refrain("bird", "How absurd, to swallow a bird!");
        print_refrain("cat", "Imagine that, she swallowed a cat.");
        print_refrain("dog", "What a hog! To swallow a dog!");
        print_refrain("goat", "Just opened her throat and swallowed a goat!");
        print_refrain("cow", "I don't know how she swallowed a cow!");
        swallowed("horse");
        System.out.println("She's dead, of course.");
    }
}
