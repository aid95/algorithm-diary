package javaps.goorm;

import javaps.Solution;

import java.util.Arrays;
import java.util.stream.Collector;

public class Kkokko implements Solution {

  private static final Character[] w = {'a', 'e', 'i', 'o', 'u'};

  @Override
  public void run() {}

  public static String solution(String message) {
    String result =
        message
            .chars()
            .mapToObj(x -> (char) x)
            .filter(Kkokko::validation)
            .collect(
                Collector.of(
                    StringBuilder::new,
                    StringBuilder::append,
                    StringBuilder::append,
                    StringBuilder::toString));

    if (result.length() == 0) {
      return "???";
    }
    return result;
  }

  public static boolean validation(char ch) {
    return Arrays.asList(w).contains(Character.toLowerCase(ch));
  }
}
