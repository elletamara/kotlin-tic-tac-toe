package player

import board.Board
import io.Displayer
import player.moveStrategy.MoveStrategy
import player.moveStrategy.RandomMoveStrategy
import player.moveStrategy.UnbeatableStrategy

internal class ComputerPlayer(
    private val mark: String, private val displayer: Displayer, private val moveStrategy: MoveStrategy): Player {

    var computerPlayerType: PlayerType = setPlayerType()

    override fun chooseMove(board: Board, currentPlayersMark: String, opponentsMark: String): Int {
        displayer.computerPlayerMakeMoveMessages(board.getGrid(), currentPlayersMark)
        displayer.computerIsThinkingMessage(currentPlayersMark)

        return this.moveStrategy.getMove(board, currentPlayersMark, opponentsMark)
    }

    override fun getMark(): String = this.mark

    override fun getPlayerType(): PlayerType = this.computerPlayerType

    override fun setPlayerType(): PlayerType {
        return when(moveStrategy) {
            is RandomMoveStrategy -> PlayerType.EASY
            is UnbeatableStrategy -> PlayerType.UNBEATABLE
            else -> PlayerType.INVALID
        }
    }
}
