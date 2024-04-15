import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ingredients {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("ingredients.dat"));

        int numIn = in.nextInt();
        in.nextLine();
        for (int fun = 0; fun < numIn; fun++) {

            int numIngredients = in.nextInt();
            int requiredNum = in.nextInt();

            ArrayList<Integer> ingredients = new ArrayList<>();
            for (int a = 0; a < numIngredients; a++) {
                ingredients.add(in.nextInt());
            }

            ArrayList<Integer> required= new ArrayList<>();
            for (int a = 0; a < requiredNum; a++) {
                required.add(in.nextInt());
            }

            boolean works = true;
            boolean hasSpecial = false;
            for(int num : required) {
                if (!ingredients.contains(num)) {
                    works = false;
                    break;
                }
            }

            if (ingredients.contains(1)) {
                hasSpecial = true;
            }

            if (works) {
                if (hasSpecial) {
                    System.out.println("Time to take a trip to the stratosphere!");
                } else {
                    System.out.println("I guess it's time to have a normal brownie...");
                }
            } else {
                System.out.println(":(");
            }

        }

    }

}
