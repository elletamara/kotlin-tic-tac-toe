package io

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import java.io.ByteArrayInputStream

internal class ConsoleInputTest {

    @Nested
    inner class GetInput {

        @Test
        fun `gets input from the user`() {
            val simulatedInput = "goodbye"
            System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
            val consoleInput = ConsoleInput()

            val userInput = consoleInput.getInput()

            assertEquals("goodbye", userInput)
        }
    }
}
