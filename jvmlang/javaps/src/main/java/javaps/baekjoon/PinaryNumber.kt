package javaps.baekjoon

import java.math.BigInteger
import java.util.*

class PinaryNumber {

    fun init() = with(Scanner(System.`in`)) {
        val n = nextInt()
        println(solution(n))
    }

    fun solution(n: Int): BigInteger {
        val dp = Array(91) { BigInteger.ZERO }
        dp[1] = BigInteger.ONE
        dp[2] = BigInteger.ONE
        for (i in 3..n) {
            dp[i] = (dp[i - 1] + dp[i - 2])
        }
        return dp[n]
    }
}
