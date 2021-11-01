package javaps.baekjoon

import java.util.*

class FindPath {

    fun init() = with(Scanner(System.`in`)) {
        val n = nextInt()
        val map = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                map[i][j] = nextInt()
            }
        }

        solution(n, map).forEach { line ->
            println(line.joinToString(separator = " "))
        }
    }

    fun solution(n: Int, map: Array<IntArray>): Array<IntArray> {
        val ret = map.clone()
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    if (ret[j][i] == 1 && ret[i][k] == 1) {
                        ret[j][k] = 1
                    }
                }
            }
        }
        return ret
    }
}
