package player.moveStrategy

import board.Board
import kotlin.collections.HashMap


internal class MinimaxStrategy: MoveStrategy {

    override fun getMove(board: Board, currentPlayersMark: String, opponentsMark: String): Int {
        val boardCopy = board.copy()
        return findBestMove(boardCopy, 0, currentPlayersMark, opponentsMark)

    }

    private fun findBestMove(board: Board, depth: Int, currentPlayersMark: String, opponentsMark: String): Int {
        if (board.isComplete(currentPlayersMark, opponentsMark)) {
            return scoreMove(board, depth, currentPlayersMark, opponentsMark)
        }

        val movesAndScores = HashMap<Int, Int>()
        val availableSquares = board.getAvailableSquares(currentPlayersMark, opponentsMark)

        availableSquares.forEach {
            val squareValueInt = it.getValue().toInt()
            val boardCopy = board.copy()

            boardCopy.takeSquare(squareValueInt, currentPlayersMark)
            movesAndScores[squareValueInt] = -1 * findBestMove(
                boardCopy, depth + 1, opponentsMark, currentPlayersMark
            )
        }

        return evaluateMove(depth, movesAndScores)
    }


    fun scoreMove(
        board: Board, depth: Int, currentPlayersMark: String, opponentsMark: String): Int {

        return when {
            board.isWinningPlayer(currentPlayersMark) -> 10 - depth
            board.isWinningPlayer(opponentsMark) -> depth - 10
            else -> 0
        }
    }

    fun evaluateMove(depth: Int, scores: HashMap<Int, Int>): Int {
        return if (depth == 0) bestMoveForMaximisingPlayer(scores) else bestScoreForMaximisingPlayer(scores)
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

