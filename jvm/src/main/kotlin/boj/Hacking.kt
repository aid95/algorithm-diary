package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Hacking constructor(private val graph: Array<Vector<Int>>) {

    private val dp = Array(graph.size) { 1 }
    private var max = Int.MIN_VALUE

    fun solution() {
        val n = graph.size - 1
        for (i in 1..n) {
            dfs(i, Array(graph.size) { false })
        }
    }

    fun show() {
        val sb = StringBuilder()
        for (i in 1..graph.size + 1) {
            if (dp[i] == max) {
                sb.append(dp[i]).append(" ")
            }
        }
        print(sb)
    }

    private fun dfs(root: Int, visited: Array<Boolean>) {
        dp[root]++
        max = max.coerceAtLeast(dp[root])
        visited[root] = true
        for (next in graph[root]) {
            if (!visited[next]) {
                dfs(next, visited)
            }
        }
    }
}

fun hacking(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().trim().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { Vector<Int>() }
    repeat(m) {
        val (a, b) = br.readLine().trim().split(" ").map { it.toInt() }
        graph[b].add(a)
    }
    val solver = Hacking(graph)
    solver.solution()
    solver.show()
}
