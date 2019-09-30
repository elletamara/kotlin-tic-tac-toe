package io

import board.Board
import board.Grid
import player.PlayerType

internal class InputValidator(
    internal val consoleInput: ConsoleInput, private val displayer: Displayer) {

    fun validateMove(board: Board, mark: String): Int {
        playerMessages(mark, board.getGrid)
        var move = getMoveFromUser()

        while (!board.isMoveValid(move)) {
            displayer.humanPlayerMakeMoveMessages(board.getGrid, false)
            move = getMoveFromUser()
        }
        return move
    }

    fun validatePlayerSelection(playerNumber: Int, playerMark: String): String {
        displayer.playerSelectionMessage(playerNumber, playerMark)
        var input = getPlayerSelectionFromUser()

        while (!playerTypeExists(input)) {
            displayer.invalidPlayerSelectionMessage()
            input = getPlayerSelectionFromUser()
        }
        return input.toLowerCase()
    }

    private fun getInput() = consoleInput.getInput()!!

    private fun getMoveFromUser(): Int {
        val input = getInput()
        return if (input.matches(ValidMoveInput.DIGIT.value)) input.toInt() else 0
    }

    private fun getPlayerSelectionFromUser() = getInput().toUpperCase()

    private fun playerTypeExists(input: String) = PlayerType.values().any { it.name == input }

    private fun playerMessages(mark: String, grid: Grid) {
        with(displayer) {
            playerTurnMessage(mark)
            humanPlayerMakeMoveMessages(grid)
        }
    }
}
