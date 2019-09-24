package player

import io.InputValidator

internal class HumanPlayer(private val mark: String, private val inputValidator: InputValidator): Player {
    override fun chooseMove(): Int {
        println("hello")
        val move = inputValidator.validateMove()
        println(move)
        return move
    }

    override fun getMark(): String {
        return this.mark
    }
}
