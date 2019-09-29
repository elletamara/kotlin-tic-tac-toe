package game

import board.Board
import board.Grid3By3
import board.SquaresGenerator
import io.*
import io.mockk.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import player.ComputerPlayer
import player.PlayerMark

internal class GameControllerTest {
    private val displayerMock = mockk<Displayer>()
    private val gameFactoryMock = mockk<GameFactory>()
    private val playerMock = mockk<ComputerPlayer>()

    private fun gameSetup():Game {
        val board = Board(Grid3By3(SquaresGenerator.generateNineSquares()))
        return Game(board, playerMock, playerMock)
    }

    @Nested
    inner class StartGame {

        @Test
        fun `calls Displayer's gameOutcomeMessage and goodbyeMessage when the game is complete`() {
            every { playerMock.chooseMove(any(), any()) } returnsMany listOf(1, 9, 2, 8, 3)
            every { playerMock.getMark() } returns PlayerMark.ONE.string
            every { gameFactoryMock.createGameWith3By3Grid() } returns gameSetup()
            every { displayerMock.gameOutcomeMessage(any(), any()) } just Runs
            every { displayerMock.goodbyeMessage() } just Runs

            val gameController = GameController(gameFactoryMock, displayerMock)

            gameController.startGame()

            verify {
                displayerMock.gameOutcomeMessage(any(), any())
                displayerMock.goodbyeMessage()
            }
        }
    }
}
