package boj

import java.io.BufferedReader
import java.io.InputStreamReader

class Tournament {

    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, jimin, hansoo) = br.readLine().trim().split(" ").map { it.toInt() }
        println(solution(jimin, hansoo))
    }

    fun solution(jimin: Int, hansoo: Int): Int {
        var l = jimin
        var r = hansoo
        var count = 0
        while (l != r) {
            l = (if (l.mod(2) != 0) l + 1 else l).div(2)
            r = (if (r.mod(2) != 0) r + 1 else r).div(2)
            count++
        }
        return count
    }
}
