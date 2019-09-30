package io

import board.BoardFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import player.PlayerMark

internal class InputValidatorTest {
    private val currentPlayerMark = PlayerMark.ONE.string
    private val consoleInputMock = mockk<ConsoleInput>()

    @Nested
    inner class ValidateMove {

        @Test
        fun `returns the input as a digit, when the string contains digits only`() {
            every { consoleInputMock.getInput() } returns "9"
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val board = BoardFactory.createBoardWith3By3Grid()

            val move = inputValidator.validateMove(board, currentPlayerMark)

            assertEquals(9, move)
        }

        @Test
        fun `prompts user for input again when it is not valid`() {
            every { consoleInputMock.getInput() } returnsMany listOf("h", "1")
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)
            val board = BoardFactory.createBoardWith3By3Grid()

            val move = inputValidator.validateMove(board, currentPlayerMark)

            assertEquals(1, move)
        }
    }

    @Nested
    inner class ValidatePlayerSelection {

        @Test
        fun `returns the user's input when it matches a valid PlayerType`() {
            every { consoleInputMock.getInput() } returns "easy"
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)

            val player = inputValidator.validatePlayerSelection(1, PlayerMark.TWO.string)

            assertEquals("easy", player)
        }

        @Test
        fun `prompts the user for input again when the PlayerType is invalid`() {
            every { consoleInputMock.getInput() } returnsMany listOf("none", "unbeatable")
            val displayer = Displayer(ConsoleOutput(), BoardPresenter3By3())
            val inputValidator = InputValidator(consoleInputMock, displayer)

            val player = inputValidator.validatePlayerSelection(2, PlayerMark.TWO.string)

            assertEquals("unbeatable", player)
        }
    }
}
