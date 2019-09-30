package board

internal class Board(private val grid: Grid) {

    val getGrid: Grid by lazy { grid }

    fun takeSquare(position: Int, newValue: String) {
        grid.setSquareValue(position - 1, newValue)
    }

    fun isMoveValid(position: Int) =
        grid.getSquares().any { it.getValue() == position.toString() }

    fun getAvailableSquares(mark1: String, mark2: String) =
        grid.availableSquares(mark1, mark2)

    fun isFull(mark1: String, mark2: String) =
        getAvailableSquares(mark1, mark2).isEmpty()

    fun isComplete(mark1: String, mark2: String) =
        isFull(mark1, mark2) || (winningLineExists(mark1, mark2))

    fun isWinningPlayer(mark: String) =
        grid.winningCombinations.any { combination ->
            combination.all {index ->
                grid.getSquareValue(index) == mark
            }
        }

    fun winningLineExists(mark1: String, mark2: String) =
        isWinningPlayer(mark1) || isWinningPlayer(mark2)

    fun copy() = Board(grid.copy())
}
