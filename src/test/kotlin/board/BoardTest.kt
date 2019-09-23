package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BoardTest {
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
