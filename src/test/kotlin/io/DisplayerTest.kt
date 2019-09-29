package io

import board.BoardFactory
import board.Grid
import board.Grid3By3
import board.Square
import game.GameOutcome
import io.mockk.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import player.PlayerMark

internal class DisplayerTest {

    private val consoleIOMock = mockk<ConsoleIO>()

    private fun displayerSetup(): Displayer {
        val boardPresenter = BoardPresenter3By3()
        return Displayer(consoleIOMock, boardPresenter)
    }

    private fun fullGrid(): Grid {
        val squares: ArrayList<Square> = arrayListOf()
        val squareValues: Array<String> = arrayOf("x", "o", "o", "o", "x", "x", "o", "x", "o")
        for(value in squareValues) squares.add(Square(value))

        return Grid3By3(squares)
    }

    @Nested
    inner class WelcomeMessage {

        @Test
        fun `displays "Hello! Welcome to Elle's Tic Tac Toe!"`() {
            every { consoleIOMock.println(any()) } just Runs
            val displayer = displayerSetup()

            displayer.welcomeMessage()

            verify {
                consoleIOMock.println("Hello! Welcome to Elle's Tic Tac Toe.\n")
            }
        }
    }

    @Nested
    inner class HumanPlayerMakeMoveMessages {

        @Test
        fun `displays the move prompt and the grid when the move is valid`() {
            every { consoleIOMock.println(any()) } just Runs
            val expectedGridOutput = """
            1 | 2 | 3
            ---------
            4 | 5 | 6
            ---------
            7 | 8 | 9
            
        """.trimIndent()
            val displayer = displayerSetup()
            val board = BoardFactory.createBoardWith3By3Grid()

            displayer.humanPlayerMakeMoveMessages(board.getGrid())

            verify {
                consoleIOMock.println("Select an available move:\n")
                consoleIOMock.println(expectedGridOutput)
            }
        }


        @Test
        fun `displays the error message when the move is invalid`() {
            every { consoleIOMock.println(any()) } just Runs
            val expectedGridOutput = """
            1 | 2 | 3
            ---------
            4 | 5 | 6
            ---------
            7 | 8 | 9
            
        """.trimIndent()
            val displayer = displayerSetup()
            val board = BoardFactory.createBoardWith3By3Grid()

            displayer.humanPlayerMakeMoveMessages(board.getGrid(), false)

            verify {
                consoleIOMock.println("That's an invalid move. Please try again.")
                consoleIOMock.println(expectedGridOutput)
            }
        }
    }

    @Nested
    inner class ComputerPlayerMakeMoveMessages {

        @Test
        fun `displays the move prompt and the grid`() {
            every { consoleIOMock.println(any()) } just Runs
            val expectedGridOutput = """
            1 | 2 | 3
            ---------
            4 | 5 | 6
            ---------
            7 | 8 | 9
            
        """.trimIndent()
            val displayer = displayerSetup()
            val board = BoardFactory.createBoardWith3By3Grid()

            displayer.computerPlayerMakeMoveMessages(board.getGrid(), "x")

            verify {
                consoleIOMock.println("x, it's your turn!")
                consoleIOMock.println("Select an available move:\n")
                consoleIOMock.println(expectedGridOutput)
            }
        }
    }

    @Nested
    inner class PlayerSelectionMessage {

        @Test
        fun `outputs 'Please select the player type for player 1'`() {
            every { consoleIOMock.println(any()) } just Runs
            val displayer = displayerSetup()
            val mark = PlayerMark.ONE.string

            displayer.playerSelectionMessage(1, mark)

            verify {
                consoleIOMock.println("Please select the player type for player "
                        + "1 (X)"
                        + "\n"
                        + "Human, Easy, or Unbeatable:"
                )
            }
        }
    }

    @Nested
    inner class InvalidPlayerSelectionMessage {

        @Test
        fun `outputs 'That's an invalid player type Please try again'`() {
            every { consoleIOMock.println(any()) } just Runs
            val displayer = displayerSetup()

            displayer.invalidPlayerSelectionMessage()

            verify {
                consoleIOMock.println("That's an invalid player type. Please try again.")
            }
        }
    }

    @Nested
    inner class ComputerIsThinkingMessage {

        @Test
        fun `outputs 'x is thinking Please wait'`() {
            every { consoleIOMock.println(any()) } just Runs
            val displayer = displayerSetup()

            displayer.computerIsThinkingMessage("x")

            verify {
                consoleIOMock.println("x is thinking. Please wait...")
            }
        }
    }

    @Nested
    inner class GameOutcomeMessage {

        @Test
        fun `outputs "Congratulations X, you're the winner!" when x has won `() {
            every { consoleIOMock.println(any()) } just Runs
            val displayer = displayerSetup()
            val grid = fullGrid()

            displayer.gameOutcomeMessage(grid, PlayerMark.ONE.string)

            verify {
                consoleIOMock.println("Congratulations X, you're the winner!")
            }
        }

        @Test
        fun `returns "It's a tie!" when the game is a tie `() {
            every { consoleIOMock.println(any()) } just Runs
            val displayer = displayerSetup()
            val outcome = GameOutcome.TIE.string
            val grid = fullGrid()

            displayer.gameOutcomeMessage(grid, outcome)

            verify {
                consoleIOMock.println("It's a tie!")
            }
        }
    }

    @Nested
    inner class PlayerTurnMessage {

        @Test
        fun `displays "X, it's your turn!`() {
            every { consoleIOMock.println(any()) } just Runs
            val displayer = displayerSetup()

            displayer.playerTurnMessage(PlayerMark.ONE.string)

            verify {
                consoleIOMock.println("X, it's your turn!")
            }
        }
    }

    @Nested
    inner class GoodbyeMessage {

        @Test
        fun `displays "Thanks for playing Elle's Tic Tac Toe!"`() {
            every { consoleIOMock.println(any()) } just Runs
            val displayer = displayerSetup()

            displayer.goodbyeMessage()

            verify {
                consoleIOMock.println("Thanks for playing Elle's Tic Tac Toe!\n")
            }
        }
    }
}
