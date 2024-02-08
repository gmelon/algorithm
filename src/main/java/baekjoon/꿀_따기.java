package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꿀_따기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] acc = new int[N + 1]; // 누적합
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            acc[i] = acc[i - 1] + arr[i];
        }
        br.close();

        int first = 1; // 첫번쨰 벌 위치
        if (arr[1] > arr[N]) {
            // 오른쪽 끝의 값이 첫번째 값보다 작으면, 첫번째 벌은 N에서 시작한다
            first = N;
        }

        // 두번째 벌의 위치를 결정
        int second = 0;
        int max = 0;
        int maxIndex = 0;
        if (first == 1) {
            // finish == N
            for (int i = 2; i < N; i++) {
                if (acc[N] - acc[i] > max) {
                    max = acc[N] - acc[i];
                    maxIndex = i;
                }
            }
            second = maxIndex;
        } else {
            // first == N
            // finish == 1
            for (int i = N - 2; i > 1; i--) {
                if (acc[i - 1] - acc[0] > max) {
                    max = acc[i - 1] - acc[0];
                    maxIndex = i;
                }
            }
            second = maxIndex;
        }

        int answer = 0;
        if (first == 1) {
            // finish == N
            answer += acc[N] - acc[1] - arr[second];
            answer += acc[N] - acc[second];
        } else {
            // first == N
            // finish == 1
            answer += acc[N - 1] - acc[0] - arr[second];
            answer += acc[second - 1] - acc[0];
        }

        System.out.println(answer);
    }
}
