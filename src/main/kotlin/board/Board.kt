package board

internal class Board(private val grid: Grid) {

    fun getGrid(): Grid {
        return this.grid
    }

    fun takeSquare(position: Int, newValue: String) {
        var index = position - 1
        this.grid.setSquare(index, newValue)
    }
}
