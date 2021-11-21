package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class FindParent {

    lateinit var parents: Array<Int>

    fun init(args: Array<String>): Unit {
        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().trim().toInt()
        val tree = Array(n + 1) { Vector<Int>() }.apply {
            val linkNode: (Int, Int) -> Unit = { l, r ->
                this[l].add(r)
                this[r].add(r)
            }
            repeat(n - 1) {
                val (l, r) = br.readLine().trim().split(" ").map { it.toInt() }
                linkNode(l, r)
            }
        }
        solution(n, tree)
        parents.drop(2).forEach(System.out::println)
    }

    fun solution(nodeNum: Int, tree: Array<Vector<Int>>) {
        parents = Array(nodeNum + 1) { 0 }
        dfs(tree, 1)
    }

    fun dfs(tree: Array<Vector<Int>>, s: Int) {
        for (n in tree[s]) {
            if (parents[n] == 0) {
                parents[n] = s
                dfs(tree, n)
            }
        }
    }
}
