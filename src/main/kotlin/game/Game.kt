package game

import board.Board
import player.Player

internal class Game(val board: Board, private val player1: Player, private val player2: Player) {
    private var currentPlayer: Player = player1
    private var opponent: Player = player2

    fun playMove() {
        val move = currentPlayer.chooseMove(this.board, opponentsMark())
        board.takeSquare(move, currentPlayersMark())
    }

    private fun currentPlayersMark():String {
        return currentPlayer.getMark()
    }

    private fun opponentsMark():String {
        return opponent.getMark()
    }
}
