package player

import io.BoardPresenter3By3
import io.ConsoleIO
import io.Displayer
import io.InputValidator
import org.junit.jupiter.api.Test
import org.junit.Assert.*
import java.io.BufferedReader
import java.io.InputStreamReader

internal class PlayerFactoryTest {
    private val input = BufferedReader(InputStreamReader(System.`in`))
    private val consoleIO = ConsoleIO(input)
    private val boardPresenter = BoardPresenter3By3()
    private val displayer = Displayer(consoleIO, boardPresenter)
    private val inputValidator = InputValidator(consoleIO, displayer)

    @Test
    fun `returns a new instance of a human player, with the mark "x"`() {
        val playerFactory = PlayerFactory(inputValidator, displayer)

        val player = playerFactory.createPlayer("x", "human")

        assertTrue(player is HumanPlayer)
        assertEquals(player.getMark(), "x")
    }

    @Test
    fun `returns a new instance of a easy computer player, with the mark "o"`() {
        val playerFactory = PlayerFactory(inputValidator, displayer)

        val player = playerFactory.createPlayer("o", "computer")

        assertTrue(player is ComputerPlayer)
        assertEquals(PlayerType.EASY, player.getPlayerType())
        assertEquals(player.getMark(), "o")
    }

    @Test
    fun `returns a new instance of an unbeatable computer player, with the mark "i"`() {
        val playerFactory = PlayerFactory(inputValidator, displayer)

        val player = playerFactory.createPlayer("i", "unbeatable")

        assertTrue(player is ComputerPlayer)
        assertEquals(PlayerType.UNBEATABLE, player.getPlayerType())
        assertEquals(player.getMark(), "i")
    }
}
