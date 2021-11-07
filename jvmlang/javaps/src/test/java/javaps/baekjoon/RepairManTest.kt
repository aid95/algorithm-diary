package javaps.baekjoon

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RepairManTest {

    @Test
    fun solution() {
        // Given
        val len = 2
        val holes = arrayOf(1, 2, 100, 101)

        // When
        val result = RepairMan().solution(len, holes)

        // Then
        assertEquals(2, result)
    }

    @DisplayName("Testcase #2")
    @Test
    fun solution2() {
        // Given
        val len = 3
        val holes = arrayOf(1, 2, 3, 4)

        // When
        val result = RepairMan().solution(len, holes)

        // Then
        assertEquals(2, result)
    }

    @DisplayName("Testcase #3")
    @Test
    fun solution3() {
        // Given
        val len = 1
        val holes = arrayOf(1, 2, 3)

        // When
        val result = RepairMan().solution(len, holes)

        // Then
        assertEquals(3, result)
    }
}
