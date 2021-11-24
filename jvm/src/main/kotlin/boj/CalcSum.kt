package boj

import java.io.BufferedReader
import java.io.InputStreamReader

class CalcSum {

    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))

        br.readLine()

        val nums = br.readLine().trim().split(" ").map(String::toInt).toTypedArray()

        val ranges = ArrayList<Range>()
        repeat(br.readLine().trim().toInt()) {
            val mn = br.readLine().trim().split(" ").map { it.toInt() }
            ranges.add(Range(mn[0], mn[1]))
        }

        solution(nums, ranges).forEach(System.out::println)
    }

    fun solution(nums: Array<Int>, ranges: List<Range>): List<Int> {
        val table = Array(nums.size) { 0 }
        table[0] = nums[0]
        for (i in 1 until nums.size) {
            table[i] = nums[i].plus(table[i - 1])
        }
        return ranges.map { (x, y) -> table[y - 1].minus(table[x - 1]).plus(nums[x - 1]) }
    }

    data class Range constructor(val begin: Int, val end: Int)
}
