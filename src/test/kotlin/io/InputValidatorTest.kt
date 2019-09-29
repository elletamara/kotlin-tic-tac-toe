package io

import board.BoardFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import player.PlayerMark
import java.io.*

internal class InputValidatorTest {
    private val currentPlayerMark = PlayerMark.ONE.string

    private fun consoleInputSetup(simulatedInput: String): ConsoleInput {
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        val input = BufferedReader(InputStreamReader(System.`in`))
        return ConsoleInput(input)
    }

    @Nested
    inner class ValidateMove {

        @Test
        fun `returns the input as a digit, when the string contains digits only`() {
            val consoleInput = consoleInputSetup("9")
            val boardPresenter = BoardPresenter3By3()
            val consoleOutput = ConsoleOutput()
            val displayer = Displayer(consoleOutput, boardPresenter)
            val inputValidator = InputValidator(consoleInput, displayer)
            val board = BoardFactory.createBoardWith3By3Grid()

            val move = inputValidator.validateMove(board, currentPlayerMark)


            assertEquals(9, move)
        }

        @Test
        fun `prompts user for input again when it is not valid`() {
            val consoleInput = consoleInputSetup("h\n1")
            val boardPresenter = BoardPresenter3By3()
            val consoleOutput = ConsoleOutput()
            val displayer = Displayer(consoleOutput, boardPresenter)
            val inputValidator = InputValidator(consoleInput, displayer)
            val board = BoardFactory.createBoardWith3By3Grid()

            val move = inputValidator.validateMove(board, currentPlayerMark)


            assertEquals(1, move)
        }
    }

    @Nested
    inner class ValidatePlayerSelection {

        @Test
        fun `returns the user's input when it matches a valid PlayerType`() {
            val consoleInput = consoleInputSetup("easy")
            val boardPresenter = BoardPresenter3By3()
            val consoleOutput = ConsoleOutput()
            val displayer = Displayer(consoleOutput, boardPresenter)
            val inputValidator = InputValidator(consoleInput, displayer)

            val player = inputValidator.validatePlayerSelection(1, PlayerMark.TWO.string)


            assertEquals("easy", player)
        }

        @Test
        fun `prompts the user for input again when the PlayerType is invalid`() {
            val consoleInput = consoleInputSetup("none\nunbeatable")
            val boardPresenter = BoardPresenter3By3()
            val consoleOutput = ConsoleOutput()
            val displayer = Displayer(consoleOutput, boardPresenter)
            val inputValidator = InputValidator(consoleInput, displayer)

            val player = inputValidator.validatePlayerSelection(2, PlayerMark.TWO.string)


            assertEquals("unbeatable", player)
        }
    }
}
