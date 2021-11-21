package boj

import org.junit.jupiter.api.Test

internal class DfsBfsTest {

    @Test
    fun dfs() {
        val graph = arrayOf(
            arrayOf(0, 1, 1, 1),
            arrayOf(1, 0, 0, 1),
            arrayOf(1, 0, 0, 1),
            arrayOf(1, 1, 1, 0),
        )

        DfsBfs().dfs(graph, Array(graph.size) {
            false
        }, 0)
    }

    @Test
    fun bfs() {
        val graph = arrayOf(
            arrayOf(0, 1, 1, 1),
            arrayOf(1, 0, 0, 1),
            arrayOf(1, 0, 0, 1),
            arrayOf(1, 1, 1, 0),
        )

        DfsBfs().bfs(graph, 0)
    }
}
