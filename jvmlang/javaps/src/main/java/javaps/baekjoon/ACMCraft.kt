package javaps.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class ACMCraft {

    lateinit var inbound: Array<Int>

    fun init() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val sb = StringBuilder()

        repeat(br.readLine().trim().toInt()) {
            val (n, k) = br.readLine().trim().split(" ").map { it.toInt() }
            val times = br.readLine().trim().split(" ").map { it.toInt() }.toTypedArray()
            val graph = Array(n) { Vector<Int>() }
            inbound = Array(n) { 0 }
            repeat(k) {
                val (prev, next) = br.readLine().trim().split(" ").map { it.toInt() - 1 }
                graph[prev].add(next)
                inbound[next]++
            }
            val target = br.readLine().trim().toInt() - 1
            sb.append(solution(graph, times, target)).append('\n')
        }

        bw.write(sb.toString())
        bw.flush()
        bw.close()
        br.close()
    }

    fun solution(graph: Array<Vector<Int>>, times: Array<Int>, target: Int): Int {
        val maxTimes = times.copyOf()
        val queue: Queue<Int> = LinkedList()
        inbound.mapIndexed { index, i -> if (i == 0) queue.offer(index) }
        while (inbound[target] > 0) { // *
            val currentNode = queue.poll()
            for (node in graph[currentNode]) {
                maxTimes[node] = maxTimes[node].coerceAtLeast(maxTimes[currentNode] + times[node])
                if (--inbound[node] == 0) { // *
                    queue.offer(node)
                }
            }
        }
        return maxTimes[target]
    }
}
