package io

internal enum class Prompt(val string: String) {
    CHOOSE_MOVE("Select an available move:\n"),
    PLAYER_TURN(", it's your turn!"),
    WAIT(" is thinking. Please wait...")
}
