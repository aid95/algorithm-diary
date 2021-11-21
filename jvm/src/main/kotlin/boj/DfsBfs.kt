package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class DfsBfs {

    fun init(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val (n, m, v) = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val graph = Array(n) { Array(n) { 0 } }
        repeat(m) {
            val (s, e) = br.readLine().split(" ").map { it.toInt() - 1 }.toIntArray()
            graph[s][e] = 1
            graph[e][s] = 1
        }
        dfs(graph, Array(n) { false }, v - 1)
        println()
        bfs(graph, v - 1)
        println()
    }

    fun dfs(graph: Array<Array<Int>>, visited: Array<Boolean>, start: Int) {
        visited[start] = true
        print("${start + 1} ")
        for (i in graph.indices) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(graph, visited, i)
            }
        }
    }

    fun bfs(graph: Array<Array<Int>>, start: Int) {
        // queue
        val q: Queue<Int> = LinkedList()
        val visited = Array(graph.size) { false }
        q.offer(start)
        visited[start] = true
        while (!q.isEmpty()) {
            val c = q.poll()
            print("${c + 1} ")
            graph[c].mapIndexed { idx, x ->
                Pair(idx, x)
            }.filter { p -> p.second == 1 && !visited[p.first] }.map { it.first }.forEach { x ->
                q.offer(x)
                visited[x] = true
            }
        }
    }
}
