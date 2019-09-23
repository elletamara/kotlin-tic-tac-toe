package io

import java.io.PrintStream

class ConsoleIO(private val output: PrintStream) {

    fun println(text: String) {
        output.println(text)
    }
}
