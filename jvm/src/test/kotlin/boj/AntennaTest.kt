package boj

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class AntennaTest {

    @Test
    fun solution3() {
        val points = arrayOf(1, 2, 3, 9)

        val result = Antenna().solution(points)

        Assertions.assertEquals(2, result)
    }

    @Test
    fun solution4() {
        val points = arrayOf(1, 5, 7, 9)

        val result = Antenna().solution(points)

        Assertions.assertEquals(5, result)
    }

    @Test
    fun solution2() {
        val points = arrayOf(1, 2, 8, 9)

        val result = Antenna().solution(points)

        Assertions.assertEquals(2, result)
    }

    @Test
    fun solution() {
        val points = arrayOf(1, 2, 10, 10)

        val result = Antenna().solution(points)

        Assertions.assertEquals(2, result)
    }
}
