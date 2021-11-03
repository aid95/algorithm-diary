package javaps.baekjoon

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class NameScoreTest {

    @Test
    fun solution() {
        // Given
        val a = "CJM"
        val b = "HER"

        // When
        val result = NameScore().solution(a, b)

        // Then
        assertEquals("99", result)
    }
}
