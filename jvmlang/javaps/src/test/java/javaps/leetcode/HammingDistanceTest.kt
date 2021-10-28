package javaps.leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class HammingDistanceTest {

    @Test
    fun hammingDistance() {
        // Given
        var (x, y) = listOf(1, 4)

        // When
        var ans = HammingDistance().hammingDistance(x, y)

        // Then
        assertEquals(2, ans)
    }
}
