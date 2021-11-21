package boj

import java.util.*

class OneTwoThreeSum {

    companion object {
        val table = Array(12) {
            0
        }.apply {
            this[1] = 1
            this[2] = 2
            this[3] = 4
            for (i in 4..11) {
                this[i] = this[i - 1] + this[i - 2] + this[i - 3]
            }
        }
    }

    fun init(args: Array<String>) = with(Scanner(System.`in`)) {
        repeat(nextInt()) { println(solution(nextInt())) }
    }

    fun solution(n: Int) = table[n]
}
