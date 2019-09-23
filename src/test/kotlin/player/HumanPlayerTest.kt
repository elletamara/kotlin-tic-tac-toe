package player

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HumanPlayerTest {

    @Test
    fun `returns a move`() {
        val humanPlayer = HumanPlayer("x")

        val move = humanPlayer.chooseMove()

        assertEquals(move, 2)
    }

    @Test
    fun `returns the player's mark`() {
        val humanPlayer = HumanPlayer("x")

        val playerMark = humanPlayer.getMark()

        assertEquals(playerMark, "x")
    }
}
