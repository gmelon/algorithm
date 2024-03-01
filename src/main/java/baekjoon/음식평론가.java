package baekjoon;

import java.util.Scanner;

public class 음식평론가 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextByte();
        int M = sc.nextByte();

        sc.close();

        System.out.println((M / N - 1) * N);
    }

}
