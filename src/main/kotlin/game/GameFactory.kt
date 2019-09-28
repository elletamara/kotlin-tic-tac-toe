package game

import board.BoardFactory
import io.Displayer
import io.InputValidator
import player.PlayerFactory

internal class GameFactory(val inputValidator: InputValidator, val displayer: Displayer) {

    fun createGameWith3By3Grid():Game {
        displayer.welcomeMessage()

        val playerFactory = PlayerFactory(inputValidator, displayer)
        val player1selection = inputValidator.validatePlayerSelection(1)
        val player1 = playerFactory.createPlayer("x", player1selection)
        val player2selection = inputValidator.validatePlayerSelection(2)
        val player2 = playerFactory.createPlayer("o", player2selection)
        val board = BoardFactory.createBoardWith3By3Grid()

        return Game(board, player1, player2)
    }
}
