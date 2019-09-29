package game

import io.BoardPresenter3By3
import io.ConsoleIO
import io.Displayer
import io.InputValidator
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

internal class GameFactoryTest {

    @Nested
    inner class CreateGameWith3By3Grid {

        @Test
        fun `returns a new instance of a game`() {
            val simulatedInput = "human\nunbeatable"
            System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
            val input = BufferedReader(InputStreamReader(System.`in`))
            val consoleIO = ConsoleIO(input)
            val boardPresenter = BoardPresenter3By3()
            val displayer = Displayer(consoleIO, boardPresenter)
            val inputValidator = InputValidator(consoleIO, displayer)
            val gameFactory = GameFactory(inputValidator, displayer)

            val game = gameFactory.createGameWith3By3Grid()

            assertThat(game, instanceOf(Game::class.java))
        }
    }
}
