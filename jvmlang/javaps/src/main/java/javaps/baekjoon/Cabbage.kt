package javaps.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Cabbage {

    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(1, -1, 0, 0)

    fun init() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val read: () -> List<Int> = { br.readLine().trim().split(" ").map { x -> x.toInt() } }

        val t = read()[0]
        repeat(t) {
            val (m, n, k) = read()
            val map = Array(n) { Array(m) { 0 } }
            repeat(k) {
                val (x, y) = read()
                map[y][x] = 1
            }
            println(solution(map))
        }
    }

    fun solution(map: Array<Array<Int>>): Int {
        val w = map[0].size
        val h = map.size
        val visited = Array(h) { Array(w) { false } }
        var count = 0

        val q: Queue<Pair<Int, Int>> = LinkedList()
        repeat(h) { a ->
            repeat(w) { b ->
                if (!visited[a][b] && map[a][b] == 1) {
                    visited[a][b] = true
                    q.offer(Pair(b, a))
                    while (!q.isEmpty()) {
                        val (x, y) = q.poll()
                        repeat(4) { idx ->
                            val nx = x + dx[idx]
                            val ny = y + dy[idx]
                            if ((nx in 0 until w) && (ny in 0 until h) && !visited[ny][nx] && map[ny][nx] == 1) {
                                q.offer(Pair(nx, ny))
                                visited[ny][nx] = true
                            }
                        }
                    }
                    count++
                }
            }
        }

        return count
    }
}
