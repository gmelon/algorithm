package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 앱 {

    static class Result {
        int currentMemories;
        int currentCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 프로세스 개수
        int M = sc.nextInt(); // 확보해야 하는 메모리
        List<Integer> memories = new ArrayList<>(N);
        List<Integer> costs = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            memories.add(sc.nextInt());
        }
        for (int i = 0; i < N; i++) {
            costs.add(sc.nextInt());
        }
        sc.close();

        // 풀이 시작
        int[][] dp = new int[N][2]; // [프로세스번호][사용여부 0,1]


    }

}
