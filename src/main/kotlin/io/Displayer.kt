package io

import board.Grid
import game.GameOutcome

internal class Displayer(private val consoleIO: ConsoleIO, private val boardPresenter: BoardPresenter) {

    fun welcomeMessage() {
        clearScreen()
        consoleIO.println(GreetingMessage.WELCOME.string)
        sleep(3500L)
        clearScreen()
    }

    fun playerTurnMessage(playersMark: String) {
        clearScreen()
        consoleIO.println(playersMark + Prompt.PLAYER_TURN.string)
    }

    fun humanPlayerMakeMoveMessages(grid: Grid, isMoveValid: Boolean = true) {
        when (isMoveValid) {
            true -> consoleIO.println(Prompt.CHOOSE_MOVE.string)
            false -> consoleIO.println(ErrorMessage.INVALID_MOVE.string)
        }

        showBoard(grid)
    }

    fun computerPlayerMakeMoveMessages(grid: Grid, playersMark: String) {
        playerTurnMessage(playersMark)
        consoleIO.println(Prompt.CHOOSE_MOVE.string)
        showBoard(grid)
    }

    fun computerIsThinkingMessage(playersMark: String) {
        consoleIO.println("$playersMark" + Prompt.WAIT.string)
        sleep(3500L)
    }

    fun gameOutcomeMessage(outcome: String) {
        clearScreen()

        when (outcome == GameOutcome.TIE.string) {
            true -> consoleIO.println(GameOutcomeMessage.TIE.string)
            false -> consoleIO.println(GameOutcomeMessage.CONGRATS.string +
                    outcome + GameOutcomeMessage.WINNER.string)
        }
    }

    fun goodbyeMessage() {
        consoleIO.println(GreetingMessage.GOODBYE.string)
    }

    private fun clearScreen() {
        consoleIO.println("\u001b[H\u001b[2J")
    }

    private fun sleep(delay: Long) {
        Thread.sleep(delay)
    }

    private fun showBoard(grid: Grid) {
        consoleIO.println(boardPresenter.presentBoard(grid))
    }
}
