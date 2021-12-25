package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Competition {

    enum Difficulty {
        LOW {
            @Override
            boolean request(int[] questions) {
                return Difficulty.pop(questions, 0, 1);
            }
        },

        MEDIUM {
            @Override
            boolean request(int[] questions) {
                int s1 = 1;
                int s2 = 3;
                if (questions[s1] < questions[s2]) {
                    int tmp = s1;
                    s1 = s2;
                    s2 = tmp;
                }
                if (Difficulty.pop(questions, 2, s1)) {
                    return true;
                }
                return Difficulty.pop(questions, 2, s2);
            }
        },

        HARD {
            @Override
            boolean request(int[] questions) {
                return Difficulty.pop(questions, 4, 3);
            }
        };

        abstract boolean request(int[] questions);

        private static boolean pop(int[] questions, int primary, int second) {
            if (0 < questions[primary]) {
                questions[primary]--;
                return true;
            }
            if (0 < questions[second]) {
                questions[second]--;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] questions = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
            .toArray();

        int answer = 0;
        while (existsQuestions(questions)) {
            answer++;
        }
        System.out.print(answer);
    }

    private static boolean existsQuestions(int[] questions) {
        return Difficulty.LOW.request(questions)
            && Difficulty.MEDIUM.request(questions)
            && Difficulty.HARD.request(questions);
    }
}
