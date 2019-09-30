import game.GameController
import game.GameFactory
import io.*
import io.BoardPresenter3By3
import io.Displayer
import io.InputValidator

fun main() {
    val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
    val inputValidator = InputValidator(ConsoleInput(), displayer)
    val gameFactory = GameFactory(inputValidator, displayer)
    val gameController = GameController(gameFactory, displayer)

    gameController.startGame()
}
