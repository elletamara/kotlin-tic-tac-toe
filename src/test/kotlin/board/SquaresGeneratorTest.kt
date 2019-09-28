package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class SquaresGeneratorTest {
    @Test
    fun `returns an array list containing nine Squares, numbered 1-9`() {
        val squares = SquaresGenerator.generateNineSquares()

        assertEquals(squares.size, 9)

        val indices = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
        indices.forEach { assertEquals(squares[it].getValue(), (it + 1).toString()) }
    }
}


