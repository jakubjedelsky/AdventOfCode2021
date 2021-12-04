import java.io.File

fun readInput(filename: String): List<Int> {
    val l = File(filename).useLines() { it.toList() }
    return l.map { it.toInt() }
}

fun main() {
    val data = readInput("input")
    val window = data.windowed(size = 3, step = 1)
    val sums = window.map { it.sum() }
    var prev = 0
    var incr = 0
    sums.forEach {
        // let's hope it won't start with 0
        if (prev != 0 && it > prev) {
            incr += 1
        }
        prev = it
    }
    println("$incr")
}

main()