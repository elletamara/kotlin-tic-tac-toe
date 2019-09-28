package io

internal enum class ErrorMessage(val string: String) {
    INVALID_MOVE("That's an invalid move. Please try again."),
    INVALID_PLAYER_TYPE("That's an invalid player type. Please try again.")
}
