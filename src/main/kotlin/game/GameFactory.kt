package game

import board.BoardFactory
import io.Displayer
import io.InputValidator
import player.Player
import player.PlayerFactory
import player.PlayerMark

internal class GameFactory(val inputValidator: InputValidator, val displayer: Displayer) {

    fun createGameWith3By3Grid(): Game {
        displayer.welcomeMessage()
        val player1 = createGamePlayer(1, PlayerMark.ONE.string)
        val player2 = createGamePlayer(2, PlayerMark.TWO.string)
        val board = BoardFactory.createBoardWith3By3Grid()

        return Game(board, player1, player2)
    }

    private fun createGamePlayer(playerNumber: Int, mark: String): Player {
        val playerFactory = PlayerFactory(inputValidator, displayer)
        val playerSelection = inputValidator.validatePlayerSelection(playerNumber, mark)

        return playerFactory.createPlayer(mark, playerSelection)
    }
}
