package javaps.baekjoon

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class BottleTest {


    @DisplayName("Testcase #4")
    @Test
    fun solution4() {
        // Given
        val n = 1_000_000L
        val k = 5L

        // When
        val result = Bottle().solution(n, k)

        // Then
        assertEquals(15808, result)
    }

    @DisplayName("Testcase #3")
    @Test
    fun solution3() {
        // Given
        val n = 13L
        val k = 2L

        // When
        val result = Bottle().solution(n, k)

        // Then
        assertEquals(3, result)
    }

    @DisplayName("Testcase #2")
    @Test
    fun solution2() {
        // Given
        val n = 5L
        val k = 1L

        // When
        val result = Bottle().solution(n, k)

        // Then
        assertEquals(3, result)
    }

    @DisplayName("Testcase #1")
    @Test
    fun solution() {
        // Given
        val n = 3L
        val k = 1L

        // When
        val result = Bottle().solution(n, k)

        // Then
        assertEquals(1, result)
    }
}
