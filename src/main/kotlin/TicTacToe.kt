import game.GameController
import game.GameFactory
import io.*
import io.BoardPresenter3By3
import io.Displayer
import io.InputValidator
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val input = BufferedReader(InputStreamReader(System.`in`))
    val consoleInput = ConsoleInput(input)
    val consoleOutput = ConsoleOutput()
    val boardPresenter = BoardPresenter3By3()
    val displayer = Displayer(consoleOutput, boardPresenter)
    val inputValidator = InputValidator(consoleInput, displayer)
    val gameFactory = GameFactory(inputValidator, displayer)
    val gameController = GameController(gameFactory, displayer)

    gameController.startGame()
}
