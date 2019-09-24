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

    private fun isPositionValid(position: Int): Boolean {
        val index = position - 1
        val gridSize = grid.size() - 1

        return index in 0..gridSize
    }

    private fun isSquareAvailable(position: Int, player1Mark: String, player2Mark: String): Boolean {
        val index = position - 1
        val square = grid.getSquare(index)

        return (!square.equals(player1Mark) && !square.equals(player2Mark))
    }
}
