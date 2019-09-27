package player

import io.BoardPresenter3By3
import io.ConsoleIO
import io.Displayer
import io.InputValidator
import org.junit.jupiter.api.Test
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
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

        assertThat(player, instanceOf(HumanPlayer::class.java))
        assertEquals(player.getMark(), "x")
    }

    @Test
    fun `returns a new instance of a easy computer player, with the mark "o"`() {
        val playerFactory = PlayerFactory(inputValidator, displayer)

        val player = playerFactory.createPlayer("o", "computer")

        assertThat(player, instanceOf(ComputerPlayer::class.java))
        assertEquals(PlayerType.EASY, player.getPlayerType())
        assertEquals(player.getMark(), "o")
    }

    @Test
    fun `returns a new instance of an unbeatable computer player, with the mark "i"`() {
        val playerFactory = PlayerFactory(inputValidator, displayer)

        val player = playerFactory.createPlayer("i", "unbeatable")

        assertThat(player, instanceOf(ComputerPlayer::class.java))
        assertEquals(PlayerType.UNBEATABLE, player.getPlayerType())
        assertEquals(player.getMark(), "i")
    }
}
