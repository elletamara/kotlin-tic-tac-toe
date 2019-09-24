package io

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.*

internal class InputValidatorTest {
    @Test
    fun `returns the input as a digit, when it is a digit`() {
        val simulatedInput = "9"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val inputValidator = InputValidator(consoleIO)

        val move = inputValidator.validateMove()


        assertEquals(9, move)
    }

    @Test
    fun `returns 0 when the input is not a digit`() {
        val simulatedInput = "h"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val inputValidator = InputValidator(consoleIO)

        val move = inputValidator.validateMove()


        assertEquals(0, move)
    }
}
