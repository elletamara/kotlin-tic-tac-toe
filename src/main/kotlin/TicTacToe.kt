import board.BoardFactory
import game.Game
import game.GameController
import io.*
import io.BoardPresenter3By3
import io.Displayer
import io.InputValidator
import player.ComputerPlayer
import player.HumanPlayer
import player.moveStrategy.MinimaxStrategy
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val board = BoardFactory.create3by3Board()
    val input = BufferedReader(InputStreamReader(System.`in`))
    val consoleIO = ConsoleIO(input)
    val boardPresenter = BoardPresenter3By3()
    val displayer = Displayer(consoleIO, boardPresenter)
    val inputValidator = InputValidator(consoleIO, displayer)
    val strategy = MinimaxStrategy()
    val player1 = HumanPlayer("x", inputValidator)
    val player2 = ComputerPlayer("o", displayer, strategy)
    val game = Game(board, player1, player2)
    val gameController = GameController(game, displayer)

    gameController.startGame()

}
