package board

internal class BoardFactory {
    companion object {
        fun createBoardWith3By3Grid(): Board {
            val squares = SquaresGenerator.generateNineSquares()
            return Board(Grid3By3(squares))
        }
    }
}
