package player

import io.BoardPresenter3By3
import io.ConsoleIO
import io.Displayer
import io.InputValidator
import org.junit.jupiter.api.Test
import org.junit.Assert.*
import org.junit.jupiter.api.Nested
import java.io.BufferedReader
import java.io.InputStreamReader

internal class PlayerFactoryTest {

    private fun consoleIOSetup(): ConsoleIO {
        val input = BufferedReader(InputStreamReader(System.`in`))
        return ConsoleIO(input)
    }

    private val displayer = Displayer(consoleIOSetup(), BoardPresenter3By3())
    private val inputValidator = InputValidator(consoleIOSetup(), displayer)

    @Nested
    inner class CreatePlayer {

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
            assertEquals(player.getMark(), "o")
        }

        @Test
        fun `returns a new instance of an unbeatable computer player, with the mark "i"`() {
            val playerFactory = PlayerFactory(inputValidator, displayer)

            val player = playerFactory.createPlayer("i", "unbeatable")

            assertTrue(player is ComputerPlayer)
            assertEquals(player.getMark(), "i")
        }
    }
}
