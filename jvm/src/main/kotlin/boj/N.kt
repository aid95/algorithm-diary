package boj

import java.io.BufferedReader
import java.io.InputStreamReader

class N

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    println(
        Array(br.readLine().trim().toInt()) {
            br.readLine().trim().split(" ").map { it.toInt() }.sortedDescending().asSequence()
                .drop(2).firstOrNull()
        }.joinToString("\n")
    )
}
