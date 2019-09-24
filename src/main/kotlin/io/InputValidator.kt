package io

import board.Board

internal class InputValidator(private val consoleIO: ConsoleIO) {
    fun validateMove(board: Board): Int {
        var move = getMoveFromUser()
        while (!board.isPositionValid(move)) {
            consoleIO.println(ErrorMessage.INVALID_MOVE.string)
            move = getMoveFromUser()
        }

        return move
    }

    private fun getMoveFromUser(): Int {
        consoleIO.println(Prompt.CHOOSE_MOVE.string)
        val input = consoleIO.getInput()

        return when (input.matches(ValidMoveInput.DIGIT.value)) {
            true -> input.toInt()
            false -> 0
        }
    }
}
