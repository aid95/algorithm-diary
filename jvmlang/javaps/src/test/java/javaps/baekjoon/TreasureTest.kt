package javaps.baekjoon

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class TreasureTest {

    @Test
    fun solution() {
        // Given
        val a = arrayOf(1, 1, 1, 6, 0)
        val b = arrayOf(2, 7, 8, 3, 1)

        // When
        val result = Treasure().solution(a, b)

        // Then
        assertEquals(18, result)
    }
}
