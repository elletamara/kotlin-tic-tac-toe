import board.Board
import board.Grid
import board.SquaresGenerator
import io.ConsoleIO
import io.Display

fun main(args: Array<String>) {
    val squares = SquaresGenerator.generateNineSquares()
    val grid =  Grid(squares)
    val board = Board(grid)
    val consoleIO = ConsoleIO()
    val display = Display(consoleIO)

    display.displayBoard(board.getGrid())
}
