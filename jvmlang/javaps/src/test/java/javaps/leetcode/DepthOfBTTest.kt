package javaps.leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class DepthOfBTTest {

    @Test
    fun maxDepth() {
        // Given
        val param = DepthOfBT.TreeNode(1).apply {
            left = DepthOfBT.TreeNode(1).apply {
                left = DepthOfBT.TreeNode(1).apply {
                    left = DepthOfBT.TreeNode(1)
                }
            }
            right = DepthOfBT.TreeNode(1)
        }

        // When
        val ans = DepthOfBT().maxDepth(param)

        // Then
        assertEquals(4, ans)
    }
}
