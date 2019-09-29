package io

import board.Grid

internal class BoardPresenter3By3: BoardPresenter {

    override fun presentBoard(grid: Grid) =
        """
            ${grid.getSquareValue(0)} | ${grid.getSquareValue(1)} | ${grid.getSquareValue(2)}
            ---------
            ${grid.getSquareValue(3)} | ${grid.getSquareValue(4)} | ${grid.getSquareValue(5)}
            ---------
            ${grid.getSquareValue(6)} | ${grid.getSquareValue(7)} | ${grid.getSquareValue(8)}
            
        """.trimIndent()
}
