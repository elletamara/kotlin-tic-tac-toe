package io

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

internal class ConsoleInputTest {

    @Nested
    inner class GetInput {

        @Test
        fun `gets input from the user`() {
            val simulatedInput = "goodbye"
            System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
            val input = BufferedReader(InputStreamReader(System.`in`))
            val consoleInput = ConsoleInput(input)

            val userInput = consoleInput.getInput()

            assertEquals("goodbye", userInput)
        }
    }
}
