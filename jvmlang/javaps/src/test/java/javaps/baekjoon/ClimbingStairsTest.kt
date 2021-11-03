package javaps.baekjoon

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ClimbingStairsTest {

    @DisplayName("Testcase #1")
    @Test
    fun solution() {
        // Given
        val n = 6
        val stairs = arrayOf(10, 20, 15, 25, 10, 20)

        // When
        val result = ClimbingStairs().solution(n, stairs)

        // Then
        assertEquals(75, result)
    }

    @DisplayName("Testcase #2")
    @Test
    fun solution2() {
        // Given
        val n = 2
        val stairs = arrayOf(10, 20)

        // When
        val result = ClimbingStairs().solution(n, stairs)

        // Then
        assertEquals(30, result)
    }

    @DisplayName("Testcase #3")
    @Test
    fun solution3() {
        // Given
        val n = 1
        val stairs = arrayOf(10)

        // When
        val result = ClimbingStairs().solution(n, stairs)

        // Then
        assertEquals(10, result)
    }
}
