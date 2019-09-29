package game

import io.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.*

internal class GameControllerTest {

    @Nested
    inner class StartGame {

        @Test
        fun `displays the winner outcome message when a player has won`() {
            val output = ByteArrayOutputStream()
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
            val consoleOutput = ConsoleOutput(PrintStream(output))
            val displayer = Displayer(consoleOutput, boardPresenter)
            val inputValidator = InputValidator(consoleInput, displayer)
            val gameFactory = GameFactory(inputValidator, displayer)
            val gameController = GameController(gameFactory, displayer)

            gameController.startGame()

            println(output.toString())

            assertTrue("Hello! Welcome to Elle's Tic Tac Toe.\n" in output.toString())
            assertTrue("Congratulations X, you're the winner!" in output.toString())
        }

        @Test
        fun `displays the tie outcome message when the game is a tie`() {
            val output = ByteArrayOutputStream()
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
            val consoleOutput = ConsoleOutput(PrintStream(output))
            val displayer = Displayer(consoleOutput, boardPresenter)
            val inputValidator = InputValidator(consoleInput, displayer)
            val gameFactory = GameFactory(inputValidator, displayer)
            val gameController = GameController(gameFactory, displayer)

            gameController.startGame()

            assertTrue("Hello! Welcome to Elle's Tic Tac Toe.\n" in output.toString())
            assertTrue("It's a tie!" in output.toString())
        }
    }
}
