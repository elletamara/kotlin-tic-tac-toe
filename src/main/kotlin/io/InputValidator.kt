package io

internal class InputValidator(private val consoleIO: ConsoleIO) {
    fun validateMove(): Int {
        val input = consoleIO.getInput()

        println("hi")

        return when (input.matches("\\d+".toRegex())) {
            true -> input.toInt()
            false -> 0
        }
    }
}
