package io

import board.Grid
import board.Square
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class DisplayTest {

    private fun defaultGrid(): Grid {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        for(value in squareValues) {
            squares.add(Square(value))
        }
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
        val consoleIO = ConsoleIO(PrintStream(output))
        val display = Display(consoleIO)

        display.displayBoard(grid)

        assertEquals(expectedOutput, output.toString())
    }
}
