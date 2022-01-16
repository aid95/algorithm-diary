package boj

import java.io.BufferedReader
import java.io.InputStreamReader

class LIS constructor(private val nums: Array<Int>) {

    private val dp = Array(nums.size) { 0 }

    fun solution(): Int {
        var answer = 0
        for (i in nums.indices) {
            dp[i] = getMaxSubLIS(i) + 1
            answer = answer.coerceAtLeast(dp[i])
        }
        return answer
    }

    private fun getMaxSubLIS(end: Int): Int {
        var li = 0
        for (j in 0 until end) {
            if (nums[j] < nums[end]) {
                li = li.coerceAtLeast(dp[j])
            }
        }
        return li
    }
}

fun lis(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val nums = br.readLine().trim().split(" ").map(String::toInt).toTypedArray()
    print(LIS(nums).solution())
}
