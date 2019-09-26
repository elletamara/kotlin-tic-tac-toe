package board

internal class SquaresGenerator {
    companion object {
        fun generateNineSquares(): ArrayList<Square> {
            val squares: ArrayList<Square> = arrayListOf()
            val squareValues: Array<String> = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
            for(value in squareValues) squares.add(Square(value))
            return squares
        }
    }
}
