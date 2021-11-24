package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class JarName {

    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)

    lateinit var map: Array<Array<Int>>
    lateinit var visited: Array<Array<Boolean>>
    var size = 0

    fun init(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))

        size = br.readLine().trim().toInt()
        map = Array(size) { Array(size) { 0 } }
        visited = Array(size) { Array(size) { false } }

        repeat(size) { y ->
            br.readLine().trim().toCharArray().mapIndexed { x, v -> map[y][x] = v.digitToInt() }
        }

        val result = solution()
        println(result.first)
        result.second.map(System.out::println)
    }

    fun solution(): Pair<Int, ArrayList<Int>> {
        val queue: Queue<Node> = LinkedList()
        var totalNum = 0
        val jarNums = ArrayList<Int>()
        for (y in 0 until size) {
            for (x in 0 until size) {
                if (map[y][x] == 1 && !visited[y][x]) {
                    totalNum++
                    var count = 1
                    visited[y][x] = true
                    queue.offer(Node(x, y))
                    while (!queue.isEmpty()) {
                        val (_x, _y) = queue.poll()
                        for (i in 0..3) {
                            val nx = _x.plus(dx[i])
                            val ny = _y.plus(dy[i])
                            if (canMove(nx, ny)) {
                                queue.offer(Node(nx, ny))
                                visited[ny][nx] = true
                                count++
                            }
                        }
                    }
                    jarNums.add(count)
                }
            }
        }
        jarNums.sort()
        return Pair(totalNum, jarNums)
    }

    fun canMove(x: Int, y: Int) = (x in 0 until size && y in 0 until size && map[y][x] == 1 && !visited[y][x])

    data class Node constructor(val x: Int, val y: Int)
}
