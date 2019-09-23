package player

import io.ConsoleIO

class HumanPlayer(private val mark: String, private val consoleIO: ConsoleIO): Player {
    override fun chooseMove(): Int {
        return consoleIO.getInput().toInt()
    }

    override fun getMark(): String {
        return this.mark
    }
}
