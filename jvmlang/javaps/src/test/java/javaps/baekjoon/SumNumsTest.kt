package javaps.baekjoon

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class SumNumsTest {

    @DisplayName("Testcase #1")
    @Test
    fun solution() {
        // Given
        val s = 200L

        // When
        val result = SumNums().solution(s)

        // Then
        assertEquals(19, result)
    }
}
