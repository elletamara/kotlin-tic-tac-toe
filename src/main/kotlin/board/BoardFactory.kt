package board

internal class BoardFactory {
    companion object {
        fun create3by3Board(): Board {
            val squares = SquaresGenerator.generateNineSquares()
            val grid = Grid(squares)
            return Board(grid)
        }
    }
}
