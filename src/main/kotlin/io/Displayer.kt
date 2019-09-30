package io

import board.Grid
import game.GameOutcome

internal class Displayer(
    internal val consoleOutput: ConsoleOutput, private val boardPresenter: BoardPresenter) {

    private val clearScreen: String = "\u001b[H\u001b[2J"
    private val newLine: String = "\n"

    fun welcomeMessage() {
        clearScreen()
        consoleOutput.println(GreetingMessage.WELCOME.string)
        sleep(3500L)
        clearScreen()
    }

    fun playerSelectionMessage(playerNumber: Int, playerMark: String) {
        consoleOutput.println(Prompt.CHOOSE_PLAYER_TYPE.string
                + ("$playerNumber ($playerMark)")
                + newLine
                + Prompt.PLAYER_TYPES.string)
    }

    fun invalidPlayerSelectionMessage() {
        consoleOutput.println(ErrorMessage.INVALID_PLAYER_TYPE.string)
    }

    fun playerTurnMessage(playersMark: String) {
        clearScreen()
        consoleOutput.println(playersMark + Prompt.PLAYER_TURN.string)
    }

    fun humanPlayerMakeMoveMessages(grid: Grid, isMoveValid: Boolean = true) {
        when (isMoveValid) {
            true -> consoleOutput.println(Prompt.CHOOSE_MOVE.string)
            false -> consoleOutput.println(ErrorMessage.INVALID_MOVE.string)
        }
        showGrid(grid)
    }

    fun computerPlayerMakeMoveMessages(grid: Grid, playersMark: String) {
        playerTurnMessage(playersMark)
        consoleOutput.println(Prompt.CHOOSE_MOVE.string)
        showGrid(grid)
    }

    fun computerIsThinkingMessage(playersMark: String) {
        consoleOutput.println(playersMark + Prompt.WAIT.string)
        sleep(3500L)
    }

    fun gameOutcomeMessage(grid: Grid, outcome: String) {
        clearScreen()
        showGrid(grid)

        when (outcome) {
            GameOutcome.TIE.string -> consoleOutput.println(GameOutcomeMessage.TIE.string)
            else -> consoleOutput.println(GameOutcomeMessage.CONGRATS.string +
                    outcome + GameOutcomeMessage.WINNER.string)
        }
    }

    fun goodbyeMessage() {
        consoleOutput.println(GreetingMessage.GOODBYE.string)
    }

    private fun showGrid(grid: Grid) {
        consoleOutput.println(boardPresenter.presentBoard(grid))
    }

    private fun clearScreen() {
        consoleOutput.println(clearScreen)
    }

    private fun sleep(delay: Long) {
        Thread.sleep(delay)
    }
}
