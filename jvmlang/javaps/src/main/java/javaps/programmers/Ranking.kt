package javaps.programmers

class Ranking {

    // Problem
    //   https://programmers.co.kr/learn/courses/30/lessons/49191?language=kotlin
    // Reference
    //   https://www.youtube.com/watch?v=QBv6lkLZ7Rw
    fun solution(n: Int, results: Array<IntArray>): Int {
        val winTable = Array(n + 1) { BooleanArray(n + 1) }

        for ((w, l) in results) {
            winTable[w][l] = true
        }

        for (i in 1..n) {
            for (j in 1..n) {
                for (k in 1..n) {
                    if (winTable[j][i] && winTable[i][k]) {
                        winTable[j][k] = true
                    }
                }
            }
        }

        var answer = 0
        for (i in 1..n) {
            var matchCount = 0
            for (j in 1..n) {
                if (winTable[i][j] || winTable[j][i]) {
                    matchCount += 1
                }
            }
            if (matchCount == (n - 1)) answer += 1
        }
        return answer
    }
}
