import board.Board
import board.Grid
import board.SquaresGenerator
import io.ConsoleIO
import io.Display
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val squares = SquaresGenerator.generateNineSquares()
    val grid =  Grid(squares)
    val board = Board(grid)
    val input = BufferedReader(InputStreamReader(System.`in`))
    val consoleIO = ConsoleIO(input)
    val display = Display(consoleIO)

    display.displayBoard(board.getGrid())
}
