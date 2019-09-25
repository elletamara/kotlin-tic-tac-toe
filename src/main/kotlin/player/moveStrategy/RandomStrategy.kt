package player.moveStrategy

import board.Board
import kotlin.random.Random

internal class RandomMoveStrategy: MoveStrategy {

    override fun getMove(board: Board, currentPlayersMark: String, opponentsMark: String): Int {
        val availableSquares = board.getAvailableSquares(currentPlayersMark, opponentsMark)
        val availableSquaresSize = availableSquares.size
        val square = availableSquares[Random.nextInt(availableSquaresSize)]

        return square.getValue().toInt()
    }
}
