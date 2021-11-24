package boj

import java.io.BufferedReader
import java.io.InputStreamReader

class Antenna {

    fun entry(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        br.readLine()
        print(br.readLine().trim().split(" ").map(String::toInt).toTypedArray().let(::solution))
    }

    fun solution(points: Array<Int>): Int = points.sorted().let { it[it.lastIndex.div(2)] }
}
