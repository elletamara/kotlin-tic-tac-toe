package player.moveStrategy

import board.Board
import board.Grid
import board.Grid3By3
import board.Square
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RandomMoveStrategyTest {

    private fun gridWithEmptySquares(): Grid {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
        for(value in squareValues) {
            squares.add(Square(value))
        }
        return Grid3By3(squares)
    }

    @Test
    fun `returns a random available position on the grid as an integer`() {
        val grid = gridWithEmptySquares()
        val currentPlayersMark = "x"
        val opponentsMark = "o"
        val board = Board(grid)
        val availableSquares = board.getAvailableSquares(currentPlayersMark, opponentsMark)
        val strategy = RandomMoveStrategy()

        val move = strategy.getMove(availableSquares, currentPlayersMark, opponentsMark)

        assertTrue(move in 1..9)
    }
}
