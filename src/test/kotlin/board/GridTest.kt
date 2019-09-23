package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GridTest {
    private fun defaultSquares(): ArrayList<Square> {
        return arrayListOf(
            Square(1),
            Square(2),
            Square(3),
            Square(4),
            Square(5),
            Square(6),
            Square(7),
            Square(8),
            Square(9)
        )
    }

    @Test
    fun `returns the grid with squares`() {
        var squares = defaultSquares();
        var grid = Grid(squares)

        assertEquals(grid.getSquares(), defaultSquares())
    }

    @Test
    fun `returns the value of the Square at index 1`() {
        var squares = defaultSquares();
        var grid = Grid(squares)

        assertEquals(grid.getSquare(1), 2)
    }
}

