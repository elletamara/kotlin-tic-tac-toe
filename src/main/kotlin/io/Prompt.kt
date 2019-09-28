package io

internal enum class Prompt(val string: String) {
    CHOOSE_PLAYER_TYPE("Please select the player type for player "),
    PLAYER_TYPES("Human, Easy, or Unbeatable:"),
    CHOOSE_MOVE("Select an available move:\n"),
    PLAYER_TURN(", it's your turn!"),
    WAIT(" is thinking. Please wait...")
}
