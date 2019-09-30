package board

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


internal class BoardFactoryTest {

    @Nested
    inner class CreateBoardWith3By3Grid {

        @Test
        fun `creates a new instance of Board with a Grid of 9 Squares`() {

            val board = BoardFactory.createBoardWith3By3Grid()

            assertThat(board, instanceOf(Board::class.java))
            assertEquals(board.getGrid.size(), 9)
        }
    }


}
