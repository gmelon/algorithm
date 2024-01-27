package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열 {

    static class Value {
        int value, from;

        public Value(int value, int from) {
            this.value = value;
            this.from = from;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Value[] dp = new Value[n];

        // 풀이 시작
        for (int i = 0; i < n; i++) {
            dp[i] = new Value(1, i); // 기본값 - 자기 자신만큼 증가
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[j].value >= dp[i].value) {
                    dp[i] = new Value(dp[j].value + 1, j);
                }
            }
        }

        // 최대값 찾기
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i].value > dp[maxIndex].value) {
                maxIndex = i;
            }
        }
        System.out.println(dp[maxIndex].value);

        // 구성 원소 찾기
        List<Integer> numbers = new ArrayList<>();
        int prev = 0;
        while (prev != maxIndex) {
            prev = maxIndex;
        }


    }
}

// 4
// 1 4 2 3

// 답 : 3, 출력 : 2

/**
 *   1 4 2 3
 * 1 0 1 1 1
 * 4 0 1 1 1
 * 2 0 1 1 2
 * 3 0 1 1 2
 *
 */
