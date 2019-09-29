package player.moveStrategy

import board.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

internal class RandomMoveStrategyTest {

    private fun gridWithEmptySquares() = Grid3By3(SquaresGenerator.generateNineSquares())

    private fun gridWithTakenSquares(): Grid {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "x", "3", "4", "5", "6", "o", "x", "o")
        for(value in squareValues) squares.add(Square(value))

        return Grid3By3(squares)
    }

    @Nested
    inner class GetMove {

        @Test
        fun `returns a random available position from an empty grid, as an integer`() {
            val grid = gridWithEmptySquares()
            val currentPlayersMark = "x"
            val opponentsMark = "o"
            val board = Board(grid)
            val strategy = RandomMoveStrategy()

            val move = strategy.getMove(board, currentPlayersMark, opponentsMark)

            assertTrue(move in 1..9)
        }

        @Test
        fun `returns a random available position from a grid with unavailable positions`() {
            val grid = gridWithTakenSquares()
            val currentPlayersMark = "x"
            val opponentsMark = "o"
            val board = Board(grid)
            val strategy = RandomMoveStrategy()

            val move = strategy.getMove(board, currentPlayersMark, opponentsMark)

            assertTrue(move in 3..6)
        }
    }
}
