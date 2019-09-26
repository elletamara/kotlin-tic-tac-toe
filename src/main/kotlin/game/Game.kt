package game

import board.Board
import player.Player

internal class Game(val board: Board, private val player1: Player, private val player2: Player) {
    private var currentPlayer: Player = player1
    private var opponent: Player = player2

    fun playMove() {
        val move = currentPlayer.chooseMove(this.board, currentPlayersMark(), opponentsMark())
        board.takeSquare(move, currentPlayersMark())
    }

    fun currentPlayersMark():String = currentPlayer.getMark()

    fun opponentsMark():String = opponent.getMark()

    fun toggleCurrentPlayer() {
        when (currentPlayer) {
            player1 -> { currentPlayer = player2; opponent = player1 }
            player2 -> { currentPlayer = player1; opponent = player2 }
        }
    }

    fun getWinnersMark(): String {
        return when (board.isWinningPlayer(currentPlayersMark())) {
            true -> currentPlayersMark()
            false -> opponentsMark()
        }
    }

    fun outcome(): String {
        return when (board.winningLineExists(currentPlayersMark(), opponentsMark())) {
            true -> getWinnersMark()
            false -> GameOutcome.TIE.string
        }
    }

    fun isOver(): Boolean {
        return board.isComplete(currentPlayersMark(), opponentsMark())
    }
}
