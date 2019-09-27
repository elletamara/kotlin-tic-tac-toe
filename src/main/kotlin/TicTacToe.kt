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
    val consoleIO = ConsoleIO(input)
    val boardPresenter = BoardPresenter3By3()
    val displayer = Displayer(consoleIO, boardPresenter)
    val inputValidator = InputValidator(consoleIO, displayer)
    val game = GameFactory(inputValidator, displayer).createGameWith3By3Grid()
    val gameController = GameController(game, displayer)

    gameController.startGame()
}
