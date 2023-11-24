package baekjoon;

import java.util.Scanner;

public class 피보나치수6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        fibo(n);
    }

    static int prevprev = 0;
    static int prev = 1;

    private static void fibo(long n) {
        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        for (long i = 2; i <= n; i++) {
            int current = (prevprev + prev) % 1_000_000_007;
            prevprev = prev;
            prev = current;
        }

        System.out.println(prev);
    }

}
