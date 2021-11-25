package boj

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class TournamentTest {

    @Test
    fun solution() {
        val players = 1000
        val jimin = 20
        val hansoo = 31

        val result = Tournament().solution(jimin, hansoo)

        Assertions.assertEquals(4, result)
    }
}
