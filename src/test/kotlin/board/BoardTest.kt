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
        var grid = defaultGrid()
        var board = Board(grid)

        assertEquals(board.getGrid(), grid)
    }

    @Test
    fun `changes the value of the Square from "5" to "x"`() {
        var grid = defaultGrid()
        var board = Board(grid)

        board.takeSquare(5, "x")

        assertEquals(grid.getSquare(4), "x")
    }
}
