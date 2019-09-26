package player.moveStrategy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MinimaxStrategyTest {

    @Test
    fun `returns the best scores from the scores `() {
        val strategy = MinimaxStrategy()
        val movesAndScores: HashMap<Int, Int> = hashMapOf(
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
        val bestScore = strategy.bestScoreForMaximisingPlayer(movesAndScores)

        assertEquals(9, bestScore)
    }

    @Test
    fun `returns the best move from the moves`() {
        val strategy = MinimaxStrategy()
        val movesAndScores: HashMap<Int, Int> = hashMapOf(
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
        val bestMove = strategy.bestMoveForMaximisingPlayer(movesAndScores)

        assertEquals(5, bestMove)
    }
}


