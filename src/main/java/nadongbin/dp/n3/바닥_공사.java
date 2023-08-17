package nadongbin.dp.n3;

import java.util.Scanner;

public class 바닥_공사 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        // 풀이 시작
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 796_796;
        }
        System.out.println(dp[N]);
    }

}
