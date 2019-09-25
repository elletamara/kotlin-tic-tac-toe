package board

internal interface Grid {
    val winningCombinations: ArrayList<ArrayList<Int>>

    fun getSquares(): ArrayList<Square>

    fun getSquare(index: Int): Any

    fun setSquare(index: Int, newValue: String)

    fun size():Int

    fun copy(): Grid
}
