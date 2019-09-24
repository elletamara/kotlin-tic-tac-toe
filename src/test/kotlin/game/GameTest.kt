package game

import board.BoardFactory
import io.BoardPresenter3By3
import io.ConsoleIO
import io.Displayer
import io.InputValidator
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
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val humanPlayer = HumanPlayer("x", inputValidator)
        val game = Game(board, humanPlayer)

        game.playMove()

        assertEquals(board.getGrid().getSquare(1), "x")
    }
}
