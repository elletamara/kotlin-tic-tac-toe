package io

import java.io.BufferedReader
import java.io.PrintStream

class ConsoleIO(private val input: BufferedReader, private val output: PrintStream = PrintStream(System.out)) {
    private val emptyString: String = ""

    fun println(text: String) {
        output.println(text)
    }

    fun getInput(): String {
        val userInput = input.readLine()
        return when(userInput.isEmpty()) {
            true -> emptyString
            false -> userInput
        }
    }
}
