package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class AvoidFood {

    private val dx = arrayOf(0, 0, -1, 1)
    private val dy = arrayOf(1, -1, 0, 0)

    private val map = Array(101) { Array(101) { 0 } }
    private val visited = Array(101) { Array(101) { false } }

    fun entryPoint(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m, k) = br.readLine().trim().split(" ").map { it.toInt() }
        repeat(k) {
            val (y, x) = br.readLine().trim().split(" ").map { it.toInt() }
            map[y][x] = 1
        }
        println(bfs(m, n))
    }

    private fun bfs(width: Int, height: Int): Int {
        val queue = LinkedList<Point>()
        var maxSize = Int.MIN_VALUE
        for (y in 1..height) {
            for (x in 1..width) {
                if (canMove(x, y)) {
                    var tmpCount = 1
                    queue.offer(Point(x, y))
                    visited[y][x] = true
                    while (!queue.isEmpty()) {
                        val (_x, _y) = queue.poll()
                        for (i in 0 until 4) {
                            val nx = _x + dx[i]
                            val ny = _y + dy[i]
                            if (checkRange(nx, ny) && canMove(nx, ny)) {
                                queue.offer(Point(nx, ny))
                                visited[ny][nx] = true
                                tmpCount++
                            }
                        }
                    }
                    maxSize = maxSize.coerceAtLeast(tmpCount);
                }
            }
        }
        return maxSize
    }

    private fun canMove(x: Int, y: Int) = map[y][x] == 1 && !visited[y][x]

    private fun checkRange(x: Int, y: Int) = x in 1 until map[0].size && y in 1 until map.size

    data class Point constructor(val x: Int, val y: Int)
}

fun avoidFood(args: Array<String>) {
    AvoidFood().entryPoint(args)
}
