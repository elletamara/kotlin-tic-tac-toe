package io

import board.Grid

internal class BoardPresenter3By3: BoardPresenter {

    override fun presentBoard(grid: Grid): String {
        return """
            ${grid.getSquare(0)} | ${grid.getSquare(1)} | ${grid.getSquare(2)}
            ---------
            ${grid.getSquare(3)} | ${grid.getSquare(4)} | ${grid.getSquare(5)}
            ---------
            ${grid.getSquare(6)} | ${grid.getSquare(7)} | ${grid.getSquare(8)}
            
            """.trimIndent()
    }
}
