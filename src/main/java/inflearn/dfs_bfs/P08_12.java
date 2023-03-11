package inflearn.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P08_12 {

    public static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int[][] board, int n, int m) {
        Queue<Point> Q = new LinkedList<>();
        int ripenTomato = 0;
        int nonTomato = 0;
        // 애초에 익어있던 토마토 위치 Q에 넣기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == -1) {
                    // 토마토가 아닌 칸의 개수
                    nonTomato++;
                }
                if (board[i][j] == 1) {
                    Q.offer(new Point(i, j));
                    // 이미 익은 토마토 개수
                    ripenTomato++;
                }
            }
        }

        if (ripenTomato == (n * m - nonTomato)) {
            // 모든 토마토가 이미 익어있는 상태
            return 0;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int dayUntilFinish = 0;

        while (!Q.isEmpty()) {
            int curLen = Q.size();
            for (int i = 0; i < curLen; i++) {
                // 레벨별로 처리하기 위해 현재 Q의 모든 원소를 처리한 후 다음 레벨로 진행
                Point curPoint = Q.poll();
                for (int j = 0; j < dx.length; j++) {
                    int newX = curPoint.x + dx[j];
                    int newY = curPoint.y + dy[j];
                    // 범위 내에 있으면서, 값이 0인 위치로만 이동
                    // 이동 시 값을 1로 변경하며 count
                    if (newX >= 1 && newX <= n && newY >= 1 && newY <= m && board[newX][newY] == 0) {
                        board[newX][newY] = 1; // 토마토 익히기
                        ripenTomato++;
                        Q.offer(new Point(newX, newY));
                    }
                }
            }
            // 마지막은 더해주지 않음
            if (!Q.isEmpty()) {
                dayUntilFinish++;
            }
        }
        if (ripenTomato == (n * m - nonTomato)) {
            // 모든 토마토가 이미 익어있는 상태
            return dayUntilFinish;
        } else {
            // 모든 토마토가 익을 수 없는 상황
            return -1;
        }
    }





    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] board = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(board, n, m));
    }
}