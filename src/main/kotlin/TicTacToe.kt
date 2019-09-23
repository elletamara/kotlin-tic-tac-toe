import board.Board
import board.Grid
import board.Square
import io.ConsoleIO
import io.Display

fun main(args: Array<String>) {
    val squares: ArrayList<Square> = arrayListOf()
    val squareValues: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    for(value in squareValues) {
        squares.add(Square(value))
    }
    val grid =  Grid(squares)
    val board = Board(grid)
    val consoleIO = ConsoleIO()
    val display = Display(consoleIO)

    display.displayBoard(board.getGrid())
}
