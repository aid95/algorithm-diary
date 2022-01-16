package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class SNS constructor(private val graph: Array<Vector<Int>>) {

    private val visited = Array(graph.size) { false }
    private val dp = Array(graph.size) { Array(2) { 0 } }

    fun update() = dfs(0)

    fun printAnswer() {
        print(dp[0][1].coerceAtMost(dp[0][0]))
    }

    private fun dfs(root: Int) {
        visited[root] = true
        dp[root][0] = 1
        for (child in graph[root]) {
            if (visited[child]) continue
            dfs(child)
            dp[root][1] += dp[child][0]
            dp[root][0] += dp[child][0].coerceAtMost(dp[child][1])
        }
    }
}

fun sns(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val graph = Array(1_000_001) { Vector<Int>() }
    repeat(br.readLine().trim().toInt().minus(1)) {
        val (u, v) = br.readLine().trim().split(" ").map { it.toInt().minus(1) }
        graph[u].add(v)
        graph[v].add(u)
    }
    val solver = SNS(graph)
    solver.update()
    solver.printAnswer()
}
