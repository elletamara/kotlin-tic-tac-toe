package board

internal class BoardFactory {
    companion object {
        fun createBoardWith3By3Grid(): Board {
            val grid = Grid3By3(SquaresGenerator.generateNineSquares())
            return Board(grid)
        }
    }
}
