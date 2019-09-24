package io

import board.Grid

internal interface BoardPresenter {
    fun presentBoard(grid: Grid): String
}
