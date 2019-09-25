package game

import board.Grid
import io.Displayer

internal class GameController(private val game: Game, private val displayer: Displayer) {

    fun startGame() {
        displayer.welcomeMessage()

        while (!game.isOver()) {
            game.playMove()
            game.toggleCurrentPlayer()
        }

        displayGameOutcomeAndGoodbyeMessage(game.board.getGrid())
    }

    private fun displayGameOutcomeAndGoodbyeMessage(grid: Grid) {
        displayer.gameOutcomeMessage(grid, game.outcome())
        displayer.goodbyeMessage()
    }
}
