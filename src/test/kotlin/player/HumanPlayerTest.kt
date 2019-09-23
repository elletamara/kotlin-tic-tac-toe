package player

import io.ConsoleIO
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

internal class HumanPlayerTest {

    @Test
    fun `returns a move`() {
        var simulatedInput = "2"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        var input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val humanPlayer = HumanPlayer("x", consoleIO)

        val move = humanPlayer.chooseMove()

        assertEquals(move, 2)
    }

    @Test
    fun `returns the player's mark`() {
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val humanPlayer = HumanPlayer("x", consoleIO)

        val playerMark = humanPlayer.getMark()

        assertEquals(playerMark, "x")
    }
}
