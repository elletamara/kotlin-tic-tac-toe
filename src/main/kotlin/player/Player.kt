package player

import board.Board

internal interface Player {
    fun chooseMove(board: Board, currentPlayersMark: String, opponentsMark: String): Int
    fun getMark(): String
}
