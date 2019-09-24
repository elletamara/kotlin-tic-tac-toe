package io

import board.BoardFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader
import java.io.PrintStream

internal class DisplayerTest {
    @Test
    fun `displays the move prompt and the board when the move is valid`() {
        val expectedOutput = """
            Select an available move:
            1 | 2 | 3
            ---------
            4 | 5 | 6
            ---------
            7 | 8 | 9
            
            
        """.trimIndent()
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val board = BoardFactory.create3by3Board()

        displayer.humanPlayerMakeMoveMessages(board.getGrid())

        assertEquals(expectedOutput, output.toString())

    }

    @Test
    fun `displays the error message when the move is invalid`() {
        val expectedOutput = """
            That's an invalid move. Please try again.
            1 | 2 | 3
            ---------
            4 | 5 | 6
            ---------
            7 | 8 | 9
            
            
        """.trimIndent()
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val board = BoardFactory.create3by3Board()

        displayer.humanPlayerMakeMoveMessages(board.getGrid(), false)

        assertEquals(expectedOutput, output.toString())
    }
}
