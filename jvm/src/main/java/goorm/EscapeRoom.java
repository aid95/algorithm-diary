package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EscapeRoom {

  public static void init(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    br.readLine(); // skip
    final int[] seq =
        Arrays.stream(br.readLine().trim().split(" "))
            .mapToInt(Integer::parseInt)
            .sorted()
            .toArray();
    br.readLine(); // skip
    String result =
        Arrays.stream(br.readLine().trim().split(" "))
            .mapToInt(Integer::parseInt)
            .map(x -> solution(seq, x) ? 1 : 0)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining("\n"));
    System.out.println(result);
  }

  public static boolean solution(int[] seq, int targetNumber) {
    return 0 <= Arrays.binarySearch(seq, targetNumber);
  }
}
