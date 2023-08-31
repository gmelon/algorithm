package nadongbin.dp.n7;

import java.util.Scanner;

public class 못생긴_수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // 풀이 시작
        int[] dp = new int[1001];
        dp[1] = 1;

        int current2Index = 1;
        int current3Index = 1;
        int current5Index = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[current2Index] * 2, Math.min(dp[current3Index] * 3, dp[current5Index] * 5));

            if (dp[i] == dp[current2Index] * 2) {
                // 현재 최소값이 dp[current2Index] * 2 이면, current2Index를 이동
                current2Index++;
            }
            if (dp[i] == dp[current3Index] * 3) {
                current3Index++;
            }
            if (dp[i] == dp[current5Index] * 5) {
                current5Index++;
            }
        }

        System.out.println(dp[n]);
    }
}
