package player

import board.Board

internal interface Player {
    fun chooseMove(board: Board, opponentMark: String): Int
    fun getMark(): String
}
