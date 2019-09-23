import board.BoardFactory
import game.Game
import io.ConsoleIO
import io.Display
import player.HumanPlayer
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val board = BoardFactory.create3by3Board()
    val input = BufferedReader(InputStreamReader(System.`in`))
    val consoleIO = ConsoleIO(input)
    val humanPlayer = HumanPlayer("x", consoleIO)
    val display = Display(consoleIO)
    val game = Game(board, humanPlayer)

    display.displayBoard(board.getGrid())
    println("make move")
    game.playMove()
    display.displayBoard(board.getGrid())

}
