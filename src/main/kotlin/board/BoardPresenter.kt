package board

internal interface BoardPresenter {
    fun presentBoard(grid: Grid): String
}
