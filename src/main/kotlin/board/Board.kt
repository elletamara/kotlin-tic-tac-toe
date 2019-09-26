package board

internal class Board(private val grid: Grid) {

    fun getGrid(): Grid = this.grid

    fun takeSquare(position: Int, newValue: String) {
        val index = getPositionAsSquaresIndex(position)
        this.grid.setSquare(index, newValue)
    }

    fun isMoveValid(position: Int, player1Mark: String, player2Mark: String): Boolean {
        return isPositionValid(position) && isSquareAvailable(position, player1Mark, player2Mark)
    }

    fun getAvailableSquares(player1Mark: String, player2Mark: String): ArrayList<Square> {
        val squares = getGrid().getSquares()
        val availableSquares = squares.filterNot {
            (it.getValue() == player1Mark) or (it.getValue() == player2Mark)
        }

        return ArrayList(availableSquares)
    }

    fun isFull(player1Mark: String, player2Mark: String): Boolean {
        return getAvailableSquares(player1Mark, player2Mark).isEmpty()
    }

    fun isComplete(player1Mark: String, player2Mark: String): Boolean {
        return isFull(player1Mark, player2Mark) or winningLineExists(player1Mark, player2Mark)
    }

    fun isWinningPlayer(playerMark: String): Boolean {
        val winningCombinations = this.grid.winningCombinations
        val squares = grid.getSquares()

        return winningCombinations.any { combination ->
            combination.all {value ->
                squares[value].getValue() == playerMark
            }
        }
    }

    fun winningLineExists(player1Mark: String, player2Mark: String): Boolean {
        return isWinningPlayer(player1Mark) or isWinningPlayer(player2Mark)
    }

    fun copy():Board = Board(this.grid.copy())

    private fun isPositionValid(position: Int): Boolean {
        val index = getPositionAsSquaresIndex(position)
        val gridSize = grid.size() - 1

        return index in 0..gridSize
    }

    private fun isSquareAvailable(position: Int, player1Mark: String, player2Mark: String): Boolean {
        val index = getPositionAsSquaresIndex(position)
        val square = grid.getSquare(index)

        return square != player1Mark && square != player2Mark
    }

    private fun getPositionAsSquaresIndex(position: Int ): Int = position - 1
}
