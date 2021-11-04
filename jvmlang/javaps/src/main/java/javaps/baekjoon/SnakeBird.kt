package javaps.baekjoon

import java.util.*

class SnakeBird {

    fun init() = with(Scanner(System.`in`)) {
        val num = nextInt()
        val base = nextInt()
        val fruits = Array(num) { nextInt() }

        println(solution(base, fruits))
    }

    fun solution(base: Int, fruits: Array<Int>) =
        fruits.sorted().fold(base) { length, height -> length + if (height <= length) 1 else 0 }
}
