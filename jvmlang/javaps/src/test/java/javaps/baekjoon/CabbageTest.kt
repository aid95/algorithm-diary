package javaps.baekjoon

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CabbageTest {

    @Test
    fun solution() {
        // Given
        val map = arrayOf(
            arrayOf(1, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 1, 1, 0, 0, 0, 1, 1, 1),
            arrayOf(0, 0, 0, 0, 1, 0, 0, 1, 1, 1),
        )

        // When
        val result = Cabbage().solution(map)

        // Then
        assertEquals(5, result)
    }
}
