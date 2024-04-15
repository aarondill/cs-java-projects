import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Donuts {

    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("donuts.dat"));

        int numIn = in.nextInt();
        in.nextLine();
        for (int fun = 0; fun < numIn; fun++) {

            int numRow = in.nextInt();
            int numCol = in.nextInt();

            in.nextLine();
            int direction = EAST;
            int curRow = 0;
            int curCol = 0;

            String[][] grid = new String[numRow][numCol];

            for (int row = 0; row < numRow; row++) {
                String line = in.nextLine();
                for (int col = 0; col < numCol; col++) {
                    grid[row][col] = line.substring(col, col+1);
                }
            }

            String output = "";

            for (int i = 0; i < numRow * numCol; i++) {
                output += grid[curRow][curCol];
                grid[curRow][curCol] = "hiii";
                if (direction == EAST) {
                    if (curCol == numCol-1 || grid[curRow][curCol+1].length() >= 2) {
                        direction = SOUTH;
                    }
                } else if (direction == SOUTH) {
                    if (curRow == numRow-1 || grid[curRow+1][curCol].length() >= 2) {
                        direction = WEST;
                    }
                } else if (direction == WEST) {
                    if (curCol == 0 || grid[curRow][curCol-1].length() >= 2) {
                        direction = NORTH;
                    }
                } else if (direction == NORTH) {
                    if (curRow == 0 || grid[curRow-1][curCol].length() >= 2) {
                        direction = EAST;
                    }
                }
                switch (direction) {
                    case NORTH -> curRow--;
                    case EAST -> curCol++;
                    case SOUTH -> curRow++;
                    case WEST -> curCol--;
                }
            }

            System.out.println(output);

        }

    }

}
