package game

import board.Grid
import io.Displayer

internal class GameController(private val gameFactory: GameFactory, private val displayer: Displayer) {
    lateinit var game: Game

    fun startGame() {
        game = gameFactory.createGameWith3By3Grid()

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
