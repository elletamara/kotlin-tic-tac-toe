package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GridTest {
    private fun defaultSquares(): ArrayList<Square> {
        return SquaresGenerator.generateNineSquares()
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

        assertEquals(grid.getSquare(1), "2")
    }

    @Test
    fun `changes the value of the Square from "1", to "x"`() {
        var squares = defaultSquares();
        var grid = Grid(squares)

        grid.setSquare(0, "x")

        assertEquals(grid.getSquare(0), "x")
    }
}

