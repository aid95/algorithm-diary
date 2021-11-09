package javaps.goorm;

import javaps.Solution;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CampusLife implements Solution {

  @Override
  public void run() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      int t = Integer.parseInt(br.readLine());
      Schedule[] schedules = new Schedule[t];
      for (int i = 0; i < t; i++) {
        String[] params = br.readLine().trim().split(" ");
        schedules[i] = new Schedule(parseParam(params[0]), parseParam(params[1]));
      }
      if (solution(schedules)) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private LocalDate parseParam(String date) {
    int[] params = Arrays.stream(date.trim().split("/")).mapToInt(Integer::parseInt).toArray();
    return LocalDate.of(2021, params[0], params[1]);
  }

  static boolean solution(Schedule[] schedules) {
    PriorityQueue<Schedule> pq = new PriorityQueue<>(Comparator.reverseOrder());
    Arrays.stream(schedules).forEach(pq::offer);

    while (!pq.isEmpty()) {
      Schedule currentSchedule = pq.poll();
      if (!pq.isEmpty()
          && currentSchedule.startDate.isBefore(pq.peek().endDate)
          && currentSchedule.endDate.isAfter((pq.peek().endDate))) {
        return false;
      }
    }
    return true;
  }

  static class Schedule implements Comparable<Schedule> {
    LocalDate startDate;
    LocalDate endDate;

    public Schedule(LocalDate startDate, LocalDate endDate) {
      this.startDate = startDate;
      this.endDate = endDate;
    }

    @Override
    public int compareTo(@NotNull Schedule o) {
      if (this.startDate.equals(o.startDate)) {
        return o.endDate.compareTo(this.endDate);
      }
      return this.startDate.compareTo(o.startDate);
    }
  }
}
