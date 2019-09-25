package io

import board.Grid
import game.GameOutcome

internal class Displayer(private val consoleIO: ConsoleIO, private val boardPresenter: BoardPresenter) {

    fun humanPlayerMakeMoveMessages(grid: Grid, isMoveValid: Boolean = true) {
        when (isMoveValid) {
            true -> consoleIO.println(Prompt.CHOOSE_MOVE.string)
            false -> consoleIO.println(ErrorMessage.INVALID_MOVE.string)
        }

        showBoard(grid)
    }

    fun gameOutcomeMessage(outcome: String) {
        when (outcome == GameOutcome.TIE.string) {
            true -> consoleIO.println(GameOutcomeMessage.TIE.string)
            false -> consoleIO.println(GameOutcomeMessage.WIN.string +
                    outcome + GameOutcomeMessage.EXCLAMATION.string)
        }
    }

    fun playerTurnMessage(playerMark: String) {
        consoleIO.println(playerMark + Prompt.PLAYER_TURN.string)
    }

    private fun showBoard(grid: Grid) {
        consoleIO.println(boardPresenter.presentBoard(grid))
    }
}
