package board

internal class Grid3By3 (private val squares: ArrayList<Square>): Grid {

    override val winningCombinations: Array<Array<Int>>
            get() = arrayOf(
                arrayOf(0, 1, 2),
                arrayOf(3, 4, 5),
                arrayOf(6, 7, 8),
                arrayOf(0, 3, 6),
                arrayOf(1, 4, 7),
                arrayOf(2, 5, 8),
                arrayOf(0, 4, 8),
                arrayOf(2, 4, 6)
            )

    override fun getSquares() = squares

    override fun getSquareValue(index: Int) = squares[index].getValue()

    override fun setSquareValue(index: Int, value: String) =
        squares[index].setValue(value)

    override fun size() = squares.size

    override fun copy(): Grid {
        val squaresCopy = squares.mapTo(arrayListOf()) { it.copy() }
        return Grid3By3(squaresCopy)
    }

    override fun availableSquares(mark1: String, mark2: String) =
        squares.filterNot {
            (it.getValue() == mark1) or (it.getValue() == mark2)
        }
}
