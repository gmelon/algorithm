package inflearn.dfs_bfs;

import java.util.Scanner;

public class P08_03 {

    private static int max = Integer.MIN_VALUE;
    private static int limit;

    public static void solution(int n, int m, int[] score, int[] time) {
        limit = m;
        DFS(score, time, 0, 0, 0);
        System.out.println(max);
    }

    public static void DFS(int[] score, int[] time, int index, int scoreSum, int timeSum) {
        // timeSum은 조건으로만 활용
        // scoreSum은 최대값 계산에만 활용
        if (timeSum > limit) {
            return;
        }
        if (index >= score.length) {
            max = Math.max(max, scoreSum);
        }
        else {
            DFS(score, time, index + 1, scoreSum + score[index], timeSum + time[index]);
            DFS(score, time, index + 1, scoreSum, timeSum);
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] score = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        solution(n, m, score, time);
    }
}