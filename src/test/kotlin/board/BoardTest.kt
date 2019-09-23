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
}
