package game

import board.BoardFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import player.HumanPlayer

internal class GameTest {

    @Test
    fun `puts the player's mark on the board at position 2`() {
        val board = BoardFactory.create3by3Board()
        val humanPlayer = HumanPlayer("x")
        val game = Game(board, humanPlayer)

        game.playMove()

        assertEquals(board.getGrid().getSquare(1), "x")
    }
}
