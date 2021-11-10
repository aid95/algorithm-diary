package javaps.baekjoon

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

internal class ACMCraftTest {

    @Test
    fun solution() {
        val target = 3
        val times = arrayOf(10, 1, 100, 10)
        val graph = Array(4) { Vector<Int>() }
        graph[0].addAll(arrayOf(1, 2))
        graph[1].addAll(arrayOf(3))
        graph[2].addAll(arrayOf(3))

        val result = ACMCraft().solution(graph, times, target)
       
        assertEquals(120, result)
    }
}
