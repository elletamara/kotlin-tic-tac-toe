package game

import io.*
import io.mockk.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.*

internal class GameControllerTest {
    private val consoleOutputMock = mockk<ConsoleOutput>()

    @Nested
    inner class StartGame {

        @Test
        fun `displays the winner outcome message when a player has won`() {
            every { consoleOutputMock.println(any()) } just Runs
            val simulatedInput = ("human" + System.getProperty("line.separator")
                    + "human" + System.getProperty("line.separator")
                    + "1" + System.getProperty("line.separator")
                    + "4" + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator")
                    + "5" + System.getProperty("line.separator")
                    + "3" + System.getProperty("line.separator"))
            System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
            val input = BufferedReader(InputStreamReader(System.`in`))
            val consoleInput = ConsoleInput(input)
            val boardPresenter = BoardPresenter3By3()
            val displayer = Displayer(consoleOutputMock, boardPresenter)
            val inputValidator = InputValidator(consoleInput, displayer)
            val gameFactory = GameFactory(inputValidator, displayer)
            val gameController = GameController(gameFactory, displayer)

            gameController.startGame()

            verify {
                consoleOutputMock.println("Congratulations X, you're the winner!")
            }
        }

        @Test
        fun `displays the tie outcome message when the game is a tie`() {
            every { consoleOutputMock.println(any()) } just Runs
            val simulatedInput = ("human" + System.getProperty("line.separator")
                    + "human" + System.getProperty("line.separator")
                    + "1" + System.getProperty("line.separator")
                    + "5" + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator")
                    + "3" + System.getProperty("line.separator")
                    + "6" + System.getProperty("line.separator")
                    + "4" + System.getProperty("line.separator")
                    + "7" + System.getProperty("line.separator")
                    + "8" + System.getProperty("line.separator")
                    + "9" + System.getProperty("line.separator"))
            System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
            val input = BufferedReader(InputStreamReader(System.`in`))
            val consoleInput = ConsoleInput(input)
            val boardPresenter = BoardPresenter3By3()
            val displayer = Displayer(consoleOutputMock, boardPresenter)
            val inputValidator = InputValidator(consoleInput, displayer)
            val gameFactory = GameFactory(inputValidator, displayer)
            val gameController = GameController(gameFactory, displayer)

            gameController.startGame()

            verify {
                consoleOutputMock.println("It's a tie!")
            }
        }
    }
}
