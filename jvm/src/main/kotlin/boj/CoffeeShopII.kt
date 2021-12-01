package boj

import java.io.BufferedReader
import java.io.InputStreamReader

class CoffeeShopII constructor(private val numbers: Array<Long>) {

    private val segmentTree: Array<Long> = Array(numbers.size * 4) { 0 }

    init {
        initTree(0, numbers.size - 1)
    }

    private fun initTree(begin: Int, end: Int, root: Int = 1): Long {
        if (begin == end) {
            segmentTree[root] = numbers[begin]
            return numbers[begin]
        }
        val mid = (begin + end) / 2
        segmentTree[root] =
            initTree(begin, mid, root * 2) + initTree(mid + 1, end, root * 2 + 1)
        return segmentTree[root]
    }

    private fun updateTree(begin: Int, end: Int, target: Int, diff: Long, root: Int = 1) {
        if (target in begin..end) {
            segmentTree[root] += diff
            if (begin != end) {
                val mid = (begin + end) / 2
                updateTree(begin, mid, target, diff, root * 2)
                updateTree(mid + 1, end, target, diff, root * 2 + 1)
            }
        }
    }

    fun sum(x: Int, y: Int): Long = rangeSum(0, numbers.size - 1, x, y)

    private fun rangeSum(begin: Int, end: Int, x: Int, y: Int, root: Int = 1): Long {
        if (y < begin || end < x) {
            return 0
        }
        if (x <= begin && end <= y) {
            return segmentTree[root]
        }
        val mid = (begin + end) / 2
        return rangeSum(begin, mid, x, y, root * 2) + rangeSum(mid + 1, end, x, y, root * 2 + 1)
    }

    fun update(pos: Int, n: Long) {
        val diff = getDiff(pos, n)
        numbers[pos] = n
        updateTree(0, numbers.size - 1, pos, diff)
    }

    private fun getDiff(pos: Int, n: Long): Long {
        return n - numbers[pos]
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (_, q) = br.readLine().trim().split(" ").map(String::toInt)

    val nums = br.readLine().trim().split(" ").map(String::toLong).toTypedArray()
    val solution = CoffeeShopII(nums)

    repeat(q) {
        var (x, y, a, b) = br.readLine().trim().split(" ").map(String::toLong)
        if (x > y) {
            x = y.also { y = x }
        }
        println(solution.sum((x - 1).toInt(), (y - 1).toInt()))
        solution.update((a - 1).toInt(), b)
    }
}
