package player.moveStrategy

import board.Square

internal interface MoveStrategy {
    fun getMove(availableSquares: ArrayList<Square>, currentPlayersMark: String, opponentsMark: String): Int
}
