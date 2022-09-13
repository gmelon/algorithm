package inflearn.dfs_bfs;

import java.util.Scanner;

public class P08_07 {

    public static int solution(int n, int r) {
        int[][] arr = new int[n+1][r+1]; // 메모이제이션용 2차원 배열
        return DFS(arr, n, r);
    }

    public static int DFS(int[][] arr, int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }
        if (arr[n][r] != 0) {
            // 이미 계산한 값은 재활용
            return arr[n][r];
        }
        arr[n][r] = DFS(arr, n - 1, r - 1) + DFS(arr, n - 1, r);
        return arr[n][r];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(solution(n, r));
    }
}