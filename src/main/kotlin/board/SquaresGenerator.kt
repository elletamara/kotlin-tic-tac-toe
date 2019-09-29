package board

internal class SquaresGenerator {
    companion object {
        fun generateNineSquares(): ArrayList<Square> {
            val squareValues: Array<String> = arrayOf(
                "1", "2", "3", "4", "5", "6", "7", "8", "9")
            return squareValues.mapTo(arrayListOf()) { Square(it) }
        }
    }
}
