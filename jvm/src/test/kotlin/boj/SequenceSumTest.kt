package boj

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class SequenceSumTest {

    @Test
    fun sequenceSumTest() {
        // Given
        val n = 3

        // When
        val result = SequenceSum().sequenceSum(n)

        // Then
        Assertions.assertEquals(6, result)
    }

    @Test
    fun getSequenceStringTest() {
        // Given
        val begin = 1
        val end = 10

        // When
        val result = SequenceSum().getSequenceString(begin, end)

        // Then
        Assertions.assertEquals("1 2 3 4 5 6 7 8 9 10", result)
    }

    @Test
    fun solution() {
        // Given
        val n = 1000000000
        val l = 2

        // When
        val result = SequenceSum().solution(n, l)

        // Then
        Assertions.assertEquals("199999998 199999999 200000000 200000001 200000002", result)
    }
}
