package player

import board.Board
import io.Displayer
import player.moveStrategy.MoveStrategy

internal class ComputerPlayer(
    private val mark: String, private val displayer: Displayer, private val moveStrategy: MoveStrategy): Player {

    override fun chooseMove(board: Board, opponentsMark: String): Int {
        with(displayer) {
            computerPlayerMakeMoveMessages(board.getGrid(), mark)
            computerIsThinkingMessage(mark)
        }
        return moveStrategy.getMove(board, mark, opponentsMark)
    }

    override fun getMark() = mark
}
