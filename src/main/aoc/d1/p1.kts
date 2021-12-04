import java.io.File

fun readInput(filename: String)
= File(filename).useLines() { it.toList() }

fun main() {
    var data = readInput("input")
    var run: Int = 0
    var prev: Int = 0
    var incr: Int = 0

    for (item in data) {
        var i = item.toInt()
        if (run == 0) {
            prev = i
            run += 1
        }
        if (i > prev) {
            incr += 1
        }
        prev = i
    }
    println("final number of Incements: $incr")
}

main()