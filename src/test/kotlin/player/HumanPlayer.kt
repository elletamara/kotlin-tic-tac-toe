package player

class HumanPlayer(private val mark: String): Player {
    override fun chooseMove(): Int {
        return 2
    }

    override fun getMark(): String {
        return this.mark
    }
}
