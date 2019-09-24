import board.BoardFactory
import game.Game
import io.*
import io.BoardPresenter3By3
import io.Displayer
import io.InputValidator
import player.HumanPlayer
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val board = BoardFactory.create3by3Board()
    val input = BufferedReader(InputStreamReader(System.`in`))
    val consoleIO = ConsoleIO(input)
    val boardPresenter = BoardPresenter3By3()
    val displayer = Displayer(consoleIO, boardPresenter)
    val inputValidator = InputValidator(consoleIO, displayer)
    val player1 = HumanPlayer("x", inputValidator)
    val player2 = HumanPlayer("o", inputValidator)
    val game = Game(board, player1, player2)

    game.playMove()

}
