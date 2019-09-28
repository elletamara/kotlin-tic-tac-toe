package board

import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Test


internal class BoardFactoryTest {
    @Test
    fun `creates a new instance of Board with a Grid of 9 Squares`() {

        val board = BoardFactory.createBoardWith3By3Grid()

        assertTrue(board is Board)
    }
}
