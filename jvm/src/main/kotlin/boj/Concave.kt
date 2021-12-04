package boj

import java.io.BufferedReader
import java.io.InputStreamReader

enum class TYPE constructor(val id: Int) {
    NONE(0), BLACK(1), WHITE(2);

    companion object {
        fun from(id: Int) = TYPE.values().first {
            it.id == id
        }
    }

    override fun toString(): String {
        return "$id"
    }
}

class Concave constructor(private val map: Array<Array<TYPE>>) {

    fun solution() {
        for (i in 0 until 19) {
            for (j in 0 until 19) {
                if (map[i + 3][j + 3] != TYPE.NONE) {
                    val (b, p) = check(j + 3, i + 3)
                    if (b) {
                        println(map[i + 3][j + 3])
                        println(p)
                        return
                    }
                }
            }
        }
        print("0")
    }

    private fun check(x: Int, y: Int): Pair<Boolean, Point> {
        val t = map[y][x]
        var flag: Boolean

        // \
        flag = true
        for (i in 1..2) {
            if (map[y - i][x - i] != t || map[y + i][x + i] != t) {
                flag = false
                break
            }
        }
        if (flag) {
            if (map[y - 3][x - 3] != t && map[y + 3][x + 3] != t) {
                return Pair(true, Point(x - 2, y - 2))
            }
        }

        // -
        flag = true
        for (i in 1..2) {
            if (map[y][x - i] != t || map[y][x + i] != t) {
                flag = false
                break
            }
        }
        if (flag) {
            if (map[y][x - 3] != t && map[y][x + 3] != t) {
                return Pair(true, Point(x - 2, y))
            }
        }

        // |
        flag = true
        for (i in 1..2) {
            if (map[y - i][x] != t || map[y + i][x] != t) {
                flag = false
                break
            }
        }
        if (flag) {
            if (map[y - 3][x] != t && map[y + 3][x] != t) {
                return Pair(true, Point(x, y - 2))
            }
        }

        // /
        flag = true
        for (i in 1..2) {
            if (map[y - i][x + i] != t || map[y + i][x - i] != t) {
                flag = false
                break
            }
        }
        if (flag) {
            if (map[y - 3][x + 3] != t && map[y + 3][x - 3] != t) {
                return Pair(true, Point(x - 2, y + 2))
            }
        }

        return Pair(false, Point(0, 0))
    }

    data class Point(val x: Int, val y: Int) {
        override fun toString(): String {
            return "${y - 2} ${x - 2}"
        }
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val map = Array(19 + 6) { Array(19 + 6) { TYPE.NONE } }

    repeat(19) { y ->
        br.readLine().trim().split(" ").asSequence()
            .forEachIndexed { x, v -> map[y + 3][x + 3] = TYPE.from(v.toInt()) }
    }

    Concave(map).solution()
}
