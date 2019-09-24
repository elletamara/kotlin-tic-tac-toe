package board

internal data class Grid (private val squares: ArrayList<Square>) {

    fun getSquares(): ArrayList<Square> {
        return this.squares
    }

    fun getSquare(index: Int): Any {
        return this.squares[index].getValue()
    }

    fun setSquare(index: Int, newValue: String) {
        this.squares[index].setValue(newValue)
    }

    fun size():Int {
        return this.squares.size
    }
}
