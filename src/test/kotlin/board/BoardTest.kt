package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BoardTest {
    private fun defaultSquares(): ArrayList<Square> {
        return SquaresGenerator.generateNineSquares()
    }

    private fun defaultGrid(): Grid {
        return Grid(defaultSquares())
    }

    @Test
    fun `returns the grid`() {
        val grid = defaultGrid()
        val board = Board(grid)

        assertEquals(board.getGrid(), grid)
    }

    @Test
    fun `changes the value of the Square from "5" to "x"`() {
        val grid = defaultGrid()
        val board = Board(grid)

        board.takeSquare(5, "x")

        assertEquals(grid.getSquare(4), "x")
    }

    @Test
    fun `returns true when the position exists`() {
        val grid = defaultGrid()
        val board = Board(grid)

        val isPositionValid = board.isPositionValid(4)

        assertTrue(isPositionValid)
    }

    @Test
    fun `returns false when the position does not exist`() {
        val grid = defaultGrid()
        val board = Board(grid)

        val isPositionValid = board.isPositionValid(10)

        assertFalse(isPositionValid)
    }
}
