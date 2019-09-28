package player

import board.Board
import io.InputValidator

internal class HumanPlayer(private val mark: String, private val inputValidator: InputValidator): Player {
    override fun chooseMove(board: Board, currentPlayersMark: String, opponentsMark: String): Int {
        return inputValidator.validateMove(board, getMark(), opponentsMark)
    }

    override fun getMark(): String =  this.mark
}
