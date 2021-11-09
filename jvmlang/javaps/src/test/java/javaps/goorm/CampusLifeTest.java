package javaps.goorm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CampusLifeTest {

  @Test
  void solution2() {
    CampusLife.Schedule[] dates =
        new CampusLife.Schedule[] {
          new CampusLife.Schedule(LocalDate.of(2021, 6, 14), LocalDate.of(2021, 10, 20)),
          new CampusLife.Schedule(LocalDate.of(2021, 6, 17), LocalDate.of(2021, 8, 25)),
          new CampusLife.Schedule(LocalDate.of(2021, 4, 3), LocalDate.of(2021, 7, 22)),
          new CampusLife.Schedule(LocalDate.of(2021, 5, 4), LocalDate.of(2021, 9, 3)),
          new CampusLife.Schedule(LocalDate.of(2021, 9, 7), LocalDate.of(2021, 12, 27)),
          new CampusLife.Schedule(LocalDate.of(2021, 1, 25), LocalDate.of(2021, 12, 17)),
          new CampusLife.Schedule(LocalDate.of(2021, 2, 27), LocalDate.of(2021, 3, 5)),
          new CampusLife.Schedule(LocalDate.of(2021, 5, 11), LocalDate.of(2021, 10, 20)),
          new CampusLife.Schedule(LocalDate.of(2021, 2, 12), LocalDate.of(2021, 7, 14)),
          new CampusLife.Schedule(LocalDate.of(2021, 2, 27), LocalDate.of(2021, 8, 13)),
        };
    boolean result = CampusLife.solution(dates);
    Assertions.assertEquals(false, result);
  }

  @Test
  void solution() {
    CampusLife.Schedule[] dates =
        new CampusLife.Schedule[] {
          new CampusLife.Schedule(LocalDate.of(2021, 5, 1), LocalDate.of(2021, 7, 1)),
          new CampusLife.Schedule(LocalDate.of(2021, 5, 1), LocalDate.of(2021, 7, 1)),
          new CampusLife.Schedule(LocalDate.of(2021, 4, 3), LocalDate.of(2021, 8, 4)),
          new CampusLife.Schedule(LocalDate.of(2021, 3, 4), LocalDate.of(2021, 9, 3)),
          new CampusLife.Schedule(LocalDate.of(2021, 3, 4), LocalDate.of(2021, 10, 3)),
        };
    boolean result = CampusLife.solution(dates);
    Assertions.assertEquals(true, result);
  }
}
