package javaps.baekjoon

import java.util.*

class ZeroOneTile {

    fun init() = with(Scanner(System.`in`)) {
        val n = nextInt()
        println(solution(n))
    }

    fun solution(n: Int): Int {
        val dp = Array(1_000_001) { 0 }
        dp[1] = 1
        dp[2] = 2
        for (i in 3..n) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746
        }
        return dp[n]
    }
}
