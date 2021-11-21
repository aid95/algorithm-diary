package boj

import java.util.*
import java.util.stream.IntStream

class StoneGameIII {

    fun init(args: Array<String>) = with(Scanner(System.`in`)) {
        val n = nextInt()
        println(if (solution(n)) "SK" else "CY")
    }

    fun solution(n: Int): Boolean {
        val dp: Array<Boolean> = Array(1_001) { false }
        dp[1] = true
        dp[2] = false
        dp[3] = true
        dp[4] = true
        IntStream.rangeClosed(5, n).forEach { i ->
            dp[i] = !dp[i - 1] || !dp[i - 3] || !dp[i - 4]
        }
        return dp[n]
    }
}
