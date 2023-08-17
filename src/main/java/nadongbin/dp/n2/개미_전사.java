package nadongbin.dp.n2;

import java.util.Scanner;

public class 개미_전사 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] foods = new int[N];
        for (int i = 0; i < N; i++) {
            foods[i] = sc.nextInt();
        }
        sc.close();

        // 풀이 시작
        int[] dp = new int[N]; // dp[x]는 x까지 고려했을 때의 최대값
        dp[0] = foods[0];
        dp[1] = Math.max(foods[0], foods[1]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + foods[i]);
        }
        System.out.println(dp[N - 1]);
    }

}
