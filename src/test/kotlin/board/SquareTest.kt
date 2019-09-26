package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SquareTest {
    @Test
    fun `returns the value of the square`() {
        var square = Square("7")

        assertEquals(square.getValue(), "7")
    }

    @Test
    fun `sets the value of the square`() {
        var square = Square("7")

        square.setValue("x")

        assertEquals(square.getValue(), "x")
    }

    @Test
    fun `copies the value of the square into a new instance of Square`() {
        var square = Square("7")

        val squareCopy = square.copy()

        assertEquals(square.getValue(), squareCopy.getValue())
        assertNotEquals(square, squareCopy)
    }
}


