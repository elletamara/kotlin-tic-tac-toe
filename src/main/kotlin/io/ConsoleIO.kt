package io

import java.io.BufferedReader
import java.io.PrintStream
import java.io.IOException

class ConsoleIO(private val input: BufferedReader, private val output: PrintStream = PrintStream(System.out)) {

    fun println(text: String) {
        output.println(text)
    }

    fun getInput(): String {
        var userInput = ""

        try {
            userInput = input.readLine()
        } catch (error: IOException) {
            println("User input error")
        }

        return userInput
    }
}
