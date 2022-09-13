package inflearn.dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class P08_08 {

    private static int target;
    private static boolean[] check;
    private static int[] combination;
    private static String answer = "";

    public static void solution(int n, int f) {

        int[][] memorizationCombination = new int[n + 1][n + 1];
        combination = new int[n];
        for (int i = 0; i < n; i++) {
            // n-1C0 ~ n-1Cn-1 까지 구하기
            combination[i] = getCombination(memorizationCombination, n-1, i);
        }

        // 순열 구하고 조건 확인
        target = f;
        check = new boolean[n];
        int[] permutation = new int[n];

        DFS(permutation, 0, n);
        System.out.println(answer);
    }

    public static void DFS(int[] permutation, int index, int n) {
        if (!answer.equals("")) {
            return;
        }
        if (index >= n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += combination[i] * permutation[i];
            }
            if (sum == target) {
                answer = (Arrays.toString(permutation)).replaceAll("[^\\d ]", "");
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    permutation[index] = i+1;
                    DFS(permutation, index + 1, n);
                    check[i] = false;
                }
            }
        }

    }

    public static int getCombination(int[][] memorizationCombination, int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }
        if (memorizationCombination[n][r] != 0) {
            return memorizationCombination[n][r];
        }
        memorizationCombination[n][r] =
            getCombination(memorizationCombination, n - 1, r - 1) + getCombination(memorizationCombination, n - 1, r);
        return memorizationCombination[n][r];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();

        solution(n, f);
    }
}