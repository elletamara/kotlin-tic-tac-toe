import board.Board
import board.Grid
import board.Square
import io.ConsoleIO
import io.Display

fun main(args: Array<String>) {
    val squares = arrayListOf(
        Square(1),
        Square(2),
        Square(3),
        Square(4),
        Square(5),
        Square(6),
        Square(7),
        Square(8),
        Square(9)
    )
    val grid =  Grid(squares)
    val board = Board(grid)
    val consoleIO = ConsoleIO()
    val display = Display(consoleIO)

    display.displayBoard(board.getGrid())
}
