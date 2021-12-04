package d2

import java.io.File

fun readInput(filename: String): List<List<String>> {
    val l: List<String> = File(filename).readLines()
    return l.map { it.split(" ") }
}

fun main() {
    var horizontal= 0
    var depth = 0
    val data = readInput("input")
    data.forEach {
        var command = it[0]
        var value = it[1].toInt()
        when (command) {
            "forward" -> horizontal += value
            "down" -> depth += value
            "up" -> depth -= value
        }
    }
    println("$horizontal * $depth = ${horizontal * depth}")
}

main()