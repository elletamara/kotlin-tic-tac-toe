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
        val squares = defaultSquares()
        val grid = Grid3By3(squares)

        assertEquals(grid.getSquare(1), "2")
    }

    @Test
    fun `changes the value of the Square from "1", to "x"`() {
        val squares = defaultSquares()
        val grid = Grid3By3(squares)

        grid.setSquare(0, "x")

        assertEquals(grid.getSquare(0), "x")
    }

    @Test
    fun `returns 9 as the number of Squares in the grid`() {
        val squares = defaultSquares()
        val grid = Grid3By3(squares)

        val gridSize = grid.size()

        assertEquals(gridSize, 9)
    }

    @Test
    fun `returns a new instance of Grid containing copied squares`() {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("1", "x", "3", "4", "5", "x", "o", "o", "x")
        for(value in squareValues) {
            squares.add(Square(value))
        }
        val grid = Grid3By3(squares)

        val gridCopy = grid.copy()

        assertNotEquals(grid, gridCopy)
        assertNotEquals(grid.getSquares(), gridCopy.getSquares())
        assertEquals(grid.getSquares()[1].getValue(), gridCopy.getSquares()[1].getValue())
        Assert.assertThat(gridCopy, instanceOf(Grid3By3::class.java))

    }
}

