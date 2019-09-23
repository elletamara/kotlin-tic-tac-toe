package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GridTest {
    private fun defaultSquares(): ArrayList<Square> {
        return SquaresGenerator.generateNineSquares()
    }

    @Test
    fun `returns the grid with squares`() {
        val squares = defaultSquares();
        val grid = Grid(squares)

        assertEquals(grid.getSquares(), defaultSquares())
    }

    @Test
    fun `returns the value of the Square at index 1`() {
        val squares = defaultSquares();
        val grid = Grid(squares)

        assertEquals(grid.getSquare(1), "2")
    }

    @Test
    fun `changes the value of the Square from "1", to "x"`() {
        val squares = defaultSquares();
        val grid = Grid(squares)

        grid.setSquare(0, "x")

        assertEquals(grid.getSquare(0), "x")
    }

    @Test
    fun `returns 9 as the number of Squares in the grid`() {
        val squares = defaultSquares();
        val grid = Grid(squares)

        val gridSize = grid.size()

        assertEquals(gridSize, 9)
    }
}

