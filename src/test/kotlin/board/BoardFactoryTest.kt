package board

import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.jupiter.api.Test


internal class BoardFactoryTest {
    @Test
    fun `creates a new instance of Board with a Grid of 9 Squares`() {

        val board = BoardFactory.createBoardWith3By3Grid()

        assertThat(board, instanceOf(Board::class.java))
    }
}
