package player

import io.Displayer
import io.InputValidator
import player.moveStrategy.RandomMoveStrategy
import player.moveStrategy.UnbeatableStrategy

internal class PlayerFactory(
    private val inputValidator: InputValidator, private val displayer: Displayer) {

    fun createPlayer(mark: String, playerTypeString: String): Player {
        return when(playerTypeString) {
            PlayerType.HUMAN.string -> HumanPlayer(mark, inputValidator)
            PlayerType.EASY.string -> ComputerPlayer(mark, displayer, RandomMoveStrategy())
            PlayerType.UNBEATABLE.string -> ComputerPlayer(mark, displayer, UnbeatableStrategy())
            else -> ComputerPlayer(mark, displayer, RandomMoveStrategy())
        }
    }
}
