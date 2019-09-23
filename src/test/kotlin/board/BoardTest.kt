package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BoardTest {
    private fun defaultSquares(): ArrayList<Square> {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        for(value in squareValues) {
            squares.add(Square(value))
        }

        return squares
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
