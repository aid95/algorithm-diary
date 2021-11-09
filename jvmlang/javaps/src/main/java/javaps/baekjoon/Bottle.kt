package javaps.baekjoon

import java.util.*

class Bottle {

    fun init() = with(Scanner(System.`in`)) {
        val n = nextLong()
        val k = nextLong()
       
        print(solution(n, k))
    }

    fun solution(n: Long, k: Long): Long {
        var nn = n
        while (true) {
            var tmp = nn
            var count = 0
            while (tmp > 0) {
                if (tmp % 2L != 0L) {
                    count++
                }
                tmp /= 2
            }
            if (count <= k) {
                break
            }
            nn++
        }
        return nn - n
    }
}
