package javaps.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

class RepairMan {

    fun init() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val read: () -> List<Int> = { br.readLine().trim().split(" ").map { x -> x.toInt() } }
        val (n, l) = read()
        val holes = read().toTypedArray()
        print(solution(l, holes))
    }

    fun solution(len: Int, holes: Array<Int>): Int {
        val h = holes.map { it - 0.5 }.sorted()

        var p = 0
        var cnt = 0
        var base = h[0]
        while (p < holes.size) {
            if ((h[p] - base) >= len) {
                base = h[p]
                cnt++
            } else {
                p++
            }
        }
        return cnt + 1
    }
}
