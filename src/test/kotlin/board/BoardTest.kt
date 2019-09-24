package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BoardTest {
    private fun defaultSquares(): ArrayList<Square> {
        return SquaresGenerator.generateNineSquares()
    }

    private fun defaultGrid(): Grid3By3 {
        return Grid3By3(defaultSquares())
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

        val isPositionValid = board.isMoveValid(4, "x", "o")

        assertTrue(isPositionValid)
    }

    @Test
    fun `returns false when the position does not exist`() {
        val grid = defaultGrid()
        val board = Board(grid)

        val isPositionValid = board.isMoveValid(10, "x", "o")

        assertFalse(isPositionValid)
    }

    @Test
    fun `returns true when the Square does not contain a mark`() {
        val grid = defaultGrid()
        val board = Board(grid)

        val isSquareAvailable = board.isMoveValid(1, "x", "o")

        assertTrue(isSquareAvailable)
    }

    @Test
    fun `returns false when the Square contains a mark`() {
        val grid = defaultGrid()
        val board = Board(grid)
        board.takeSquare(1, "x")

        val isSquareAvailable = board.isMoveValid(1, "x", "o")

        assertFalse(isSquareAvailable)
    }
}
