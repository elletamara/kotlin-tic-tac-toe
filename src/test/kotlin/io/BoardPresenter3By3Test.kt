package io

import board.BoardFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BoardPresenter3By3Test {
    @Test
    fun `presents the board as a string`() {
        val expected = """
            1 | 2 | 3
            ---------
            4 | 5 | 6
            ---------
            7 | 8 | 9
            
            """.trimIndent()
        val board = BoardFactory.create3by3Board()
        val boardPresenter = BoardPresenter3By3()

        val presentedBoard = boardPresenter.presentBoard(board.getGrid())

        assertEquals(expected, presentedBoard)
    }

}
