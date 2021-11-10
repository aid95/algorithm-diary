package javaps.baekjoon

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PrefixSumTest {

    @Test
    fun solution() {
        // Given
        val nums = arrayOf(5, 4, 3, 2, 1)
        val s = 1
        val e = 3

        // When
        val result = PrefixSum().solution(nums, s, e)

        // Then
        assertEquals(12, result)
    }

    @Test
    fun solution2() {
        // Given
        val nums = arrayOf(5, 4, 3, 2, 1)
        val s = 1
        val e = 5

        // When
        val result = PrefixSum().solution(nums, s, e)

        // Then
        assertEquals(15, result)
    }

    @Test
    fun solution3() {
        // Given
        val nums = arrayOf(5, 4, 3, 2, 1)
        val s = 2
        val e = 4

        // When
        val result = PrefixSum().solution(nums, s, e)

        // Then
        assertEquals(9, result)
    }

    @Test
    fun solution4() {
        // Given
        val nums = arrayOf(5, 4, 3, 2, 1)
        val s = 1
        val e = 1

        // When
        val result = PrefixSum().solution(nums, s, e)

        // Then
        assertEquals(5, result)
    }
}
