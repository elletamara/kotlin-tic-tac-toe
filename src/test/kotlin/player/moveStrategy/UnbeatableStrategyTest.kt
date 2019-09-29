package player.moveStrategy

import board.Board
import board.Grid3By3
import board.Square
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

internal class UnbeatableStrategyTest {

    private fun boardSetup(squareValues: Array<String>): Board {
        val squares: ArrayList<Square> = arrayListOf()
        for (value in squareValues) squares.add(Square(value))

        return Board(Grid3By3(squares))
    }

    @Nested
    inner class GetMove {

        @Test
        fun `returns 1 as the best move when the grid is empty`() {
            val board = boardSetup(arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9"))
            val unbeatableStrategy = UnbeatableStrategy()
            val currentPlayersMark = "x"
            val opponentsMark = "o"

            val move = unbeatableStrategy.getMove(board, currentPlayersMark, opponentsMark)

            assertEquals(1, move)
        }

        @Test
        fun `returns 5 as the optimum move when the opponent has made a first move`() {
            val board = boardSetup(arrayOf("x", "2", "3", "4", "5", "6", "7", "8", "9"))
            val unbeatableStrategy = UnbeatableStrategy()
            val currentPlayersMark = "o"
            val opponentsMark = "x"

            val move = unbeatableStrategy.getMove(board, currentPlayersMark, opponentsMark)

            assertEquals(5, move)
        }

        @Test
        fun `returns 3 as the best move to win the game`() {
            val board = boardSetup(arrayOf("x", "x", "3", "4", "o", "6", "o", "8", "9"))
            val unbeatableStrategy = UnbeatableStrategy()
            val currentPlayersMark = "x"
            val opponentsMark = "o"

            val move = unbeatableStrategy.getMove(board, currentPlayersMark, opponentsMark)

            assertEquals(3, move)
        }


        @Test
        fun `returns 7 as the best move`() {
            val board = boardSetup(arrayOf("o", "2", "3", "4", "x", "o", "7", "8", "x"))
            val unbeatableStrategy = UnbeatableStrategy()
            val currentPlayersMark = "x"
            val opponentsMark = "o"

            val move = unbeatableStrategy.getMove(board, currentPlayersMark, opponentsMark)

            assertEquals(7, move)
        }

        @Test
        fun `returns 9 as the best move to block the opponent`() {
            val board = boardSetup(arrayOf("x", "o", "3", "o", "o", "x", "x", "x", "9"))
            val unbeatableStrategy = UnbeatableStrategy()
            val currentPlayersMark = "o"
            val opponentsMark = "x"

            val move = unbeatableStrategy.getMove(board, currentPlayersMark, opponentsMark)

            assertEquals(9, move)
        }

        @Test
        fun `returns 7 as the best move of two to block the opponent`() {
            val board = boardSetup(arrayOf("x", "o", "x", "x", "x", "o", "7", "8", "o"))
            val unbeatableStrategy = UnbeatableStrategy()
            val currentPlayersMark = "o"
            val opponentsMark = "x"

            val move = unbeatableStrategy.getMove(board, currentPlayersMark, opponentsMark)

            assertEquals(7, move)
        }
    }
}


