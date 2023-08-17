package nadongbin.dp.n4;

import java.util.Scanner;

public class 효율적인_화폐_구성 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt(); // 만들어야 할 금액

        int[] coins = new int[N]; // 동전들
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();

        // 풀이 시작
        int[] dp = new int[M + 1];
        // 초기화
        for (int i = 1; i <= M; i++) {
            dp[i] = 10_001;
        }

        for (int i = 1; i <= M; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        if (dp[M] != 10_001) {
            System.out.println(dp[M]);
        } else {
            System.out.println(-1);
        }
    }

}
