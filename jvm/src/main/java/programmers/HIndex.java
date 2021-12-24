package programmers;

import java.util.Arrays;

public class HIndex {

    private int maxLength = 0;

    public int solution(int[] citations) {
        this.maxLength = citations.length;
        int[] sorted = Arrays.stream(citations).sorted().toArray();
        for (int i = 0; i < maxLength; i++) {
            if (sorted[i] >= getRemainderLength(i)) {
                return getRemainderLength(i);
            }
        }
        return 0;
    }

    private int getRemainderLength(int i) {
        return maxLength - i;
    }
}
