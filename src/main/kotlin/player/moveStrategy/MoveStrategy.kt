package player.moveStrategy

import board.Board

internal interface MoveStrategy {
    fun getMove(board: Board, currentPlayersMark: String, opponentsMark: String): Int
}
