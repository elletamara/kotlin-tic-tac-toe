package player

import board.Board

internal interface Player {
    fun chooseMove(board: Board, opponentsMark: String): Int
    fun getMark(): String
}
