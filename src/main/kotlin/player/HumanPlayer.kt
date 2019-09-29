package player

import board.Board
import io.InputValidator

internal class HumanPlayer(
    private val mark: String, private val inputValidator: InputValidator): Player {

    override fun chooseMove(board: Board, opponentsMark: String) =
        inputValidator.validateMove(board, mark)

    override fun getMark() = mark
}
