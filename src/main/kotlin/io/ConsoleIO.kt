package io

import java.io.BufferedReader
import java.io.PrintStream

class ConsoleIO(private val input: BufferedReader, private val output: PrintStream = PrintStream(System.out)) {

    fun println(text: String) {
        output.println(text)
    }

    fun getInput(): String {
        return input.use { it.readText() }
    }
}
