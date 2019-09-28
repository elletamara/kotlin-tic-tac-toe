package game

import board.Board
import player.Player

internal class Game(
    val board: Board, private var currentPlayer: Player, private var opponent: Player) {

    fun playMove() {
        val move = currentPlayer.chooseMove(board, opponentsMark())
        board.takeSquare(move, currentPlayersMark())
    }

    fun currentPlayersMark() = currentPlayer.getMark()

    fun opponentsMark() = opponent.getMark()

    fun toggleCurrentPlayer() {
        currentPlayer = opponent.also { opponent = currentPlayer }
    }

    fun getWinnersMark(): String {
        val currentPlayerWon = board.isWinningPlayer(currentPlayersMark())
        return if (currentPlayerWon) currentPlayersMark() else opponentsMark()
    }

    fun outcome(): String {
        val winningLineExists = board.winningLineExists(currentPlayersMark(), opponentsMark())
        return if (winningLineExists) getWinnersMark() else GameOutcome.TIE.string
    }

    fun isOver() = board.isComplete(currentPlayersMark(), opponentsMark())
}
