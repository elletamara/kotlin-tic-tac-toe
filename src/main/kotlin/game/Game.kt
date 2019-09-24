package game

import board.Board
import player.Player

internal class Game(val board: Board, private val player1: Player) {
    var currentPlayer: Player = player1

    fun playMove() {
        val move = currentPlayer.chooseMove(this.board)
        board.takeSquare(move, currentPlayersMark())
    }

    private fun currentPlayersMark():String {
        return currentPlayer.getMark()
    }
}
