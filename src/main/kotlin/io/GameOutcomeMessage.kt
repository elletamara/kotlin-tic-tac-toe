package io

internal enum class GameOutcomeMessage(val string: String) {
    CONGRATS("Congratulations "),
    WINNER(", you're the winner!"),
    TIE("It's a tie!"),
}
