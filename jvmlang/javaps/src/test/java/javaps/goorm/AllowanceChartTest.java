package javaps.goorm;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllowanceChartTest {

  @Test
  void solution() {
    int[] allowances = {7, 2, -6, 5, -9};

    BigInteger result = AllowanceChart.solution(allowances, 1, 5);

    assertEquals(BigInteger.ONE.negate(), result);
  }
}
