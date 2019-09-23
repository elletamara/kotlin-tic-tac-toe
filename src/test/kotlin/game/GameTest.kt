package game

import board.BoardFactory
import io.ConsoleIO
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import player.HumanPlayer
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

internal class GameTest {

    @Test
    fun `puts the player's mark on the board at position 2`() {
        val board = BoardFactory.create3by3Board()
        var simulatedInput = "2"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        var input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val humanPlayer = HumanPlayer("x", consoleIO)
        val game = Game(board, humanPlayer)

        game.playMove()

        assertEquals(board.getGrid().getSquare(1), "x")
    }
}
