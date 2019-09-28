package board

import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Assert
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Grid3By3Test {
    private fun defaultSquares(): ArrayList<Square> {
        return SquaresGenerator.generateNineSquares()
    }

    @Test
    fun `returns the grid with squares`() {
        val squares = defaultSquares()
        val grid = Grid3By3(squares)

        assertEquals(grid.getSquares(), squares)
    }

    @Test
    fun `returns the value of the Square at index 1`() {
        val grid = Grid3By3(defaultSquares())

        assertEquals(grid.getSquareValue(1), "2")
    }

    @Test
    fun `changes the value of the Square from "1", to "x"`() {
        val grid = Grid3By3(defaultSquares())

        grid.setSquareValue(0, "x")

        assertEquals(grid.getSquareValue(0), "x")
    }

    @Test
    fun `returns 9 as the number of Squares in the grid`() {
        val grid = Grid3By3(defaultSquares())

        val gridSize = grid.size()

        assertEquals(gridSize, 9)
    }

    @Test
    fun `returns a new instance of Grid containing copied squares`() {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("1", "x", "3", "4", "5", "x", "o", "o", "x")
        for(value in squareValues) squares.add(Square(value))
        val grid = Grid3By3(squares)

        val gridCopy = grid.copy()

        assertNotEquals(grid, gridCopy)
        assertNotEquals(grid.getSquares(), gridCopy.getSquares())
        assertEquals(grid.getSquareValue(1), gridCopy.getSquareValue(1))
        assertTrue(gridCopy is Grid)

    }

    @Test
    fun `returns a list of available squares`() {
        val expectedAvailableSquares = (arrayListOf(
            Square("2"),
            Square("3"),
            Square("4"),
            Square("6"),
            Square("7"),
            Square("8")
        ))
        val grid = Grid3By3(defaultSquares())

        grid.setSquareValue(0, "x")
        grid.setSquareValue(8, "o")
        grid.setSquareValue(4, "x")

        val availableSquares = grid.availableSquares("x", "o")

        assertEquals(expectedAvailableSquares.size, availableSquares.size)
    }
}

