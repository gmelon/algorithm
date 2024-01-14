package swea;

import java.util.Scanner;

class 파리퇴치3 {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] board = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            // +, *
            int[][] dx = {{1, -1, 0, 0}, {-1, 1, -1, 1}};
            int[][] dy = {{0, 0, 1, -1}, {1, 1, -1, -1}};

            int answer = 0;

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    for (int type = 0; type < 2; type++) {
                        int count = board[x][y]; // 중심이 향한 칸부터 계산
                        for (int d = 0; d < 4; d++) {
                            count += count(x + dx[type][d], y + dy[type][d], dx[type][d], dy[type][d], board, m - 1);
                        }
                        answer = Math.max(count, answer);
                    }
                }
            }

            System.out.println("#" + testCase + " " + answer);
        }
    }

    static int count(int x, int y, int dx, int dy, int[][] board, int m) {
        if (m <= 0) {
            return 0;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board.length) {
            return 0;
        }

        int nextX = x + dx;
        int nextY = y + dy;
        if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board.length) {
            return board[x][y];
        }
        return count(nextX, nextY, dx, dy, board, m - 1) + board[x][y];
    }

}
