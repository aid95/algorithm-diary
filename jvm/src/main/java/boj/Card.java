package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Card {

  public static final HashMap<Long, Integer> cards = new HashMap();

  public static void entryPoint(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < tc; i++) {
      Long card = Long.valueOf(br.readLine().trim());
      cards.put(card, cards.getOrDefault(card, 0) + 1);
    }
    List<Entry<Long, Integer>> entries = new LinkedList<>(cards.entrySet());
    entries.sort(((o1, o2) -> {
      if (o1.getValue().equals(o2.getValue())) {
        return Long.compare(o1.getKey(), o2.getKey());
      }
      return Integer.compare(o2.getValue(), o1.getValue());
    }));
    System.out.println(entries.get(0).getKey());
  }
}
