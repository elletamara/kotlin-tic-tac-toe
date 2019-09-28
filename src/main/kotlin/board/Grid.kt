package board

internal interface Grid {
    val winningCombinations: Array<Array<Int>>

    fun getSquares(): ArrayList<Square>

    fun getSquareValue(index: Int): String

    fun setSquareValue(index: Int, value: String)

    fun size(): Int

    fun copy(): Grid

    fun availableSquares(mark1: String, mark2: String): List<Square>
}
