package io

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class ConsoleOutputTest {

    @Nested
    inner class Println {

        @Test
        fun `prints the text to the console`() {
            val output = ByteArrayOutputStream()
            val consoleOutput = ConsoleOutput(PrintStream(output))

            consoleOutput.println("hello")

            assertEquals("hello\n", output.toString())
        }
    }
}
