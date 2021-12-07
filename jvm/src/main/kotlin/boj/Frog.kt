package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Frog constructor(private val stones: Array<Int>) {

    private val q: Queue<Node> = LinkedList()
    private val visited: Array<Boolean> = Array(stones.size) { false }

    fun solution(start: Int, goal: Int): Int {
        q.offer(Node(start, 0))
        while (!q.isEmpty()) {
            val node = q.poll()
            if (node.pos == goal) {
                return node.chance
            }
            visited[node.pos] = true
            go(node)
        }
        return -1
    }

    private fun canMove(x: Int): Boolean = x in stones.indices

    private fun go(node: Node) {
        pushMove(node, stones[node.pos])
        pushMove(node, -stones[node.pos])
    }

    private fun pushMove(node: Node, n: Int) {
        val (p, c) = node
        var t = p + n
        while (canMove(t)) {
            if (!visited[t]) {
                q.offer(Node(t, c + 1))
            }
            t += n
        }
    }

    data class Node constructor(val pos: Int, val chance: Int)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val stones = br.readLine().trim().split(" ").map { it.toInt() }.toTypedArray()
    val solution = Frog(stones)
    val (s, g) = br.readLine().trim().split(" ").map { it.toInt() }
    println(solution.solution(s - 1, g - 1))
}
