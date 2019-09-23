package io

import java.io.PrintStream

class ConsoleIO(private val output: PrintStream = PrintStream(System.out)) {

    fun println(text: String) {
        output.println(text)
    }
}
