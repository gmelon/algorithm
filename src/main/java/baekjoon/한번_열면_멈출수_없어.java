package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 한번_열면_멈출수_없어 {
    static class Range {
        int start, end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Range> ranges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ranges.add(new Range(sc.nextInt(), sc.nextInt()));
        }
        sc.close();

        // 풀이 시작
        int change = 0; // 줄어든 수명의 합
        List<Integer> changes = new ArrayList<>(); // 각 단계에서의 스트레스 수치

        for (int i = 0; i < N; i++) {
            int currentValue = 0;

            Range current = ranges.get(i);
            Range next = ranges.get(i + 1);

            if (current.end < next.start) {
                currentValue = current.end;
            } else if (current.start > next.end) {
                currentValue = current.start;
            } else {

            }
        }
    }
}
