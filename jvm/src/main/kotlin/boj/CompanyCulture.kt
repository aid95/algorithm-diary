package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class CompanyCulture constructor(private val graph: Array<Vector<Int>>) {

    private val compliment = Array(graph.size) { 0 }

    // bfs
    fun update() {
        val q: Queue<Int> = LinkedList()
        q.offer(0)
        while (!q.isEmpty()) {
            val root = q.poll()
            for (child in graph[root]) {
                compliment[child] += compliment[root]
                q.offer(child)
            }
        }
    }

    fun update2() = dfs(0)
    private fun dfs(root: Int) {
        for (child in graph[root]) {
            compliment[child] += compliment[root]
            dfs(child)
        }
    }

    fun addCompliment(employee: Int, compliment: Int) {
        this.compliment[employee] += compliment
    }

    override fun toString(): String = compliment.joinToString(" ")
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().trim().split(" ").map { it.toInt() }
    val graph = Array(n) { Vector<Int>() }
    br.readLine().trim()
        .split(" ")
        .map(String::toInt)
        .forEachIndexed { i, v ->
            if (v != -1) {
                graph[v - 1].add(i)
            }
        }
    val solver = CompanyCulture(graph)
    repeat(m) {
        val (i, w) = br.readLine().trim().split(" ").map(String::toInt)
        solver.addCompliment(i - 1, w)
    }
    // solver.update()
    solver.update2()
    print(solver)
}
