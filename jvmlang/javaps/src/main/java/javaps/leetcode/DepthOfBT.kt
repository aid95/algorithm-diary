package javaps.leetcode

import java.util.*

class DepthOfBT {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0

        var answer = 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        while (!queue.isEmpty()) {
            answer++
            for (i in 0 until queue.size) {
                val node = queue.poll()
                node.left?.let {
                    queue.offer(it)
                }
                node.right?.let {
                    queue.offer(it)
                }
            }
        }
        return answer
    }
}
