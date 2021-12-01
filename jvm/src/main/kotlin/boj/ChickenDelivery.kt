package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

class ChickenDelivery constructor(private val map: Array<Array<Int>>) {

    private val stores: List<Point> by lazy { getObjects(2) }
    private val houses: List<Point> by lazy { getObjects(1) }

    fun solution(m: Int): Int {
        val openStores = BooleanArray(stores.size)
        var result = Int.MAX_VALUE
        combination(0, m, 0, openStores) {
            val t = houses.asSequence().map { house ->
                stores.asSequence().filterIndexed { index, _ -> openStores[index] }
                    .map { it.distance(house) }.minOf { it }
            }.sum()
            result = result.coerceAtMost(t)
        }
        return result
    }

    private fun combination(s: Int, m: Int, c: Int, visited: BooleanArray, action: () -> Unit) {
        if (c == m) {
            action()
            return
        }
        for (i in s until stores.size) {
            if (visited[i]) continue

            visited[i] = true
            combination(i, m, c + 1, visited, action)
            visited[i] = false
        }
    }

    data class Point constructor(val x: Int, val y: Int) {

        fun distance(other: Point) = abs(x - other.x) + abs(y - other.y)
    }

    private fun getObjects(type: Int): List<Point> {
        val result = LinkedList<Point>()
        for (i in map.indices) {
            for (j in map[0].indices) {
                if (map[i][j] == type) {
                    result.add(Point(j, i))
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().trim().split(" ").map { it.toInt() }
    val map = Array(n) { br.readLine().trim().split(" ").map { it.toInt() }.toTypedArray() }

    val solution = ChickenDelivery(map)
    print(solution.solution(m))
}
