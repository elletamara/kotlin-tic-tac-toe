package game

import board.BoardFactory
import io.BoardPresenter3By3
import io.ConsoleIO
import io.Displayer
import io.InputValidator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import player.HumanPlayer
import java.io.*

internal class GameControllerTest {

    @Test
    fun `displays the winner outcome message when a player has won`() {
        val board = BoardFactory.create3by3Board()
        val output = ByteArrayOutputStream()
        val simulatedInput = ("1" + System.getProperty("line.separator")
                + "4" + System.getProperty("line.separator")
                + "2" + System.getProperty("line.separator")
                + "5" + System.getProperty("line.separator")
                + "3" + System.getProperty("line.separator"))
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val player1 = HumanPlayer("x", inputValidator)
        val player2 = HumanPlayer("o", inputValidator)
        val game = Game(board, player1, player2)

        val gameController = GameController(game, displayer)

        gameController.startGame()

        assertTrue("Congratulations x, you're the winner!" in output.toString())
    }

    @Test
    fun `displays the tie outcome message when the game is a tie`() {
        val board = BoardFactory.create3by3Board()
        val output = ByteArrayOutputStream()
        val simulatedInput = ("1" + System.getProperty("line.separator")
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
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val inputValidator = InputValidator(consoleIO, displayer)
        val player1 = HumanPlayer("x", inputValidator)
        val player2 = HumanPlayer("o", inputValidator)
        val game = Game(board, player1, player2)

        val gameController = GameController(game, displayer)

        gameController.startGame()

        assertTrue("It's a tie!" in output.toString())
    }
}
