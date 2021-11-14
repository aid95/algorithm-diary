package boj

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class DokidokiTest {

    @DisplayName("Testcase #1")
    @Test
    fun normalTestCase() {
        // Given
        val param = arrayOf(1, 2, 3, 4, 5)

        // When
        val result = Dokidoki().solution(param)

        // Then
        Assertions.assertTrue(result)
    }

    @DisplayName("Testcase #2")
    @Test
    fun secondTestCase() {
        // Given
        val param = arrayOf(1, 2, 4, 3, 5)

        // When
        val result = Dokidoki().solution(param)

        // Then
        Assertions.assertTrue(result)
    }

    @DisplayName("Testcase #3")
    @Test
    fun threeTestCase() {
        // Given
        val param = arrayOf(1, 2, 4, 5, 3)

        // When
        val result = Dokidoki().solution(param)

        // Then
        Assertions.assertFalse(result)
    }
}
