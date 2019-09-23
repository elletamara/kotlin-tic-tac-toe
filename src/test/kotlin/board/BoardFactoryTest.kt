package board

import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.jupiter.api.Test



internal class BoardFactoryTest {
    @Test
    fun `creates a new instance of Board with a Grid of 9 Squares`() {

        val board = BoardFactory.create3by3Board()

        assertThat(board, instanceOf(Board::class.java))
    }
}
