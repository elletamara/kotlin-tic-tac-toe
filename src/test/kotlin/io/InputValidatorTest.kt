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
        val board = BoardFactory.create3by3Board()

        val move = inputValidator.validateMove(board)


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
        val board = BoardFactory.create3by3Board()

        val move = inputValidator.validateMove(board)


        assertEquals(1, move)
    }
}
