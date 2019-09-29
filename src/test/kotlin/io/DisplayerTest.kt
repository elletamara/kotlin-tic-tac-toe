package io

import board.BoardFactory
import board.Grid
import board.Grid3By3
import board.Square
import game.GameOutcome
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import player.PlayerMark
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader
import java.io.PrintStream

internal class DisplayerTest {

    private fun clearScreen(): String {
        return "\u001b[H\u001b[2J\n"
    }

    private fun displayerSetup(input: BufferedReader, output: ByteArrayOutputStream): Displayer {
        val consoleIO = ConsoleIO(input, PrintStream(output))
        val boardPresenter = BoardPresenter3By3()
        return Displayer(consoleIO, boardPresenter)
    }

    private fun fullGrid(): Grid {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "o", "o", "o", "x", "x", "o", "x", "o")
        for(value in squareValues) squares.add(Square(value))

        return Grid3By3(squares)
    }

    @Nested
    inner class HumanPlayerMakeMoveMessages {

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
            val input = BufferedReader(InputStreamReader(System.`in`))
            val output = ByteArrayOutputStream()
            val displayer = displayerSetup(input, output)
            val board = BoardFactory.createBoardWith3By3Grid()

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
            val input = BufferedReader(InputStreamReader(System.`in`))
            val output = ByteArrayOutputStream()
            val displayer = displayerSetup(input, output)
            val board = BoardFactory.createBoardWith3By3Grid()

            displayer.humanPlayerMakeMoveMessages(board.getGrid(), false)

            assertEquals(expectedOutput, output.toString())
        }
    }

    @Nested
    inner class ComputerPlayerMakeMoveMessages {

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
            val input = BufferedReader(InputStreamReader(System.`in`))
            val output = ByteArrayOutputStream()
            val displayer = displayerSetup(input, output)
            val board = BoardFactory.createBoardWith3By3Grid()

            displayer.computerPlayerMakeMoveMessages(board.getGrid(), "x")

            assertEquals(expectedOutput, output.toString())
        }
    }

    @Nested
    inner class PlayerSelectionMessage {

        @Test
        fun `outputs 'Please select the player type for player 1'`() {
            val input = BufferedReader(InputStreamReader(System.`in`))
            val output = ByteArrayOutputStream()
            val displayer = displayerSetup(input, output)

            displayer.playerSelectionMessage(1, PlayerMark.ONE.string)

            assertTrue(output.toString().contains("Please select the player type for player 1 (X)"))
            assertTrue(output.toString().contains("Human, Easy, or Unbeatable:"))
        }
    }

    @Nested
    inner class InvalidPlayerSelectionMessage {

        @Test
        fun `outputs 'That's an invalid player type Please try again'`() {
            val input = BufferedReader(InputStreamReader(System.`in`))
            val output = ByteArrayOutputStream()
            val displayer = displayerSetup(input, output)

            displayer.invalidPlayerSelectionMessage()

            assertTrue(output.toString().contains("That's an invalid player type. Please try again."))
        }
    }

    @Nested
    inner class ComputerIsThinkingMessage {

        @Test
        fun `outputs 'x is thinking Please wait'`() {
            val input = BufferedReader(InputStreamReader(System.`in`))
            val output = ByteArrayOutputStream()
            val displayer = displayerSetup(input, output)

            displayer.computerIsThinkingMessage("x")

            assertEquals("x is thinking. Please wait...\n", output.toString())
        }
    }

    @Nested
    inner class GameOutcomeMessage {

        @Test
        fun `outputs "Congratulations x, you're the winner!" when x has won `() {
            val expectedOutput = "Congratulations x, you're the winner!\n"
            val input = BufferedReader(InputStreamReader(System.`in`))
            val output = ByteArrayOutputStream()
            val displayer = displayerSetup(input, output)
            val grid = fullGrid()
            val outcome = "x"

            displayer.gameOutcomeMessage(grid, outcome)

            assertTrue(expectedOutput in output.toString())
        }

        @Test
        fun `returns "It's a tie!" when the game is a tie `() {
            val expectedOutput = "It's a tie!\n"
            val input = BufferedReader(InputStreamReader(System.`in`))
            val output = ByteArrayOutputStream()
            val displayer = displayerSetup(input, output)
            val outcome = GameOutcome.TIE.string
            val grid = fullGrid()

            displayer.gameOutcomeMessage(grid, outcome)

            assertTrue(expectedOutput in output.toString())
        }
    }

    @Nested
    inner class PlayerTurnMessage {

        @Test
        fun `displays "x, it's your turn!`() {
            val input = BufferedReader(InputStreamReader(System.`in`))
            val output = ByteArrayOutputStream()
            val displayer = displayerSetup(input, output)

            displayer.playerTurnMessage("x")

            assertEquals(
                clearScreen() +
                        "x, it's your turn!\n", output.toString()
            )
        }
    }

    @Nested
    inner class WelcomeMessage {

        @Test
        fun `displays "Hello! Welcome to Elle's Tic Tac Toe!"`() {
            val input = BufferedReader(InputStreamReader(System.`in`))
            val output = ByteArrayOutputStream()
            val displayer = displayerSetup(input, output)

            displayer.welcomeMessage()

            assertEquals(
                clearScreen() +
                        "Hello! Welcome to Elle's Tic Tac Toe.\n\n" +
                        clearScreen(), output.toString()
            )
        }
    }

    @Nested
    inner class GoodbyeMessage {

        @Test
        fun `displays "Thanks for playing Elle's Tic Tac Toe!"`() {
            val input = BufferedReader(InputStreamReader(System.`in`))
            val output = ByteArrayOutputStream()
            val displayer = displayerSetup(input, output)

            displayer.goodbyeMessage()

            assertEquals("Thanks for playing Elle's Tic Tac Toe!\n\n", output.toString())
        }
    }
}
