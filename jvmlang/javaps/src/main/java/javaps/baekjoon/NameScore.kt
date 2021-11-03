package javaps.baekjoon

import java.util.*

class NameScore {

    private val table = arrayOf(3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1)

    fun init() = with(Scanner(System.`in`)) {
        println(solution(next(), next()))
    }

    fun solution(a: String, b: String): String {
        val m = a.zip(b) { x, y -> arrayOf(x, y) }.toTypedArray().flatten().map { c(it) }.toMutableList()
        for (k in 1..(m.size - 2)) {
            for (i in 0 until m.size - k) {
                m[i] = (m[i] + m[i + 1]) % 10
            }
        }
        return "${m[0]}${m[1]}"
    }

    private fun c(ch: Char) = table[ch - 'A']
}
