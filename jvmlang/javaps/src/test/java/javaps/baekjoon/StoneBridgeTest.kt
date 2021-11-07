package javaps.baekjoon

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class StoneBridgeTest {

    @Test
    @DisplayName("Testcase #1")
    fun solution() {
        // Given
        val a = 2
        val b = 3
        val d = 1
        val j = 20

        // When
        val result = StoneBridge().solution(a, b, d, j)

        // Then
        assertEquals(4, result)
    }
}
