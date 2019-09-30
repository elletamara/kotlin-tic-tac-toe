package player

import board.BoardFactory
import io.*
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

internal class HumanPlayerTest {
    private val consoleInputMock = mockk<ConsoleInput>()

    @Nested
    inner class ChooseMove {

        @Test
        fun `returns the user's move as an integer`() {
            every { consoleInputMock.getInput() } returns "2"
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val humanPlayer = HumanPlayer("x", inputValidator)
            val board = BoardFactory.createBoardWith3By3Grid()

            val move = humanPlayer.chooseMove(board, "o")

            assertEquals(2, move)
        }
    }

    @Nested
    inner class GetMark {

        @Test
        fun `returns the player's mark`() {
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val humanPlayer = HumanPlayer("x", inputValidator)

            val playerMark = humanPlayer.getMark()

            assertEquals("x", playerMark)
        }
    }
}
