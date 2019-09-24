package io

enum class ValidMoveInput(val value: Regex) {
    DIGIT("\\d+".toRegex())
}
