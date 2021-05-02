public class GameOfLife {
    private int[][] gameGrid;
    private int currentGeneration = 1;

    private final static int ALIVE = 1;
    private final static int DEAD = 0;

    public GameOfLife(int[][] gameGrid) {
        this.gameGrid = gameGrid;
    }

    public int[][] nextGeneration() {
        currentGeneration++;
        int[][] nextGenGrid = new int[gameGrid.length][gameGrid[0].length];

        for (int i = 0; i < gameGrid.length; i++) {
            for (int j = 0; j < gameGrid[0].length; j++) {
                int neighboursCount = countNeighbours(i, j);
                if (checkForNewborn(i, j, neighboursCount)) {
                    nextGenGrid[i][j] = ALIVE;
                } else if (checkForSurvivor(i, j, neighboursCount)) {
                    nextGenGrid[i][j] = ALIVE;
                } else if (checkForUnderpopulation(i, j, neighboursCount)) {
                    nextGenGrid[i][j] = DEAD;
                } else if (checkForOvercrowding(i, j, neighboursCount)) {
                    nextGenGrid[i][j] = DEAD;
                } else {
                    nextGenGrid[i][j] = gameGrid[i][j];
                }
            }
        }
        gameGrid = nextGenGrid;
        return gameGrid;
    }

    public boolean checkForUnderpopulation(int row, int column, int neighboursCount) {
        return isAlive(row, column) && neighboursCount < 2;
    }

    public boolean checkForOvercrowding(int row, int column, int neighboursCount) {
        return isAlive(row, column) && neighboursCount > 3;
    }

    public boolean checkForSurvivor(int row, int column, int neighboursCount) {
        return isAlive(row, column) && (neighboursCount == 2 || neighboursCount == 3);
    }

    public boolean checkForNewborn(int row, int column, int neighboursCount) {
        return isDead(row, column) && neighboursCount == 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Generation ")
                .append(currentGeneration)
                .append(System.lineSeparator());

        for (int i = 0; i < gameGrid.length; i++) {
            for (int j = 0; j < gameGrid[0].length; j++) {
                sb.append(isAlive(i, j) ? " * " : " . ");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public int countNeighbours(int row, int col) {
        int[][] neighbours = {
                {row - 1, col - 1},
                {row - 1, col},
                {row - 1, col + 1},
                {row, col - 1},
                {row, col + 1},
                {row + 1, col - 1},
                {row + 1, col},
                {row + 1, col + 1},
        };
        int count = 0;

        for (int[] cell : neighbours) {
            int currentRow = cell[0];
            int currentColumn = cell[1];
            if (currentRow > -1 && currentRow < gameGrid.length
                    && currentColumn > -1 && currentColumn < gameGrid[0].length) {
                if (isAlive(currentRow, currentColumn)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isAlive(int row, int column) {
        return gameGrid[row][column] == ALIVE;
    }

    private boolean isDead(int row, int column) {
        return gameGrid[row][column] == DEAD;
    }
}
