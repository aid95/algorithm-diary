package boj

data class Matryoshka constructor(private val size: Int) {
    fun lessThen(other: Matryoshka): Boolean {
        return this.size < other.size
    }
}

class MatryoshkaLine constructor(private val nums: Array<Matryoshka>) {
    fun solve(): Int {
        val dp = Array(nums.size) { 0 }
        var result = 0
        for (i in nums.indices) {
            val l = getLongest(i, dp)
            dp[i] = l + 1;
            result = result.coerceAtLeast(dp[i])
        }
        return result
    }

    private fun getLongest(i: Int, dp: Array<Int>): Int {
        var l = 0
        for (j in 0 until i) {
            if (nums[j].lessThen(nums[i])) {
                l = l.coerceAtLeast(dp[j])
            }
        }
        return l
    }
}

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    readLine()
    val nums = readLine().trim().split(" ").map { Matryoshka(it.toInt()) }.toTypedArray()
    print(MatryoshkaLine(nums).solve())
}
