package game

import io.Displayer

internal class GameController(private val game: Game, private val displayer: Displayer) {

    fun startGame() {
        displayer.welcomeMessage()

        while (!game.isOver()) {
            game.playMove()
            game.toggleCurrentPlayer()
        }

        displayGameOutcomeAndGoodbyeMessage()
    }

    private fun displayGameOutcomeAndGoodbyeMessage() {
        displayer.gameOutcomeMessage(game.outcome())
        displayer.goodbyeMessage()
    }
}
