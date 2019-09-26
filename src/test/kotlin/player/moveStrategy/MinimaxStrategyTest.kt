package player.moveStrategy

import board.Board
import board.Grid3By3
import board.Square
import board.SquaresGenerator
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MinimaxStrategyTest {

    private val movesAndScores: HashMap<Int, Int> = hashMapOf(
        1 to -7,
        2 to -8,
        3 to 5,
        4 to 3,
        5 to 9,
        6 to 8,
        7 to -1,
        8 to 0,
        9 to -3
    )

    private fun boardWithTheCurrentPlayerAsTheWinner(): Board {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "x", "x", "o", "o", "6", "o", "8", "9")
        for(value in squareValues) squares.add(Square(value))
        val grid = Grid3By3(squares)

        return Board(grid)
    }

    private fun boardWithTheOpponentAsTheWinner(): Board {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "2", "x", "o", "o", "o", "x", "8", "9")
        for(value in squareValues) squares.add(Square(value))
        val grid = Grid3By3(squares)

        return Board(grid)
    }

    private fun boardWithFullGrid(): Board {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "o", "o", "o", "x", "x", "o", "x", "o")
        for(value in squareValues) squares.add(Square(value))
        val grid = Grid3By3(squares)

        return Board(grid)
    }

    private fun boardWithEmptyGrid(): Board {
        val squares = SquaresGenerator.generateNineSquares()
        val grid = Grid3By3(squares)

        return Board(grid)
    }

    private fun boardWithCornerSquareTaken(): Board {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "2", "3", "4", "5", "6", "7", "8", "9")
        for(value in squareValues) squares.add(Square(value))
        val grid = Grid3By3(squares)

        return Board(grid)
    }

    @Test
    fun `returns the best scores from the scores `() {
        val strategy = MinimaxStrategy()

        val bestScore = strategy.bestScoreForMaximisingPlayer(movesAndScores)

        assertEquals(9, bestScore)
    }

    @Test
    fun `returns the best move from the moves`() {
        val strategy = MinimaxStrategy()

        val bestMove = strategy.bestMoveForMaximisingPlayer(movesAndScores)

        assertEquals(5, bestMove)
    }

    @Test
    fun `returns the best move when the depth is 0`() {
        val strategy = MinimaxStrategy()

        val bestMove = strategy.evaluateMove(0, movesAndScores)

        assertEquals(5, bestMove)
    }

    @Test
    fun `returns the best score when the depth is not equal to 0`() {
        val strategy = MinimaxStrategy()

        val bestMove = strategy.evaluateMove(1, movesAndScores)

        assertEquals(9, bestMove)
    }

    @Test
    fun `returns 5 as the score when the current player is the winning player`() {
        val strategy = MinimaxStrategy()
        val board = boardWithTheCurrentPlayerAsTheWinner()

        val bestScore = strategy.scoreMove(board, 5, "x", "o")

        assertEquals(5, bestScore)
    }

    @Test
    fun `returns -5 as the score when the opponent is the winning player`() {
        val strategy = MinimaxStrategy()
        val board = boardWithTheOpponentAsTheWinner()

        val bestScore = strategy.scoreMove(board, 5, "x", "o")

        assertEquals(-5, bestScore)
    }

    @Test
    fun `returns 0 as the score when neither player has a winning line`() {
        val strategy = MinimaxStrategy()
        val board = boardWithFullGrid()

        val bestScore = strategy.scoreMove(board, 5, "x", "o")

        assertEquals(0, bestScore)
    }

    @Test
    fun `returns 1 as the best move when the grid is empty`() {
        val board = boardWithEmptyGrid()
        val minimaxStrategy = MinimaxStrategy()

        val currentPlayersMark = "x"
        val opponentsMark = "o"

        val move = minimaxStrategy.getMove(board, currentPlayersMark, opponentsMark)

        assertEquals(1, move)
    }

    @Test
    fun `returns 5 as the optimum move when the opponent has made a first move`() {
        val board = boardWithCornerSquareTaken()
        val minimaxStrategy = MinimaxStrategy()
        val currentPlayersMark = "o"
        val opponentsMark = "x"

        val move = minimaxStrategy.getMove(board, currentPlayersMark, opponentsMark)

        assertEquals(5, move)
    }

    @Test
    fun `returns 3 as the best move to win the game`() {
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
        val currentPlayersMark = "o"
        val opponentsMark = "x"

        val move = minimaxStrategy.getMove(board, currentPlayersMark, opponentsMark)

        assertEquals(9, move)
    }

    @Test
    fun `returns 7 as the best move of two to block the opponent`() {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "o", "x", "x", "x", "o", "7", "8", "o")
        for(value in squareValues) {
            squares.add(Square(value))
        }
        val board = Board(Grid3By3(squares))
        val minimaxStrategy = MinimaxStrategy()
        val currentPlayersMark = "o"
        val opponentsMark = "x"

        val move = minimaxStrategy.getMove(board, currentPlayersMark, opponentsMark)

        assertEquals(7, move)
    }
}


