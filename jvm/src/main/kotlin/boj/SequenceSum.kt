package boj

import java.util.*

class SequenceSum {

    fun init(args: Array<String>) = with(Scanner(System.`in`)) {
        val n = nextInt()
        val l = nextInt()
        println(solution(n, l))
    }

    fun solution(n: Int, l: Int): String {
        for (c in l..100) {
            val w = n.minus(sequenceSum(c))
            if (w.div(c).plus(1) >= 0 && w.mod(c) == 0) {
                return getSequenceString(
                    w.div(c).plus(1), c
                )
            }
        }
        return "-1"
    }

    fun sequenceSum(n: Int) = n.times(n.plus(1)).div(2)

    fun getSequenceString(begin: Int, end: Int) = (begin..begin.plus(end).minus(1)).joinToString(" ") {
        it.toString()
    }
}
