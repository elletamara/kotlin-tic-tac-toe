package player

import io.ConsoleIO
import io.InputValidator
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

internal class HumanPlayerTest {

    @Test
    fun `returns a move`() {
        val simulatedInput = "2"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val inputValidator = InputValidator(consoleIO)
        val humanPlayer = HumanPlayer("x", inputValidator)

        val move = humanPlayer.chooseMove()

        assertEquals(move, 2)
    }

    @Test
    fun `returns the player's mark`() {
        val input = BufferedReader(InputStreamReader(System.`in`))
        val consoleIO = ConsoleIO(input)
        val inputValidator = InputValidator(consoleIO)
        val humanPlayer = HumanPlayer("x", inputValidator)

        val playerMark = humanPlayer.getMark()

        assertEquals(playerMark, "x")
    }
}
