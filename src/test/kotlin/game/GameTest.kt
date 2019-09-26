package game

import board.*
import io.BoardPresenter3By3
import io.ConsoleIO
import io.Displayer
import io.InputValidator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import player.HumanPlayer
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

internal class GameTest {

    private fun boardSetup(squareValues: Array<String>): Board {
        val squares: ArrayList<Square> = arrayListOf()
        for (value in squareValues) squares.add(Square(value))

        return Board(Grid3By3(squares))
    }

    @Test
    fun `puts the player's mark on the board at position 2`() {
        val board = BoardFactory.createBoardWith3By3Grid()
        val simulatedInput = "2"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val player1 = HumanPlayer("x", inputValidator)
        val player2 = HumanPlayer("o", inputValidator)
        val game = Game(board, player1, player2)

        game.playMove()

        assertEquals(board.getGrid().getSquare(1), "x")
    }

    @Test
    fun `toggles the current player`() {
        val board = BoardFactory.createBoardWith3By3Grid()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val player1 = HumanPlayer("x", inputValidator)
        val player2 = HumanPlayer("o", inputValidator)
        val game = Game(board, player1, player2)

        game.toggleCurrentPlayer()

        assertEquals("o", game.currentPlayersMark())
        assertEquals("x", game.opponentsMark())

        game.toggleCurrentPlayer()

        assertEquals("x", game.currentPlayersMark())
        assertEquals("o", game.opponentsMark())
    }

    @Test
    fun `returns the winning player's mark`() {
        val board = boardSetup(arrayOf("o", "o", "o", "x", "x", "6", "x", "8", "9"))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val player1 = HumanPlayer("x", inputValidator)
        val player2 = HumanPlayer("o", inputValidator)
        val game = Game(board, player1, player2)

        val winnersMark = game.getWinnersMark()

        assertEquals("o", winnersMark)
    }

    @Test
    fun `returns the winning player's mark as the outcome`() {
        val board = boardSetup(arrayOf("o", "o", "o", "x", "x", "6", "x", "8", "9"))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val player1 = HumanPlayer("x", inputValidator)
        val player2 = HumanPlayer("o", inputValidator)
        val game = Game(board, player1, player2)

        val outcome = game.outcome()

        assertEquals("o", outcome)
    }

    @Test
    fun `returns "tie" as the outcome when no players have a winning line`() {
        val board = boardSetup(arrayOf("x", "o", "o", "o", "x", "x", "o", "x", "o"))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val player1 = HumanPlayer("x", inputValidator)
        val player2 = HumanPlayer("o", inputValidator)
        val game = Game(board, player1, player2)

        val outcome = game.outcome()

        assertEquals("tie", outcome)
    }

    @Test
    fun `returns true when the board is full`() {
        val board = boardSetup(arrayOf("x", "o", "o", "o", "x", "x", "o", "x", "o"))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val player1 = HumanPlayer("x", inputValidator)
        val player2 = HumanPlayer("o", inputValidator)
        val game = Game(board, player1, player2)

        val isGameOver = game.isOver()

        assertTrue(isGameOver)
    }

    @Test
    fun `returns true when a mark has a winning line`() {
        val board = boardSetup(arrayOf("o", "o", "o", "x", "x", "6", "x", "8", "9"))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val player1 = HumanPlayer("x", inputValidator)
        val player2 = HumanPlayer("o", inputValidator)
        val game = Game(board, player1, player2)

        val isGameOver = game.isOver()

        assertTrue(isGameOver)
    }

    @Test
    fun `returns false when the board is not full and a mark does not have a winning line`() {
        val board = boardSetup(arrayOf("1", "o", "o", "o", "x", "x", "o", "x", "o"))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val player1 = HumanPlayer("x", inputValidator)
        val player2 = HumanPlayer("o", inputValidator)
        val game = Game(board, player1, player2)

        val isGameOver = game.isOver()

        assertFalse(isGameOver)
    }
}
