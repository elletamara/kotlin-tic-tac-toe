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

    fun currentPlayersMark():String {
        return currentPlayer.getMark()
    }

    fun opponentsMark():String {
        return opponent.getMark()
    }

    fun toggleCurrentPlayer() {
        when (currentPlayer == player1) {
            true -> { currentPlayer = player2; opponent = player1 }
            false -> { currentPlayer = player1; opponent = player2 }
        }
    }

    fun getWinnersMark(): String {
        val hasCurrentPlayerWon: Boolean = board.isWinningPlayer(currentPlayersMark())

        return when (hasCurrentPlayerWon) {
            true -> currentPlayersMark()
            false -> opponentsMark()
        }
    }
}
