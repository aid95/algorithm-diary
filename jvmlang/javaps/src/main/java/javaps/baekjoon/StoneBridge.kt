package javaps.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class StoneBridge {

    fun init() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val read: () -> List<Int> = { br.readLine().trim().split(" ").map { x -> x.toInt() } }
        val (a, b, d, j) = read()
        print(solution(a, b, d, j))
    }

    fun solution(a: Int, b: Int, d: Int, j: Int): Int {
        val maxLength = 100_001

        val q: Queue<Node> = LinkedList()
        val visited: Array<Boolean> = Array(maxLength) { false }

        val isPossible: (Int, Int) -> Unit = { dep, s ->
            if (s in 0 until maxLength) {
                if (!visited[s]) {
                    q.offer(Node(dep + 1, s))
                    visited[s] = true
                }
            }
        }

        q.offer(Node(0, d))
        while (!q.isEmpty()) {
            val (depth, pos) = q.poll()
            if (pos == j) {
                return depth
            }
            isPossible(depth, pos - 1)
            isPossible(depth, pos + 1)
            isPossible(depth, pos + a)
            isPossible(depth, pos - a)
            isPossible(depth, pos * a)
            isPossible(depth, pos + b)
            isPossible(depth, pos - b)
            isPossible(depth, pos * b)
        }
        return 0
    }

    data class Node(val depth: Int, val p: Int)
}
