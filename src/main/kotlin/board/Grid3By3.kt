package board

internal data class Grid3By3 (private val squares: ArrayList<Square>): Grid {

    override val winningCombinations: ArrayList<ArrayList<Int>>
            get() = arrayListOf(
                arrayListOf(0, 1, 2),
                arrayListOf(3, 4, 5),
                arrayListOf(6, 7, 8),
                arrayListOf(0, 3, 6),
                arrayListOf(1, 4, 7),
                arrayListOf(2, 5, 8),
                arrayListOf(0, 4, 8),
                arrayListOf(2, 4, 6)
            )

    override fun getSquares(): ArrayList<Square> {
        return this.squares
    }

    override fun getSquare(index: Int): Any {
        return this.squares[index].getValue()
    }

    override fun setSquare(index: Int, newValue: String) {
        this.squares[index].setValue(newValue)
    }

    override fun size():Int {
        return this.squares.size
    }

}
