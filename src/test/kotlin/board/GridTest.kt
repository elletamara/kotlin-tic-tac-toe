package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GridTest {
    private fun defaultSquares(): ArrayList<Square> {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        for(value in squareValues) {
            squares.add(Square(value))
        }

        return squares
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

