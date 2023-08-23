package nadongbin.dp.n6;

import java.util.Scanner;

public class 퇴사 {

    static class Counseling {
        int time;
        int price;

        public Counseling(int time, int price) {
            this.time = time;
            this.price = price;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Counseling[] counselings = new Counseling[N];
        for (int i = 0; i < N; i++) {
            counselings[i] = new Counseling(sc.nextInt(), sc.nextInt());
        }

        sc.close();

        // 풀이 시작
        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int completeDate = i + counselings[i].time;
            if (completeDate <= N) {
                dp[completeDate] = Math.max(dp[completeDate], dp[i] + counselings[i].price);
            }

            // i번째가 비어있으면 이전의 최대값을 그대로 채워준다
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N]);
    }

}
