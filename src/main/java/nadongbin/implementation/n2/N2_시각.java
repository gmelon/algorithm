package nadongbin.implementation.n2;

import java.util.Scanner;

public class N2_시각 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(solution(N));

        sc.close();
    }

    public static int solution(final int N) {
        int count = 0;
        for (int hour = 0; hour <= N; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                for (int second = 0; second < 60; second++) {
                    String time = hour + String.valueOf(minute) + second;
                    if (time.contains("3")) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
