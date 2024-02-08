package baekjoon;

import java.util.Scanner;

public class 이의멱수의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int[] dp = new int[N + 1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i - 1] + dp[i / 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        System.out.println(dp[N] % 1_000_000_000);
    }

}
