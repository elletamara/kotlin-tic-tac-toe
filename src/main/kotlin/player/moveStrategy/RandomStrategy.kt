package player.moveStrategy

import board.Square
import kotlin.random.Random

internal class RandomMoveStrategy: MoveStrategy {
    override fun getMove(
        availableSquares: ArrayList<Square>, currentPlayersMark: String, opponentsMark: String): Int {
        val square = availableSquares[Random.nextInt(availableSquares.size)]
        return square.getValue().toInt()
    }
}
