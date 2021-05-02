import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            // TODO: let user pass start configuration of grid
            System.out.println("passed args: " + Arrays.toString(args));
        }

        int[][] currentGrid = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
        };

        GameOfLife gol = new GameOfLife(currentGrid);
        System.out.println(gol);

        int[][] nextGrid = gol.nextGeneration();

        while (!Arrays.deepEquals(nextGrid, currentGrid)) {
            System.out.println(gol);
            currentGrid = nextGrid;
            nextGrid = gol.nextGeneration();
        }
    }
}
