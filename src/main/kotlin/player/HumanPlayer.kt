package player

import board.Board
import io.InputValidator

internal class HumanPlayer(private val mark: String, private val inputValidator: InputValidator): Player {

    override fun chooseMove(board: Board): Int {
        return inputValidator.validateMove(board)
    }

    override fun getMark(): String {
        val mark: String by lazy { this.mark }
        return mark
    }
}
