package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class TreeNQuery {

    lateinit var dp: Array<Int>
    lateinit var visited: Array<Boolean>

    fun entry(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val (n, r, q) = br.readLine().trim().split(" ").map { it.toInt() }
        val tree = Array<Vector<Int>>(n + 1) { Vector() }
        repeat(n - 1) {
            val (a, b) = br.readLine().trim().split(" ").map { it.toInt() }
            tree[a].add(b)
            tree[b].add(a)
        }
        val subRoots = Array(q) { br.readLine().trim().toInt() }

        print(solution(tree, r, subRoots).joinToString("\n"))
    }

    fun solution(tree: Array<Vector<Int>>, rootNode: Int, subRoots: Array<Int>): List<Int> {
        dp = Array(tree.count()) { 1 }
        visited = Array(tree.count()) { false }
        dfs(tree, rootNode)

        return subRoots.asSequence().map { dp[it] }.toList()
    }

    fun dfs(tree: Array<Vector<Int>>, currentNode: Int): Int {
        if (visited[currentNode]) {
            return dp[currentNode]
        }
        visited[currentNode] = true
        for (child in tree[currentNode]) {
            if (visited[child]) continue
            dp[currentNode] += (dfs(tree, child))
        }
        return dp[currentNode]
    }
}
