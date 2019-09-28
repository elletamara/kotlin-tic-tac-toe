package player

import board.BoardFactory
import io.BoardPresenter3By3
import io.ConsoleIO
import io.Displayer
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import player.moveStrategy.RandomMoveStrategy
import player.moveStrategy.UnbeatableStrategy
import java.io.BufferedReader
import java.io.InputStreamReader

internal class ComputerPlayerTest {

    @Test
    fun `returns a move as an integer` () {
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val strategy = RandomMoveStrategy()
        val computerPlayer = ComputerPlayer("x", displayer, strategy)
        val board = BoardFactory.createBoardWith3By3Grid()
        val gridSize = board.getGrid().size()

        val move = computerPlayer.chooseMove(board, "x", "o")

        assertTrue(move in 0..gridSize)
    }

    @Test
    fun `returns the computer player's mark`() {
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val strategy = UnbeatableStrategy()
        val computerPlayer = ComputerPlayer("x", displayer, strategy)

        val playerMark = computerPlayer.getMark()

        assertEquals("x", playerMark)
    }
}
