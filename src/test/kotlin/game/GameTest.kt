package game

import board.*
import io.*
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import player.HumanPlayer


internal class GameTest {
    private val consoleInputMock = mockk<ConsoleInput>()

    private fun boardSetup(squareValues: Array<String>): Board {
        val squares: ArrayList<Square> = arrayListOf()
        for (value in squareValues) squares.add(Square(value))
        return Board(Grid3By3(squares))
    }

    @Nested
    inner class PlayMove {

        @Test
        fun `puts the player's mark on the board at position 2`() {
            every { consoleInputMock.getInput() } returns "2"
            val board = BoardFactory.createBoardWith3By3Grid()
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val player1 = HumanPlayer("x", inputValidator)
            val player2 = HumanPlayer("o", inputValidator)
            val game = Game(board, player1, player2)

            game.playMove()

            assertEquals(board.getGrid().getSquareValue(1), "x")
        }
    }

    @Nested
    inner class ToggleCurrentPlayer {

        @Test
        fun `toggles the current player`() {
            val board = BoardFactory.createBoardWith3By3Grid()
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
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
    }

    @Nested
    inner class GetWinnersMark {

        @Test
        fun `returns the winning player's mark`() {
            val board = boardSetup(arrayOf("o", "o", "o", "x", "x", "6", "x", "8", "9"))
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val player1 = HumanPlayer("x", inputValidator)
            val player2 = HumanPlayer("o", inputValidator)
            val game = Game(board, player1, player2)

            val winnersMark = game.getWinnersMark()

            assertEquals("o", winnersMark)
        }
    }

    @Nested
    inner class Outcome {

        @Test
        fun `returns the winning player's mark as the outcome`() {
            val board = boardSetup(arrayOf("o", "o", "o", "x", "x", "6", "x", "8", "9"))
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val player1 = HumanPlayer("x", inputValidator)
            val player2 = HumanPlayer("o", inputValidator)
            val game = Game(board, player1, player2)

            val outcome = game.outcome()

            assertEquals("o", outcome)
        }

        @Test
        fun `returns "tie" as the outcome when no players have a winning line`() {
            val board = boardSetup(arrayOf("x", "o", "o", "o", "x", "x", "o", "x", "o"))
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val player1 = HumanPlayer("x", inputValidator)
            val player2 = HumanPlayer("o", inputValidator)
            val game = Game(board, player1, player2)

            val outcome = game.outcome()

            assertEquals("tie", outcome)
        }
    }

    @Nested
    inner class IsOver {

        @Test
        fun `returns true when the board is full`() {
            val board = boardSetup(arrayOf("x", "o", "o", "o", "x", "x", "o", "x", "o"))
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val player1 = HumanPlayer("x", inputValidator)
            val player2 = HumanPlayer("o", inputValidator)
            val game = Game(board, player1, player2)

            val isGameOver = game.isOver()

            assertTrue(isGameOver)
        }

        @Test
        fun `returns true when a mark has a winning line`() {
            val board = boardSetup(arrayOf("o", "o", "o", "x", "x", "6", "x", "8", "9"))
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val player1 = HumanPlayer("x", inputValidator)
            val player2 = HumanPlayer("o", inputValidator)
            val game = Game(board, player1, player2)

            val isGameOver = game.isOver()

            assertTrue(isGameOver)
        }

        @Test
        fun `returns false when the board is not full and a mark does not have a winning line`() {
            val board = boardSetup(arrayOf("1", "o", "o", "o", "x", "x", "o", "x", "o"))
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val player1 = HumanPlayer("x", inputValidator)
            val player2 = HumanPlayer("o", inputValidator)
            val game = Game(board, player1, player2)

            val isGameOver = game.isOver()

            assertFalse(isGameOver)
        }
    }
}
