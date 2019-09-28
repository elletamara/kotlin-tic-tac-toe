package io

import board.Board
import player.PlayerType

internal class InputValidator(private val consoleIO: ConsoleIO, private val displayer: Displayer) {

    fun validateMove(board: Board, currentPlayerMark: String, opponentMark: String): Int {
        displayer.playerTurnMessage(currentPlayerMark)
        displayer.humanPlayerMakeMoveMessages(board.getGrid())
        var move = getMoveFromUser()

        while (!board.isMoveValid(move, currentPlayerMark, opponentMark)) {
            displayer.humanPlayerMakeMoveMessages(board.getGrid(), false)
            move = getMoveFromUser()
        }

        return move
    }

    fun validatePlayerSelection(playerNumber: Int): String {
        displayer.playerSelectionMessage(playerNumber)
        var input = getInput().toUpperCase()

        while (PlayerType.values().none { it.name == input }) {
            println("Invalid player type")
            input = getInput().toUpperCase()
        }

        return input.toLowerCase()
    }

    private fun getMoveFromUser(): Int {
        val input = getInput()

        return if (input.matches(ValidMoveInput.DIGIT.value)) input.toInt() else 0
    }

    private fun getInput(): String  = consoleIO.getInput()
}
