package board

internal data class Grid (private val squares: ArrayList<Square>) {

    fun getSquares(): ArrayList<Square> {
        return squares
    }

    fun getSquare(index: Int): Any {
        return squares[index].getValue()
    }
}
