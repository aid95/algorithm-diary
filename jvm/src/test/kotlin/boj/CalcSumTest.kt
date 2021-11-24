package boj

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CalcSumTest {

    @Test
    fun solution() {
        // Given
        val nums = arrayOf(10, 20, 30, 40, 50)
        val ranges = listOf<CalcSum.Range>(
            CalcSum.Range(1, 3),
            CalcSum.Range(2, 4),
            CalcSum.Range(3, 5),
            CalcSum.Range(1, 5),
            CalcSum.Range(4, 4),
        )

        // When
        val result = CalcSum().solution(nums, ranges)

        // Then
        Assertions.assertTrue(listOf(60, 90, 120, 150, 40) == result)
    }
}
