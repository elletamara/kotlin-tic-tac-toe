package player

import board.Board

internal interface Player {
    fun chooseMove(board: Board): Int
    fun getMark(): String
}
