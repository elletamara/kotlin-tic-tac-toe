package player.moveStrategy

import board.Board
import kotlin.collections.HashMap


internal class MinimaxStrategy: MoveStrategy {

    override fun getMove(board: Board, currentPlayersMark: String, opponentsMark: String): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun bestMoveForMaximisingPlayer(scores: HashMap<Int, Int>): Int {
        val max = scores.maxBy { it.value }
        return max!!.key
    }

    fun bestScoreForMaximisingPlayer(scores: HashMap<Int, Int>): Int {
        val max = scores.maxBy { it.value }
        return max!!.value
    }
}

