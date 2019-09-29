package io

import java.io.BufferedReader

internal class ConsoleInput(private val input: BufferedReader) {

    private val emptyString: String = ""

    fun getInput(): String {
        val userInput = input.readLine()
        return if (userInput.isEmpty()) emptyString else userInput
    }
}
