package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욕심쟁이_판다 {

    static class Position {

        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] board;
    static int[][] dp;
    static int n;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        // 풀이 시작
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(dfs(new Position(i, j)), answer);
            }
        }

        System.out.println(answer);
    }

    static int dfs(Position current) {
        if (dp[current.x][current.y] != 0) {
            return dp[current.x][current.y];
        }

        // 초기 설정
        dp[current.x][current.y] = 1;

        for (int i = 0; i < dx.length; i++) {
            int nextX = current.x + dx[i];
            int nextY = current.y + dy[i];

            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board.length) {
                continue;
            }

            if (board[nextX][nextY] > board[current.x][current.y]) {
                dp[current.x][current.y] = Math.max(dfs(new Position(nextX, nextY)) + 1, dp[current.x][current.y]);
            }
        }

        return dp[current.x][current.y];
    }

}
