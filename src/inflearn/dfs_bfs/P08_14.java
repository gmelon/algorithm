package inflearn.dfs_bfs;

import java.util.Scanner;

public class P08_14 {

    // 대각선 포함
    public static final int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    public static final int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static int solution(int[][] board, int n, int m) {

    }

    public static void DFS(int[][] board, int n, int curX, int curY) {

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(board, n, m));
    }
}