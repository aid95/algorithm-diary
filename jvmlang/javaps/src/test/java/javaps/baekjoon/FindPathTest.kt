package javaps.baekjoon

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class FindPathTest {

    @DisplayName("testcase #1")
    @Test
    fun solution() {
        // Given
        val param = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 0, 0),
        )
        val n = 3

        // When
        val ans = FindPath().solution(n, param)

        // Then
        assertTrue {
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 1),
            ).contentDeepEquals(ans)
        }
    }

    @DisplayName("testcase #2")
    @Test
    fun solution2() {
        // Given
        val n = 7
        val parm = arrayOf(
            intArrayOf(0, 0, 0, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 1, 0, 0, 0, 0),
        )

        // When
        val ans = FindPath().solution(n, parm)

        // Then
        assertTrue {
            arrayOf(
                intArrayOf(1, 0, 1, 1, 1, 1, 1),
                intArrayOf(0, 0, 1, 0, 0, 0, 1),
                intArrayOf(0, 0, 0, 0, 0, 0, 0),
                intArrayOf(1, 0, 1, 1, 1, 1, 1),
                intArrayOf(1, 0, 1, 1, 1, 1, 1),
                intArrayOf(0, 0, 1, 0, 0, 0, 1),
                intArrayOf(0, 0, 1, 0, 0, 0, 0),
            ).contentDeepEquals(ans)
        }
    }
}
