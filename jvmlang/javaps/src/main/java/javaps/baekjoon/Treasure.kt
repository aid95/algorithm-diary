package javaps.baekjoon

import java.util.*

class Treasure {

    fun init() = with(Scanner(System.`in`)) {
        val t = nextInt()
        val a = Array(t) { nextInt() }
        val b = Array(t) { nextInt() }
        println(solution(a, b))
    }

    fun solution(a: Array<Int>, b: Array<Int>): Int {
        a.sort()

        val sortedA = Array(a.size) { 0 }
        b.withIndex().sortedByDescending { x -> x.value }
            .mapIndexed { index, indexedValue -> sortedA[indexedValue.index] = a[index] }

        return sortedA.zip(b).sumOf { x -> x.first * x.second }
    }
}
