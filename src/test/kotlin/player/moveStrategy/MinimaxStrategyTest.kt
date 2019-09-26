package player.moveStrategy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MinimaxStrategyTest {

    private val movesAndScores: HashMap<Int, Int> = hashMapOf(
        1 to -7,
        2 to -8,
        3 to 5,
        4 to 3,
        5 to 9,
        6 to 8,
        7 to -1,
        8 to 0,
        9 to -3
    )

    @Test
    fun `returns the best scores from the scores `() {
        val strategy = MinimaxStrategy()

        val bestScore = strategy.bestScoreForMaximisingPlayer(movesAndScores)

        assertEquals(9, bestScore)
    }

    @Test
    fun `returns the best move from the moves`() {
        val strategy = MinimaxStrategy()

        val bestMove = strategy.bestMoveForMaximisingPlayer(movesAndScores)

        assertEquals(5, bestMove)
    }

    @Test
    fun `returns the best move when the depth is 0`() {
        val strategy = MinimaxStrategy()

        val bestMove = strategy.evaluateMove(0, movesAndScores)

        assertEquals(5, bestMove)
    }

    @Test
    fun `returns the best score when the depth is not equal to 0`() {
        val strategy = MinimaxStrategy()

        val bestMove = strategy.evaluateMove(1, movesAndScores)

        assertEquals(9, bestMove)
    }
}


