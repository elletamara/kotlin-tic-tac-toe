package game

import io.*
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class GameFactoryTest {
    private val consoleInputMock = mockk<ConsoleInput>()

    @Nested
    inner class CreateGameWith3By3Grid {

        @Test
        fun `returns a new instance of a game`() {
            every { consoleInputMock.getInput() } returnsMany listOf("human", "unbeatable")
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val gameFactory = GameFactory(inputValidator, displayer)

            val game = gameFactory.createGameWith3By3Grid()

            assertThat(game, instanceOf(Game::class.java))
        }
    }
}
