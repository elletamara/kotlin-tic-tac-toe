package io

import java.io.PrintStream

internal class ConsoleOutput(private val output: PrintStream = PrintStream(System.out)) {

    fun println(text: String) {
        output.println(text)
    }
}
