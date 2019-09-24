package io

import board.Grid

internal class Displayer(private val consoleIO: ConsoleIO, private val boardPresenter: BoardPresenter) {
    fun humanPlayerMakeMoveMessages(grid: Grid, isMoveValid: Boolean = true) {
        when (isMoveValid) {
            true -> {
                consoleIO.println(Prompt.CHOOSE_MOVE.string)
            }
            false -> consoleIO.println(ErrorMessage.INVALID_MOVE.string)
        }

        consoleIO.println(boardPresenter.presentBoard(grid))
    }
}
