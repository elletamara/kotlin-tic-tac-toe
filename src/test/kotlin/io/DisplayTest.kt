package io

import board.Grid
import board.SquaresGenerator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader
import java.io.PrintStream

internal class DisplayTest {

    private fun defaultGrid(): Grid {
        val squares = SquaresGenerator.generateNineSquares()
        return Grid(squares)
    }

    @Test
    fun `displays the board`() {
        val expectedOutput = """
            1 | 2 | 3
            ---------
            4 | 5 | 6
            ---------
            7 | 8 | 9
            
            
        """.trimIndent()
        val grid = defaultGrid()
        val output = ByteArrayOutputStream()
        var input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val display = Display(consoleIO)

        display.displayBoard(grid)

        assertEquals(expectedOutput, output.toString())
    }
}
