package javaps.programmers

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class RankingTest {

    @Test
    @DisplayName("testcase #1")
    fun solution() {
        // Given
        val n = 5
        val results = arrayOf(
            intArrayOf(4, 3),
            intArrayOf(4, 2),
            intArrayOf(3, 2),
            intArrayOf(1, 2),
            intArrayOf(2, 5),
        )

        // When
        val ans = Ranking().solution(n, results)

        // Then
        assertEquals(2, ans)
    }
}
