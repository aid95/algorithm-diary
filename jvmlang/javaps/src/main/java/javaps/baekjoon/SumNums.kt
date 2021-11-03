package javaps.baekjoon

import java.util.*

class SumNums {

    fun init() = with(Scanner(System.`in`)) {
        val s = nextLong()
        print(solution(s))
    }

    fun solution(s: Long): Long {
        var acc = 0L
        var num = 0L
        var v = s
        while (v >= 0 && s == (v + acc)) {
            num++
            acc += num
            v -= num
        }
        return num - 1
    }
}
