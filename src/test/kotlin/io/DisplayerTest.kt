package io

import board.BoardFactory
import game.GameOutcome
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader
import java.io.PrintStream

internal class DisplayerTest {

    private fun clearScreen(): String {
        return "\u001b[H\u001b[2J\n"
    }

    @Test
    fun `displays the grid`() {
        val expectedOutput = """ 
            1 | 2 | 3
            ---------
            4 | 5 | 6
            ---------
            7 | 8 | 9
            
            
        """.trimIndent()
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val board = BoardFactory.create3by3Board()

        displayer.showGrid(board.getGrid())

        assertEquals(expectedOutput, output.toString())

    }

    @Test
    fun `displays the move prompt and the grid when the move is valid`() {
        val expectedOutput = """
            Select an available move:
            
            1 | 2 | 3
            ---------
            4 | 5 | 6
            ---------
            7 | 8 | 9
            
            
        """.trimIndent()
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val board = BoardFactory.create3by3Board()

        displayer.humanPlayerMakeMoveMessages(board.getGrid())

        assertEquals(expectedOutput, output.toString())

    }

    @Test
    fun `displays the error message when the move is invalid`() {
        val expectedOutput = """
            That's an invalid move. Please try again.
            1 | 2 | 3
            ---------
            4 | 5 | 6
            ---------
            7 | 8 | 9
            
            
        """.trimIndent()
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val board = BoardFactory.create3by3Board()

        displayer.humanPlayerMakeMoveMessages(board.getGrid(), false)

        assertEquals(expectedOutput, output.toString())
    }

    @Test
    fun `displays the move prompt and the grid`() {
        val expectedOutput = clearScreen() + """
            x, it's your turn!
            Select an available move:
            
            1 | 2 | 3
            ---------
            4 | 5 | 6
            ---------
            7 | 8 | 9
            
            
        """.trimIndent()
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val board = BoardFactory.create3by3Board()

        displayer.computerPlayerMakeMoveMessages(board.getGrid(), "x")

        assertEquals(expectedOutput, output.toString())
    }

    @Test
    fun `outputs 'x is thinking Please wait'`() {
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)

        displayer.computerIsThinkingMessage("x")

        assertEquals("x is thinking. Please wait...\n", output.toString())
    }

    @Test
    fun `outputs "Congratulations x, you're the winner!" when x has won `() {
        val expectedOutput = clearScreen() +
                "Congratulations x, you're the winner!\n"
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val outcome = "x"

        displayer.gameOutcomeMessage(outcome)

        assertEquals(expectedOutput, output.toString())
    }

    @Test
    fun `returns "It's a tie!" when the game is a tie `() {
        val expectedOutput = clearScreen() +
                "It's a tie!\n"
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)
        val outcome = GameOutcome.TIE.string

        displayer.gameOutcomeMessage(outcome)

        assertEquals(expectedOutput, output.toString())
    }

    @Test
    fun `displays "x, it's your turn!`() {
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)

        displayer.playerTurnMessage("x")

        assertEquals(clearScreen() +
                "x, it's your turn!\n", output.toString())
    }

    @Test
    fun `displays "Hello! Welcome to Elle's Tic Tac Toe!"`() {
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)

        displayer.welcomeMessage()

        assertEquals(clearScreen() +
                "Hello! Welcome to Elle's Tic Tac Toe.\n\n" +
                clearScreen(), output.toString())
    }

    @Test
    fun `displays "Thanks for playing Elle's Tic Tac Toe!"`() {
        val output = ByteArrayOutputStream()
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        val displayer = Displayer(consoleIO, boardPresenter)

        displayer.goodbyeMessage()

        assertEquals("Thanks for playing Elle's Tic Tac Toe!\n\n", output.toString())
    }
}
