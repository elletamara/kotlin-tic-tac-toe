package player

import board.BoardFactory
import io.BoardPresenter3By3
import io.ConsoleOutput
import io.Displayer
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import player.moveStrategy.RandomMoveStrategy
import player.moveStrategy.UnbeatableStrategy

internal class ComputerPlayerTest {

    private fun displayerSetup(): Displayer {
        val boardPresenter = BoardPresenter3By3()
        val consoleOutput = ConsoleOutput()
        return Displayer(consoleOutput, boardPresenter)
    }

    @Nested
    inner class ChooseMove {

        @Test
        fun `returns a move as an integer`() {
            val displayer = displayerSetup()
            val strategy = RandomMoveStrategy()
            val computerPlayer = ComputerPlayer("x", displayer, strategy)
            val board = BoardFactory.createBoardWith3By3Grid()
            val gridSize = board.getGrid().size()

            val move = computerPlayer.chooseMove(board, "o")

            assertTrue(move in 0..gridSize)
        }
    }

    @Nested
    inner class GetMark {

        @Test
        fun `returns the computer player's mark`() {
            val displayer = displayerSetup()
            val strategy = UnbeatableStrategy()
            val computerPlayer = ComputerPlayer("x", displayer, strategy)

            val playerMark = computerPlayer.getMark()

            assertEquals("x", playerMark)
        }
    }
}
