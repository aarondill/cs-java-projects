import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Decoder {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("decoder.dat"));

        int numIn = in.nextInt();
        in.nextLine();
        for (int fun = 0; fun < numIn; fun++) {

            String[] line = in.nextLine().split(" ");

            Stack<String> stack = new Stack<>();
            for (String word : line) {
                switch (word) {
                    case "%" -> {
                        String a = stack.pop();
                        String b = stack.pop();
                        stack.add(a);
                        stack.add(b);
                    }
                    case "1" -> {
                        stack.pop();
                    }
                    case "2" -> {
                        String a = stack.pop();
                        stack.pop();
                        stack.add(a);
                    }
                    case "+" -> {
                        stack.add(" ");
                    }
                    default -> stack.add(word);
                }
            }

            for (String word : stack) {
                System.out.print(word.toUpperCase());
            }

            System.out.println();
        }

    }

}
