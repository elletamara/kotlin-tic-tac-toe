package board

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BoardTest {

    private fun defaultSquares() = SquaresGenerator.generateNineSquares()

    private fun defaultGrid() = Grid3By3(defaultSquares())

    private fun fullGrid(): Grid {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "o", "o", "o", "x", "x", "o", "x", "o")
        for(value in squareValues) squares.add(Square(value))

        return Grid3By3(squares)
    }

    private fun gridWithOneAvailableSquare(): Grid {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("1", "o", "o", "o", "x", "x", "o", "x", "o")
        for(value in squareValues) squares.add(Square(value))

        return Grid3By3(squares)
    }

    private fun gridWithWinningCombination(): Grid {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "x", "x", "o", "o", "6", "o", "8", "9")
        for(value in squareValues) squares.add(Square(value))

        return Grid3By3(squares)
    }

    @Test
    fun `returns the grid`() {
        val grid = defaultGrid()
        val board = Board(grid)

        assertEquals(board.getGrid(), grid)
    }

    @Test
    fun `changes the value of the Square from "5" to "x"`() {
        val grid = defaultGrid()
        val board = Board(grid)

        board.takeSquare(5, "x")

        assertEquals(grid.getSquareValue(4), "x")
    }

    @Test
    fun `returns true when the move is valid`() {
        val grid = defaultGrid()
        val board = Board(grid)

        val isMoveValid = board.isMoveValid(4)

        assertTrue(isMoveValid)
    }

    @Test
    fun `returns false when the position does not exist`() {
        val grid = defaultGrid()
        val board = Board(grid)

        val isMoveValid = board.isMoveValid(10)

        assertFalse(isMoveValid)
    }

    @Test
    fun `returns true when the Square does not contain a mark`() {
        val grid = defaultGrid()
        val board = Board(grid)

        val isMoveValid = board.isMoveValid(1)

        assertTrue(isMoveValid)
    }

    @Test
    fun `returns false when the Square contains a mark`() {
        val grid = defaultGrid()
        val board = Board(grid)
        board.takeSquare(1, "x")

        val isMoveValid = board.isMoveValid(1)

        assertFalse(isMoveValid)
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
        val grid = defaultGrid()
        val board = Board(grid)
        board.takeSquare(1, "x")
        board.takeSquare(9, "o")
        board.takeSquare(5, "x")

        val availableSquares = board.getAvailableSquares("x", "o")

        assertEquals(expectedAvailableSquares.size, availableSquares.size)
    }

    @Test
    fun `returns true when there are zero available squares`() {
        val board = Board(fullGrid())

        val isBoardFull = board.isFull("x", "o")

        assertTrue(isBoardFull)
    }

    @Test
    fun `returns false when there are available squares`() {
        val board = Board(gridWithOneAvailableSquare())

        val isBoardFull = board.isFull("x", "o")

        assertFalse(isBoardFull)
    }

    @Test
    fun `returns true when the mark is in squares of a winning combination`() {
        val board = Board(gridWithWinningCombination())

        val isWinningPlayer = board.isWinningPlayer("x")

        assertTrue(isWinningPlayer)
    }

    @Test
    fun `returns false when the mark not in the squares of a winning combination`() {
        val board = Board(fullGrid())

        val isWinningPlayer = board.isWinningPlayer("x")

        assertFalse(isWinningPlayer)
    }

    @Test
    fun `returns true when either mark has a winning line`() {
        val board = Board(gridWithWinningCombination())

        val winningLineExists = board.winningLineExists("x", "o")

        assertTrue(winningLineExists)
    }

    @Test
    fun `returns false when the marks do not have a winning line`() {
        val board = Board(fullGrid())

        val winningLineExists = board.winningLineExists("x", "o")

        assertFalse(winningLineExists)
    }

    @Test
    fun `returns true when the board is full`() {
        val board = Board(fullGrid())

        val isComplete = board.isComplete("x", "o")

        assertTrue(isComplete)
    }

    @Test
    fun `returns true when a mark has a winning line`() {
        val board = Board(gridWithWinningCombination())

        val isComplete = board.isComplete("x", "o")

        assertTrue(isComplete)
    }

    @Test
    fun `returns false when the board is not full and a mark does not have a winning line`() {
        val board = Board(gridWithOneAvailableSquare())

        val isComplete = board.isComplete("x", "o")

        assertFalse(isComplete)
    }

    @Test
    fun `returns a new instance of the Board class, with a new instance of Grid and new instance of each Square`() {
        val board = Board(gridWithOneAvailableSquare())

        val boardCopy = board.copy()

        assertNotEquals(board, boardCopy)
        assertNotEquals(board.getGrid(), boardCopy.getGrid())
        assertNotEquals(board.getGrid().getSquares(), boardCopy.getGrid().getSquares())
        assertEquals(board.getGrid().getSquareValue(1), boardCopy.getGrid().getSquareValue(1))
        assertTrue(boardCopy is Board)
    }
}
