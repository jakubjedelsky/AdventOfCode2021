package d3

import java.io.File
import java.lang.Integer.parseInt

fun readInput(filename: String) =
    File(filename).readLines()

fun invertBits(b: String): String {
    var result = ""
    b.forEach {
        result += when(it) {
            '0' -> '1'
            '1' -> '0'
            else -> throw Exception("0 or 1 expected, $it found")
        }
    }
    return result
}

fun main() {
    val data = readInput("input")

    // stupid, i know, but I'm not able to initialize an empty list :facepalm:
    val gamma_sum = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0)
    val gamma = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0)
    data.forEach {
        it.forEachIndexed {index, item ->
            gamma_sum[index] += item.digitToInt()
        }
    }
    gamma_sum.forEachIndexed() {index, it ->
        gamma[index] = if (it > data.size/2 ) 1 else 0
    }
    println("gamma: ${gamma.joinToString("")}, epsilon: ${invertBits(gamma.joinToString(""))}")
    val g: Int = parseInt(gamma.joinToString(""),2)
    val e: Int = parseInt(invertBits(gamma.joinToString("")), 2)
    println("$g * $e = ${g*e}")
}

main()
