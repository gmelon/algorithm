package nadongbin.implementation.n4;

import java.util.Scanner;

public class N4_게임개발 {

    static class Player {

        int x, y;
        int direction;

        public Player(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        // 0:북, 1:동, 2:남, 3:서
        private final int[] dx = {-1, 0, 1, 0};
        private final int[] dy = {0, 1, 0, -1};

        public int nextX() {
            return x + dx[nextDirection()];
        }

        public int nextY() {
            return y + dy[nextDirection()];
        }

        public int backX() {
            return x - dx[direction];
        }

        public int backY() {
            return y - dy[direction];
        }

        public void move(int x, int y, boolean changeDirection) {
            this.x = x;
            this.y = y;
            if (changeDirection) {
                this.direction = nextDirection();
            }
        }

        private int nextDirection() {
            int direction = this.direction - 1;
            if (direction == -1) {
                return 3;
            }
            return direction;
        }
    }

    /*
        4 4
        1 1 0
        1 1 1 1
        1 0 0 1
        1 1 0 1
        1 1 1 1
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 세로 크기
        int M = sc.nextInt(); // 가로 크기

        // 초기 플레이어 정보
        Player currentPosition = new Player(sc.nextInt(), sc.nextInt(), sc.nextInt());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        sc.close();

        System.out.println(solution(N, M, currentPosition, map));
    }

    public static int solution(final int N, final int M, final Player currentPosition, final int[][] map) {
        boolean[][] visited = new boolean[N][M];
        visited[currentPosition.x][currentPosition.y] = true;

        int turnCount = 0;
        int moveCount = 0;
        while (true) {
            if (turnCount == 4) {
                int nextX = currentPosition.backX();
                int nextY = currentPosition.backY();
                if (checkRange(nextX, nextY, N, M) && map[nextX][nextY] == 1) { // 바다
                    break;
                }
                currentPosition.move(nextX, nextY, false);
                moveCount++;
                turnCount = 0;
            }
            else {
                int nextX = currentPosition.nextX();
                int nextY = currentPosition.nextY();
                if (checkRange(nextX, nextY, N, M) && map[nextX][nextY] == 0 && !visited[nextX][nextY]) { // 육지 && 방문X
                    currentPosition.move(nextX, nextY, true);
                    visited[nextX][nextY] = true;
                    moveCount++;
                    turnCount = 0;
                } else {
                    currentPosition.move(currentPosition.x, currentPosition.y, true);
                    turnCount++;
                }
            }
        }
        return moveCount;
    }

    public static boolean checkRange(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }


}
