package io

internal enum class ValidMoveInput(val value: Regex) {
    DIGIT("\\d+".toRegex())
}
