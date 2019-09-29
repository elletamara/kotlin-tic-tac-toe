package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class SquareTest {

    @Nested
    inner class GetValue {

        @Test
        fun `returns the value of the square`() {
            val square = Square("7")

            assertEquals(square.getValue(), "7")
        }
    }

    @Nested
    inner class SetValue {

        @Test
        fun `sets the value of the square`() {
            val square = Square("7")

            square.setValue("x")

            assertEquals(square.getValue(), "x")
        }
    }

    @Nested
    inner class Copy {

        @Test
        fun `copies the value of the square into a new instance of Square`() {
            val square = Square("7")

            val squareCopy = square.copy()

            assertEquals(square.getValue(), squareCopy.getValue())
            assertNotEquals(square, squareCopy)
        }
    }
}
