package io

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import java.io.*

internal class ConsoleIOTest {

    @Nested
    inner class Println {

        @Test
        fun `prints the text to the console`() {
            val output = ByteArrayOutputStream()
            val input = BufferedReader(InputStreamReader(System.`in`))
            val consoleIO = ConsoleIO(input, PrintStream(output))

            consoleIO.println("hello")

            assertEquals("hello\n", output.toString())
        }
    }

    @Nested
    inner class GetInput {

        @Test
        fun `gets input from the user`() {
            val simulatedInput = "goodbye"
            System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
            val input = BufferedReader(InputStreamReader(System.`in`))
            val consoleIO = ConsoleIO(input)

            val userInput = consoleIO.getInput()

            assertEquals("goodbye", userInput)
        }
    }
}
