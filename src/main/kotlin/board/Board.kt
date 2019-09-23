package board

internal class Board(private val grid: Grid) {

    fun getGrid(): Grid {
        return this.grid
    }

    fun takeSquare(position: Int, newValue: String) {
        var index = position - 1
        this.grid.setSquare(index, newValue)
    }

    fun isPositionValid(position: Int): Boolean {
        val index = position - 1
        val gridSize = grid.size() - 1

        return index in 0..gridSize
    }
}
