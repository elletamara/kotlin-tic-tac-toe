package player

import board.BoardFactory
import io.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

internal class HumanPlayerTest {

    @Nested
    inner class ChooseMove {

        @Test
        fun `returns the user's move as an integer`() {
            val simulatedInput = "2"
            System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
            val input = BufferedReader(InputStreamReader(System.`in`))
            val consoleInput = ConsoleInput(input)
            val boardPresenter = BoardPresenter3By3()
            val consoleOutput = ConsoleOutput()
            val displayer = Displayer(consoleOutput, boardPresenter)
            val inputValidator = InputValidator(consoleInput, displayer)
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
            val input = BufferedReader(InputStreamReader(System.`in`))
            val consoleInput = ConsoleInput(input)
            val boardPresenter = BoardPresenter3By3()
            val consoleOutput = ConsoleOutput()
            val displayer = Displayer(consoleOutput, boardPresenter)
            val inputValidator = InputValidator(consoleInput, displayer)
            val humanPlayer = HumanPlayer("x", inputValidator)

            val playerMark = humanPlayer.getMark()

            assertEquals("x", playerMark)
        }
    }
}
