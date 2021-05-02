import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTests {
    private GameOfLife gameOfLife;

    @BeforeEach
    public void before() {
        gameOfLife = new GameOfLife(
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0},
                }
        );
    }

    @Test
    public void countNeighbours_IsTwo_WhenCellHasTwoNeighbours() {
        int count = gameOfLife.countNeighbours(1, 4);
        assertEquals(2, count);
    }

    @Test
    public void countNeighbours_IsOne_WhenCellHasOneNeighbour() {
        int count = gameOfLife.countNeighbours(2, 0);
        assertEquals(1, count);
    }

    @Test
    public void countNeighbours_IsZero_WhenCellHasNoNeighbours() {
        int count = gameOfLife.countNeighbours(0, 0);
        assertEquals(0, count);
    }
}
