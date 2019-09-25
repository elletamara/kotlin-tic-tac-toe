package player.moveStrategy

import board.Board
import board.Grid3By3
import board.Square
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MinimaxStrategyTest {

    @Test
    fun `returns 3 as the best move`() {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "x", "3", "4", "o", "6", "o", "8", "9")
        for(value in squareValues) {
            squares.add(Square(value))
        }
        val board = Board(Grid3By3(squares))
        val minimaxStrategy = MinimaxStrategy()
        val currentPlayersMark = "x"
        val opponentsMark = "o"

        val move = minimaxStrategy.getMove(board, currentPlayersMark, opponentsMark)

        assertEquals(3, move)
    }

    @Test
    fun `returns 3 as the best move to block opponent`() {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("1", "x", "3", "4", "5", "x", "o", "o", "x")
        for(value in squareValues) {
            squares.add(Square(value))
        }
        val board = Board(Grid3By3(squares))
        val minimaxStrategy = MinimaxStrategy()
        val currentPlayersMark = "x"
        val opponentsMark = "o"

        val move = minimaxStrategy.getMove(board, currentPlayersMark, opponentsMark)

        assertEquals(3, move)
    }

    @Test
    fun `returns 9 as the best move`() {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("1", "2", "3", "o", "o", "6", "x", "x", "9")
        for(value in squareValues) {
            squares.add(Square(value))
        }
        val board = Board(Grid3By3(squares))
        val minimaxStrategy = MinimaxStrategy()
        val currentPlayersMark = "x"
        val opponentsMark = "o"

        val move = minimaxStrategy.getMove(board, currentPlayersMark, opponentsMark)

        assertEquals(9, move)
    }

    @Test
    fun `returns 7 as the best move`() {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("o", "2", "3", "4", "x", "o", "7", "8", "x")
        for(value in squareValues) {
            squares.add(Square(value))
        }
        val board = Board(Grid3By3(squares))
        val minimaxStrategy = MinimaxStrategy()
        val currentPlayersMark = "x"
        val opponentsMark = "o"

        val move = minimaxStrategy.getMove(board, currentPlayersMark, opponentsMark)

        assertEquals(7, move)
    }

    @Test
    fun `returns 9 as the best move to block the opponent`() {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "o", "3", "o", "o", "x", "x", "x", "9")
        for(value in squareValues) {
            squares.add(Square(value))
        }
        val board = Board(Grid3By3(squares))
        val minimaxStrategy = MinimaxStrategy()
        val currentPlayersMark = "x"
        val opponentsMark = "o"

        val move = minimaxStrategy.getMove(board, currentPlayersMark, opponentsMark)

        assertEquals(9, move)
    }

    @Test
    fun `returns 5 as the best move`() {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "o", "x", "o", "5", "6", "7", "8", "9")
        for(value in squareValues) {
            squares.add(Square(value))
        }
        val board = Board(Grid3By3(squares))
        val minimaxStrategy = MinimaxStrategy()
        val currentPlayersMark = "x"
        val opponentsMark = "o"

        val move = minimaxStrategy.getMove(board, currentPlayersMark, opponentsMark)

        assertEquals(5, move)
    }
}
