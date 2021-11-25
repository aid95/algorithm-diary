package boj

import java.io.BufferedReader
import java.io.InputStreamReader

class FindNum {

    lateinit var arr: Array<Int>

    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        br.readLine()
        arr = br.readLine().trim().split(" ").map { it.toInt() }.sorted().toTypedArray()
        br.readLine()
        println(
            br.readLine().trim().split(" ").asSequence()
                .map(String::toInt)
                .map(::solution)
                .map { if (it) 1 else 0 }
                .joinToString("\n")
        )
    }

    fun solution(target: Int): Boolean = arr.binarySearch(target) >= 0
}
