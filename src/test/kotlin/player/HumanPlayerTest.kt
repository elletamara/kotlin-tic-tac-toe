package player

import board.BoardFactory
import io.BoardPresenter3By3
import io.ConsoleIO
import io.Displayer
import io.InputValidator
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

internal class HumanPlayerTest {

    @Test
    fun `returns the user's move`() {
        val simulatedInput = "2"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val humanPlayer = HumanPlayer("x", inputValidator)
        val board = BoardFactory.create3by3Board()

        val move = humanPlayer.chooseMove(board)

        assertEquals(2, move)
    }

    @Test
    fun `returns the player's mark`() {
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val humanPlayer = HumanPlayer("x", inputValidator)

        val playerMark = humanPlayer.getMark()

        assertEquals("x", playerMark)
    }
}
