package inflearn.dfs_bfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P08_05 {

    private static int minCount = Integer.MAX_VALUE;
    private static int target;

    public static void solution(int n, Integer[] arr, int m) {
        target = m;
        // 큰 금액부터 탐색해야 적은 동전 개수로 목표에 도달할 확률이 크다
        Arrays.sort(arr, Collections.reverseOrder());
        DFS(arr, 0, 0);
        System.out.println(minCount);
    }

    public static void DFS(Integer[] arr, int sum, int count) {
        if (count >= minCount) {
            return;
        }
        if (sum > target) {
            return;
        }
        if (sum == target) {
            // count >= minCount면 이미 return 되므로 무조건 count < minCount
            minCount = count;
        }
        else {
            // arr의 원소 개수만큼 for-loop
            for (int i = 0; i < arr.length; i++) {
                DFS(arr, sum + arr[i], count + 1);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        solution(n, arr, m);
    }
}