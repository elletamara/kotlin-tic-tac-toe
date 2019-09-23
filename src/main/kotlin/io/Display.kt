package io

import board.Grid

internal class Display(private val consoleIO: ConsoleIO) {
    fun displayBoard(grid: Grid) {
        val gridOutput = """
            ${grid.getSquare(0)} | ${grid.getSquare(1)} | ${grid.getSquare(2)}
            ---------
            ${grid.getSquare(3)} | ${grid.getSquare(4)} | ${grid.getSquare(5)}
            ---------
            ${grid.getSquare(6)} | ${grid.getSquare(7)} | ${grid.getSquare(8)}
            
            """.trimIndent()
        consoleIO.println(gridOutput)
    }

}
