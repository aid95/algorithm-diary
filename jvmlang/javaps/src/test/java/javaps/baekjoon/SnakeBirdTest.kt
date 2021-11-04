package javaps.baekjoon

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class SnakeBirdTest {

    @Test
    @DisplayName("Testcase #1")
    fun solution() {
        // Given
        val base = 10
        val fruits = arrayOf(10, 11, 13)

        // When
        val result = SnakeBird().solution(base, fruits)

        // Then
        assertEquals(12, result)
    }

    @Test
    @DisplayName("Testcase #2")
    fun solution2() {
        // Given
        val base = 1
        val fruits = arrayOf(9, 5, 8, 1, 3, 2, 7, 6, 4)

        // When
        val result = SnakeBird().solution(base, fruits)

        // Then
        assertEquals(10, result)
    }
}
