package javaps.baekjoon

import java.util.*

class ClimbingStairs {

    fun init() = with(Scanner(System.`in`)) {
        val n = nextInt()
        val stairs = Array(n) { nextInt() }
        println(solution(n, stairs))
    }

    fun solution(n: Int, stairs: Array<Int>): Int {
        if (stairs.size < 3) {
            return stairs.sum()
        }
        val dp = Array(n) { 0 }
        dp[0] = stairs[0]
        dp[1] = stairs[0] + stairs[1]
        dp[2] = stairs[2] + (stairs[1].coerceAtLeast(stairs[0]))
        for (i in 3 until n) {
            val c1 = dp[i - 2]
            val c2 = stairs[i - 1] + dp[i - 3]
            dp[i] = c1.coerceAtLeast(c2) + stairs[i]
        }
        return dp[n - 1]
    }
}
