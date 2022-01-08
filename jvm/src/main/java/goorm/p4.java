package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        new MergeSort(arr).print();
    }

    private static class MergeSort {

        private final int[] values;

        public MergeSort(int[] values) {
            this.values = values;
            sorted(0, values.length - 1);
        }

        private void sorted(int begin, int end) {
            if (begin < end) {
                int mid = (begin + end) / 2;
                sorted(begin, mid);
                sorted(mid + 1, end);
                merge(begin, mid, end);
            }
        }

        private void merge(int begin, int mid, int end) {
            int leftSubSize = mid - begin + 1;
            int[] larr = new int[leftSubSize];
            for (int i = 0; i < leftSubSize; i++) {
                larr[i] = this.values[begin + i];
            }

            int rightSubSize = end - mid;
            int[] rarr = new int[rightSubSize];
            for (int i = 0; i < rightSubSize; i++) {
                rarr[i] = this.values[mid + 1 + i];
            }

            int leftCursor = 0;
            int rightCursor = 0;
            int point = begin;
            while (leftCursor < leftSubSize && rightCursor < rightSubSize) {
                if (larr[leftCursor] <= rarr[rightCursor]) {
                    this.values[point] = larr[leftCursor++];
                } else {
                    this.values[point] = rarr[rightCursor++];
                }
                point++;
            }

            while (leftCursor < leftSubSize) {
                this.values[point++] = larr[leftCursor++];
            }

            while (rightCursor < rightSubSize) {
                this.values[point++] = rarr[rightCursor++];
            }
        }

        public void print() {
            StringBuilder sb = new StringBuilder();
            for (int value : this.values) {
                sb.append(value).append(' ');
            }
            System.out.println(sb);
        }
    }
}
