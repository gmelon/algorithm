package inflearn.dfs_bfs;

import java.util.Scanner;

public class P08_13 {

    // 대각선 포함
    public static final int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    public static final int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static int solution(int[][] board, int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    DFS(board, n, i, j);
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void DFS(int[][] board, int n, int curX, int curY) {
        for (int i = 0; i < dx.length; i++) {
            int newX = curX + dx[i];
            int newY = curY + dy[i];
            if (newX >= 1 && newX <= n && newY >= 1 && newY <= n && board[newX][newY] == 1) {
                board[newX][newY] = 0;
                DFS(board, n, newX, newY);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(board, n));
    }
}