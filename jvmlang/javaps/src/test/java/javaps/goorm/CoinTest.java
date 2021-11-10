package javaps.goorm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CoinTest {

  @Test
  void solution() {
    // Given
    long[] coins =
        Arrays.stream("-6 -9 -7 8 3 -5 -2 -3 -7 0".split(" ")).mapToLong(Long::parseLong).toArray();

    // When
    long result = Coin.solution(coins);

    // Then
    Assertions.assertEquals(11, result);
  }

  @Test
  void solution2() {
    long[] coins =
        Arrays.stream(
                "94 74 99 50 85 17 93 13 79 4 18 58 52 56 84 90 54 2 35 79 97 50 6 47 47 20 95 91 78 35 56 93 2 55 30 84 51 3 58 97 82 4 70 90 65 46 57 28 99 13 24 15 66 93 1 99 63 82 67 28 75 20 15 24 26 33 5 38 11 36 96 45 63 50 11 20 85 0 50 19 69 78 79 95 33 53 78 43 33 39 92 21 59 67 81 81 80 48 32 36"
                    .split(" "))
            .mapToLong(Long::parseLong)
            .toArray();

    long result = Coin.solution(coins);

    Assertions.assertEquals(5242, result);
  }
}
