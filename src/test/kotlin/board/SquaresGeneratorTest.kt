package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class SquaresGeneratorTest {
    @Test
    fun `returns an array list containing nine Squares, numbered 1-9`() {

        val squares = SquaresGenerator.generateNineSquares()

        assertEquals(squares.size, 9)
        assertEquals(squares[0].getValue(), "1")
        assertEquals(squares[1].getValue(), "2")
        assertEquals(squares[2].getValue(), "3")
        assertEquals(squares[3].getValue(), "4")
        assertEquals(squares[4].getValue(), "5")
        assertEquals(squares[5].getValue(), "6")
        assertEquals(squares[6].getValue(), "7")
        assertEquals(squares[7].getValue(), "8")
        assertEquals(squares[8].getValue(), "9")
    }
}


