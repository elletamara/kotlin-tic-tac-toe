package board

internal class Board(private val grid: Grid) {

    fun getGrid(): Grid {
        return this.grid
    }

    fun takeSquare(position: Int, newValue: String) {
        val index = position - 1
        this.grid.setSquare(index, newValue)
    }

    fun isMoveValid(position: Int, player1Mark: String, player2Mark: String): Boolean {
        return isPositionValid(position) &&
                isSquareAvailable(position, player1Mark, player2Mark)
    }

    fun getAvailableSquares(player1Mark: String, player2Mark: String): ArrayList<Square> {
        val squares = getGrid().getSquares()
        val availableSquares = squares.filterNot {
            it.getValue() == player1Mark || it.getValue() == player2Mark }

        return ArrayList(availableSquares)
    }

    fun isFull(player1Mark: String, player2Mark: String): Boolean {
        return getAvailableSquares(player1Mark, player2Mark).isEmpty()
    }

    fun isWinningPlayer(playerMark: String): Boolean {
        val winningCombinations = grid.winningCombinations
        val squares = grid.getSquares()

        return winningCombinations.any {
            it.all {
                squares[it].getValue() == playerMark
            }
        }
    }

    fun winningLineExists(player1Mark: String, player2Mark: String): Boolean {
        return isWinningPlayer(player1Mark) || isWinningPlayer(player2Mark)
    }

    private fun isPositionValid(position: Int): Boolean {
        val index = position - 1
        val gridSize = grid.size() - 1

        return index in 0..gridSize
    }

    private fun isSquareAvailable(position: Int, player1Mark: String, player2Mark: String): Boolean {
        val index = position - 1
        val square = grid.getSquare(index)

        return square != player1Mark && square != player2Mark
    }
}
