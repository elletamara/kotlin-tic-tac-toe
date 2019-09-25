package io

import board.Board

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

    private fun getMoveFromUser(): Int {
        val input = getInput()

        return when (input.matches(ValidMoveInput.DIGIT.value)) {
            true -> input.toInt()
            false -> 0
        }
    }

    private fun getInput(): String {
        return consoleIO.getInput()
    }
}
