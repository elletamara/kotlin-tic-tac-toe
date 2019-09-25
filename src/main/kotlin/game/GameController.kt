package game

import io.Displayer

internal class GameController(private val game: Game, private val displayer: Displayer) {

    fun startGame() {
        while (!game.isOver()) {
            game.playMove()
            game.toggleCurrentPlayer()
        }

        displayer.gameOutcomeMessage(game.outcome())
    }
}
