package javaps.baekjoon

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigInteger

internal class DistributedComputingTest {

    @DisplayName("Testcase #1")
    @Test
    fun solution() {
        // Given
        val a = 1
        val b = 6

        // When
        val result = DistributedComputing().solution(a.toBigInteger(), b.toBigInteger())

        // Then
        assertEquals(BigInteger.valueOf(1), result)
    }

    @DisplayName("Testcase #2")
    @Test
    fun solution2() {
        // Given
        val a = 7
        val b = 100

        // When
        val result = DistributedComputing().solution(a.toBigInteger(), b.toBigInteger())

        // Then
        assertEquals(BigInteger.valueOf(1), result)
    }

    @DisplayName("Testcase #3")
    @Test
    fun solution3() {
        // Given
        val a = 9
        val b = 635

        // When
        val result = DistributedComputing().solution(a.toBigInteger(), b.toBigInteger())

        // Then
        assertEquals(BigInteger.valueOf(9), result)
    }

    @DisplayName("Testcase #4")
    @Test
    fun solution4() {
        // Given
        val a = 100
        val b = 1_000_000

        // When
        val result = DistributedComputing().solution(a.toBigInteger(), b.toBigInteger())

        // Then
        assertEquals(BigInteger.valueOf(10), result)
    }
}
