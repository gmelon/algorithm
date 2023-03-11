package inflearn.dfs_bfs;

import java.util.Scanner;

public class P08_02 {

    private static int max = Integer.MIN_VALUE;
    private static int limit;

    public static void solution(int n, int c, int[] weight) {
        limit = c;
        DFS(weight, 0, 0);
        System.out.println(max);
    }

    public static void DFS(int[] weight, int index, int sum) {
        if (sum > limit) {
            return;
        }
        if (index >= weight.length) {
            max = Math.max(max, sum);
        }
        else {
            DFS(weight, index + 1, sum + weight[index]); // 현재 바둑이 포함
            DFS(weight, index + 1, sum); // 현재 바둑이 포함 X
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(n, c, arr);
    }
}