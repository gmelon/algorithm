package nadongbin.dp.n1;

import java.util.Scanner;

public class N1_1로_만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        // 풀이 시작

        // 1에서 X를 만드는 최소 연산 횟수를 구한다
        int[] dp = new int[X + 1];
        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i / 5] + 1, dp[i]);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
        }
        System.out.println(dp[X]);
    }

}
