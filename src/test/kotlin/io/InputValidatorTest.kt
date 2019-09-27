package io

import board.BoardFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.*

internal class InputValidatorTest {
    @Test
    fun `returns the input as a digit, when the string contains digits only`() {
        val simulatedInput = "9"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val board = BoardFactory.createBoardWith3By3Grid()

        val move = inputValidator.validateMove(board, "x", "o")


        assertEquals(9, move)
    }

    @Test
    fun `prompts user for input again when it is not valid`() {
        val simulatedInput = "h\n1"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val board = BoardFactory.createBoardWith3By3Grid()

        val move = inputValidator.validateMove(board, "x", "o")


        assertEquals(1, move)
    }

    @Test
    fun `returns the user's input when it matches a valid PlayerType`() {
        val simulatedInput = "easy"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)

        val player = inputValidator.validatePlayerSelection()


        assertEquals("easy", player)
    }

    @Test
    fun `prompts the user for input again when the PlayerType is invalid`() {
        val simulatedInput = "none\nunbeatable"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)

        val player = inputValidator.validatePlayerSelection()


        assertEquals("unbeatable", player)
    }
}
