package player

import board.Board
import io.Displayer
import player.moveStrategy.MoveStrategy

internal class ComputerPlayer(
    private val mark: String, private val displayer: Displayer, private val moveStrategy: MoveStrategy): Player {

    override fun chooseMove(board: Board, currentPlayersMark: String, opponentsMark: String): Int {
        displayer.computerPlayerMakeMoveMessages(board.getGrid(), currentPlayersMark)
        displayer.computerIsThinkingMessage(currentPlayersMark)

        return this.moveStrategy.getMove(board, currentPlayersMark, opponentsMark)
    }

    override fun getMark(): String = this.mark
}
